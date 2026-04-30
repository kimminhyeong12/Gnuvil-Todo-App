import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router";
import { useQueryClient } from "@tanstack/react-query";

export default function Header() {
  const [isLoggedIn, setIsLoggedIn] = useState(() => Boolean(localStorage.getItem("userId")));
  const navigate = useNavigate();
  const queryClient = useQueryClient();

  useEffect(() => {
    const syncLoginState = () => {
      setIsLoggedIn(Boolean(localStorage.getItem("userId")));
    };

    window.addEventListener("storage", syncLoginState);
    window.addEventListener("auth-change", syncLoginState);

    return () => {
      window.removeEventListener("storage", syncLoginState);
      window.removeEventListener("auth-change", syncLoginState);
    };
  }, []);

  function logout() {
    localStorage.removeItem("userId");
    queryClient.removeQueries({ queryKey: ["todos"] });
    setIsLoggedIn(false);
    navigate("/auth/login");
  }

  return (
    <header className="fixed top-0 w-full flex justify-between p-5 bg-stone-800 text-white font-bold">
      <Link to="/todos" className="text-3xl">
        Todos
      </Link>
      <div className="flex gap-5 items-center">
        {isLoggedIn ? (
          <button type="button" onClick={logout} className="cursor-pointer">
            로그아웃
          </button>
        ) : (
          <>
            <Link to="/auth/login">로그인</Link>
            <Link to="/auth/signup">회원가입</Link>
          </>
        )}
      </div>
    </header>
  );
}
