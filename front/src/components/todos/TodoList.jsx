import { useEffect } from 'react';
import MainListItem from './MainListItem.jsx';
import { useTodos, useFetchTodos } from '../../hooks/useTodos.js';

export default function TodoList({ userInfo }) {
  const todos = useTodos();
  const fetchTodos = useFetchTodos();

  useEffect(() => {
    console.log('userInfo:', userInfo);
    if (userInfo?.userId) {
      fetchTodos(userInfo.userId);
    }
  }, [userInfo?.userId, fetchTodos]);

  return (
    <div className="min-h-[480px] max-h-[768px] overflow-y-auto dark:bg-gray-900">
      {todos.map((todo) => (
        <MainListItem
          key={todo.id}
          todo={todo}
        />
      ))}
    </div>
  );
}