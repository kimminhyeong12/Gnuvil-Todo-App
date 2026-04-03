import { useQueryClient, useMutation } from "@tanstack/react-query";
import { addTodo, deleteTodo, updateTodo, toggleTodo } from "../api/todos";

export function useTodoMutation() {
  const queryClient = useQueryClient();

  const invalidateTodos = () => queryClient.invalidateQueries({ queryKey: ["todos"] });

  const addTodoMutation = useMutation({
    mutationFn: addTodo,
    onSuccess: invalidateTodos,
  });

  const deleteTodoMutation = useMutation({
    mutationFn: deleteTodo,
    onSuccess: invalidateTodos,
  });

  const updateTodoMutation = useMutation({
    mutationFn: updateTodo,
    onSuccess: invalidateTodos,
  });

  const toggleTodoMutation = useMutation({
    mutationFn: toggleTodo,
    onSuccess: invalidateTodos,
  });

  return { addTodoMutation, deleteTodoMutation, updateTodoMutation, toggleTodoMutation };
}
