import { instance } from "./axios";

interface AuthPayload {
  email: string;
  passwd: string;
}

export const login = async (payload: AuthPayload) => {
  const res = await instance.post("/users/login", payload);
  return res.data;
};

export const signup = async (payload: AuthPayload & { name: string }) => {
  const res = await instance.post("/users/signup", payload);
  return res.data;
};
