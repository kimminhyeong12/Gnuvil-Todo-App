import axios from "axios";

export const instance = axios.create({
  baseURL: "http://localhost:8080/api",
  timeout: 5000,
});

instance.interceptors.request.use((config) => {
  const userId = localStorage.getItem("userId");

  if (userId) {
    config.headers["X-USER-ID"] = userId;
  }

  return config;
});
