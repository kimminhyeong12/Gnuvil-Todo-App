export default function TodoItem({
  startEdit,
  deleteTodo,
  todo,
}: {
  startEdit: (todo: { id: number; title: string }) => void;
  deleteTodo: (id: number) => void;
  todo: { id: number; title: string };
}) {
  return (
    <>
      <div className="flex items-center gap-4">
        <input
          type="checkbox"
          className="w-5 h-5 accent-stone-800 cursor-pointer"
          onChange={(e) => console.log(e.target.checked)}
        />
        <p className="text-stone-600 font-medium group-hover:text-stone-900" onDoubleClick={() => startEdit(todo)}>
          {todo.title}
        </p>
      </div>
      <button
        className="text-stone-300 hover:text-red-700 transition-colors font-bold pr-1 cursor-pointer"
        onClick={() => deleteTodo(todo.id)}
      >
        X
      </button>
    </>
  );
}
