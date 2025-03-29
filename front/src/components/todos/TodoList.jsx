import MainListItem from './MainListItem.jsx';
import {useTodos} from '../../hooks/useTodos.js';

export default function TodoList() {
  const todos = useTodos();

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