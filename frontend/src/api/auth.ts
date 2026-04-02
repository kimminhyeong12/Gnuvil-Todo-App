import { instance } from "./axios";

export const login = async () => {
  const res = await instance.post("/auth/login");
  return res;
};

export const signup = async () => {
  const res = await instance.post("/auth/signup");
  return res;
};
