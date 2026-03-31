import { instance } from "./axios";

export const getTodos = async () => {
  const res = await instance.get("/todos");
  return res;
};

export const addTodo = async (title: string) => {
  await instance.post("/todos", { title });
};

export const deleteTodo = async (id: number) => {
  await instance.delete(`/todos/${id}`);
};

export const updateTodo = async (id: number, title: string) => {
  await instance.put(`/todos/${id}`, { id, title });
};
