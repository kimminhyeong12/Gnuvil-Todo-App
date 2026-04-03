import type { Todo } from "../types/todos";
import { instance } from "./axios";

export const getTodos = async (): Promise<Todo[]> => {
  const res = await instance.get("/todos");
  return res.data;
};

export const addTodo = async (name: string) => {
  await instance.post("/todos", { name });
};

export const deleteTodo = async (id: number) => {
  await instance.delete(`/todos/${id}`);
};

export const updateTodo = async ({ id, name }: { id: number; name: string }) => {
  await instance.put(`/todos/${id}`, { name });
};

export const toggleTodo = async (id: number): Promise<Todo> => {
  const res = await instance.patch(`/todos/${id}`);
  return res.data;
};
