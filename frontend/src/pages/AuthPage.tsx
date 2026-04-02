import { Outlet, useLocation } from "react-router";

export default function AuthPage() {
  const { pathname } = useLocation();
  return (
    <div className="min-w-2xl flex flex-col items-center bg-white p-10 rounded-4xl shadow-lg border border-stone-200">
      <h1 className="text-4xl font-black text-stone-800 mb-10 tracking-tight">
        {pathname.includes("login") ? "로그인" : "회원가입"}
      </h1>
      <Outlet />
    </div>
  );
}
