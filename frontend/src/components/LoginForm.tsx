export default function LoginForm() {
  return (
    <form className="w-full max-w-2/3">
      <div className="flex flex-col ">
        <label htmlFor="email">Email</label>
        <input
          type="email"
          id="email"
          className="group w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-2xl flex items-center justify-between shadow-md outline-none"
        />
      </div>
      <div className="flex flex-col my-5">
        <label htmlFor="password">Password</label>
        <input
          type="password"
          id="password"
          className="group w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-2xl flex items-center justify-between shadow-md outline-none"
        />
      </div>
      <button className="px-6 py-3 bg-stone-700 rounded-xl text-white font-bold cursor-pointer hover:bg-stone-600 transition-all active:scale-95">
        Login
      </button>
    </form>
  );
}
