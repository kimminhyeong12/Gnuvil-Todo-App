import { QueryClient, useMutation } from "@tanstack/react-query";
import { addTodo, deleteTodo, updateTodo } from "../api/todos";

export function useTodoMutation() {
  const queryClient = new QueryClient();
  const addTodoMutation = useMutation({
    mutationFn: addTodo,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["todos"] });
    },
  });

  const deleteTodoMutation = useMutation({
    mutationFn: deleteTodo,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["todos"] });
    },
  });

  const updateTodoMutation = useMutation({
    mutationFn: updateTodo,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["todos"] });
    },
  });

  return { addTodoMutation, deleteTodoMutation, updateTodoMutation };
}
