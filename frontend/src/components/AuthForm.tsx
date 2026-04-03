import { type FormEvent, useState } from "react";
import { login, signup } from "../api/auth";
import { useNavigate } from "react-router";

export default function AuthForm({ auth }: { auth: "login" | "signup" }) {
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  async function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    setError(null);
    setLoading(true);

    const formData = new FormData(event.currentTarget);
    const email = formData.get("email") as string;
    const passwd = formData.get("passwd") as string;

    try {
      if (auth === "login") {
        await login({ email, passwd });
        navigate("/todos");
      } else {
        const name = formData.get("name") as string;
        await signup({ email, passwd, name });
        navigate("/auth/login");
      }
    } catch (e: unknown) {
      const msg = e instanceof Error ? e.message : "요청에 실패했습니다. 다시 시도해주세요.";
      setError(msg);
    } finally {
      setLoading(false);
    }
  }

  return (
    <form onSubmit={handleSubmit} className="w-full max-w-2/3">
      {auth === "signup" && (
        <div className="flex flex-col mb-5">
          <label htmlFor="name" className="mb-3 text-stone-600 font-medium">
            이름
          </label>
          <input
            type="text"
            id="name"
            name="name"
            required
            className="w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-lg shadow-md outline-none"
          />
        </div>
      )}
      <div className="flex flex-col">
        <label htmlFor="email" className="mb-3 text-stone-600 font-medium">
          이메일
        </label>
        <input
          type="email"
          id="email"
          name="email"
          required
          className="w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-lg shadow-md outline-none"
        />
      </div>
      <div className="flex flex-col my-5">
        <label htmlFor="passwd" className="mb-3 text-stone-600 font-medium">
          비밀번호
        </label>
        <input
          type="password"
          id="passwd"
          name="passwd"
          required
          className="w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-lg shadow-md outline-none"
        />
      </div>
      {error && <p className="text-red-500 text-sm mb-4">{error}</p>}
      <button
        type="submit"
        disabled={loading}
        className="px-6 py-3 bg-stone-700 rounded-xl text-white font-bold cursor-pointer hover:bg-stone-600 transition-all active:scale-95 disabled:opacity-50 disabled:cursor-not-allowed"
      >
        {loading ? "처리 중..." : auth === "login" ? "로그인" : "회원가입"}
      </button>
    </form>
  );
}
