import { useState } from "react";

export default function AddTodo({ addTodo }: { addTodo: (title: string) => void }) {
  const [userInput, setUserInput] = useState("");

  return (
    <form
      className="flex gap-3 items-center bg-white p-2 rounded-lg shadow-md border border-stone-200"
      onSubmit={(e) => {
        e.preventDefault();
        addTodo(userInput);
        setUserInput("");
      }}
    >
      <input
        type="text"
        placeholder="할 일을 추가해보세요!"
        className="flex-1 px-4 py-2 outline-none text-stone-700 bg-transparent"
        value={userInput}
        onChange={(e) => setUserInput(e.target.value)}
      />
      <button className="bg-stone-800 hover:bg-stone-700 cursor-pointer text-white w-10 h-10 rounded-xl transition-all flex items-center justify-center shadow-md">
        <span className="text-2xl mb-1">+</span>
      </button>
    </form>
  );
}
