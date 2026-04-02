import { createBrowserRouter, Outlet, RouterProvider } from "react-router";
import TodoPage from "./pages/TodoPage";
import AuthPage from "./pages/AuthPage";
import Header from "./components/Header";
import AuthForm from "./components/AuthForm";

const router = createBrowserRouter([
  {
    path: "/",
    element: (
      <div className="w-full min-h-screen bg-stone-100">
        <Header />
        <div className="min-h-screen flex flex-col items-center justify-center p-20">
          <Outlet />
        </div>
      </div>
    ),
    children: [
      {
        path: "todos",
        element: <TodoPage />,
      },
      {
        path: "auth",
        element: <AuthPage />,
        children: [
          { path: "login", element: <AuthForm auth="login" /> },
          { path: "signup", element: <AuthForm auth="signup" /> },
        ],
      },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
