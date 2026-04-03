import { useState } from "react";
import type { Todo } from "../types/todos";
import { useTodoMutation } from "../hooks/useTodoMutation";

interface EditTodoProps {
  todo: Todo;
  onClose: () => void;
}

export default function EditTodo({ todo, onClose }: EditTodoProps) {
  const { updateTodoMutation } = useTodoMutation();
  const [editInput, setEditInput] = useState(todo.name);

  const handleUpdate = () => {
    if (editInput.trim() === "") return;
    updateTodoMutation.mutate({ id: todo.id, name: editInput }, { onSuccess: onClose });
  };

  return (
    <div className="flex gap-1 w-full">
      <input
        type="text"
        autoFocus
        className="flex-1 outline-none px-2 border-b border-stone-300 w-full"
        value={editInput}
        onChange={(e) => setEditInput(e.target.value)}
        onKeyDown={(e) => {
          if (e.key === "Enter") handleUpdate();
          if (e.key === "Escape") onClose();
        }}
        onBlur={handleUpdate}
      />
      <button
        className="bg-stone-800 rounded-lg p-2 text-white"
        onMouseDown={(e) => {
          e.preventDefault();
          handleUpdate();
        }}
      >
        수정
      </button>
    </div>
  );
}
