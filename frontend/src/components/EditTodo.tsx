import { useState } from "react";
import { useTodoMutation } from "../hooks/useTodoMutation";

export default function EditTodo({ todo }: { todo: { id: string | number; title: string } }) {
  const { updateTodoMutation } = useTodoMutation();
  const [editInput, setEditInput] = useState(todo.title);
  return (
    <div className="flex gap-1 w-full">
      <input
        type="text"
        autoFocus
        className="flex-1 outline-none px-2 border-b border-stone-300 w-full"
        value={editInput}
        onChange={(e) => setEditInput(e.target.value)}
        onBlur={() => updateTodoMutation.mutate({ id: todo.id, title: editInput })}
      />
      <button
        className="bg-stone-800 rounded-lg p-2 text-white"
        onClick={() => updateTodoMutation.mutate({ id: todo.id, title: editInput })}
      >
        수정
      </button>
    </div>
  );
}
