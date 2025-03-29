import {useCallback, useContext} from 'react';
import {TodoContext, TodoDispatchContext} from '../context/TodoContext.jsx';

export function useTodos() {
  const context = useContext(TodoContext);
  if (context === null) {
    throw new Error('useTodos must be used within a TodoProvider');
  }
  return context;
}

export function useTodoDispatch() {
  const context = useContext(TodoDispatchContext);
  if (context === null) {
    throw new Error('useTodoDispatch must be used within a TodoProvider');
  }
  return context;
}

export function useCreateTodo() {
  const dispatch = useTodoDispatch();
  return useCallback((text) => {
    const todo = {
      id: Date.now(), // Using timestamp as unique id
      text,
      checked: false,
    };
    dispatch({ type: 'CREATE', todo });
  }, [dispatch]);
}

export function useDeleteTodo() {
  const dispatch = useTodoDispatch();
  return useCallback((id) => {
    dispatch({ type: 'DELETE', id });
  }, [dispatch]);
}

export function useCompleteTodo() {
  const dispatch = useTodoDispatch();
  return useCallback((id) => {
    dispatch({ type: 'COMPLETE', id });
  }, [dispatch]);
}

export function useUpdateTodo() {
  const dispatch = useTodoDispatch();
  return useCallback((id, text) => {
    dispatch({ type: 'UPDATE', id, text });
  }, [dispatch]);
}