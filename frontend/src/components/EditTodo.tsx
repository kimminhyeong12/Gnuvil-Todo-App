import { useState } from "react";

export default function EditTodo({
  todo,
  editTodo,
}: {
  todo: { id: number; title: string };
  editTodo: (id: number, title: string) => void;
}) {
  const [editInput, setEditInput] = useState(todo.title);
  return (
    <div className="flex gap-1 w-full">
      <input
        type="text"
        autoFocus
        className="flex-1 outline-none px-2 border-b border-stone-300 w-full"
        value={editInput}
        onChange={(e) => setEditInput(e.target.value)}
      />
      <button
        type="button"
        className="bg-stone-800 rounded-lg p-2 text-white"
        onClick={() => editTodo(todo.id, editInput)}
      >
        수정
      </button>
    </div>
  );
}
