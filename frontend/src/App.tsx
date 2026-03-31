import { useState } from "react";
import AddTodo from "./components/AddTodo";
import EditTodo from "./components/EditTodo";
import TodoItem from "./components/TodoItem";

interface Todo {
  id: number;
  title: string;
}

function App() {
  const [isEdit, setIsEdit] = useState<number | null>(null);
  const [todos, setTodos] = useState<Todo[]>([]);

  function addTodo(title: string) {
    if (title.trim() === "") return;
    setTodos((prevTodos) => {
      return [...prevTodos, { id: Date.now(), title }];
    });
  }

  function deleteTodo(id: number) {
    setTodos((prevTodos) => {
      return prevTodos.filter((todo) => todo.id !== id);
    });
  }

  function editTodo(id: number, title: string) {
    if (title.trim() === "") return;
    setTodos((prevTodos) => {
      return prevTodos.map((todo) => {
        return todo.id === id ? { ...todo, title: title } : todo;
      });
    });

    setIsEdit(null);
  }

  function startEdit(todo: Todo) {
    setIsEdit(todo.id);
  }

  return (
    <div className="w-full min-h-screen bg-stone-100 flex flex-col items-center justify-center p-20 font-sans">
      <div className="min-w-4xl flex flex-col items-center bg-white p-10 rounded-4xl shadow-lg border border-stone-200">
        {/* 타이틀 영역 */}
        <h1 className="text-5xl font-black text-stone-800 mb-10 tracking-tight">To do</h1>

        <div className="w-full max-w-md flex flex-col gap-5">
          {/* 할 일 추가 영역 */}
          <AddTodo addTodo={addTodo} />
          {/* 할 일 목록 영역 */}
          <ul className="mt-10 space-y-3">
            {todos.length > 0 ? (
              todos.map((t) => (
                <li
                  key={t.id}
                  className="group w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-2xl flex items-center justify-between shadow-md"
                >
                  {isEdit === t.id ? (
                    <EditTodo todo={t} editTodo={editTodo} />
                  ) : (
                    <TodoItem startEdit={startEdit} deleteTodo={deleteTodo} todo={t} />
                  )}
                </li>
              ))
            ) : (
              <p className="text-stone-600 text-center">등록된 할 일이 없습니다!</p>
            )}
          </ul>
        </div>
      </div>
    </div>
  );
}

export default App;
