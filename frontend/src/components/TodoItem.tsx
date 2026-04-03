import type { Todo } from "../types/todos";
import { useTodoMutation } from "../hooks/useTodoMutation";

interface TodoItemProps {
  startEdit: (todo: Todo) => void;
  todo: Todo;
}

export default function TodoItem({ startEdit, todo }: TodoItemProps) {
  const { deleteTodoMutation, toggleTodoMutation } = useTodoMutation();

  return (
    <>
      <div className="flex items-center gap-4 w-full">
        <input
          type="checkbox"
          className="w-5 h-5 accent-stone-800 cursor-pointer"
          checked={todo.completed}
          onChange={() => toggleTodoMutation.mutate(todo.id)}
        />
        <p
          className={`w-full text-stone-600 font-medium group-hover:text-stone-900 transition-all ${
            todo.completed ? "line-through opacity-50" : ""
          }`}
          onDoubleClick={() => startEdit(todo)}
        >
          {todo.name}
        </p>
      </div>
      <button
        className="text-stone-300 hover:text-red-700 transition-colors font-bold pr-1 cursor-pointer"
        onClick={() => deleteTodoMutation.mutate(todo.id)}
      >
        X
      </button>
    </>
  );
}
