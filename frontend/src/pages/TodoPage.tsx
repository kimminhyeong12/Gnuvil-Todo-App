import { useState } from "react";
import AddTodo from "../components/AddTodo";
import EditTodo from "../components/EditTodo";
import TodoItem from "../components/TodoItem";
import { useQuery } from "@tanstack/react-query";
import { getTodos } from "../api/todos";
import type { Todo } from "../types/todos";

export default function TodoPage() {
  const [isEdit, setIsEdit] = useState<number | null>(null);

  const { data: todos } = useQuery<Todo[]>({
    queryKey: ["todos"],
    queryFn: getTodos,
    initialData: [],
  });

  function startEdit(todo: Todo) {
    setIsEdit(todo.id);
  }

  return (
    <div>
      <div className="min-w-3xl flex flex-col items-center bg-white p-10 rounded-4xl shadow-lg border border-stone-200">
        <h1 className="text-5xl font-black text-stone-800 mb-10 tracking-tight">오늘의 할 일</h1>
        <div className="w-full max-w-md flex flex-col gap-5">
          <AddTodo />
          <ul className="mt-10 space-y-3">
            {todos.length > 0 ? (
              todos.map((t) => (
                <li
                  key={t.id}
                  className="group w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-2xl flex items-center justify-between shadow-md"
                >
                  {isEdit === t.id ? (
                    <EditTodo todo={t} onClose={() => setIsEdit(null)} />
                  ) : (
                    <TodoItem startEdit={startEdit} todo={t} />
                  )}
                </li>
              ))
            ) : (
              <p className="text-stone-400 text-center animate-pulse">할 일을 등록하세요</p>
            )}
          </ul>
        </div>
      </div>
    </div>
  );
}
