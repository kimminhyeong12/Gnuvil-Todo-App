import { Link } from "react-router";

export default function Header() {
  return (
    <header className="fixed top-0 w-full flex justify-between p-5 bg-stone-800 text-white font-bold">
      <Link to="/todos" className="text-3xl">
        Todos
      </Link>
      <div className="flex gap-5 items-center">
        <Link to="/auth/login">로그인</Link>
        <Link to="/auth/signup">회원가입</Link>
      </div>
    </header>
  );
}
