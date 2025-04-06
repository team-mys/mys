import MainListItem from './MainListItem.jsx';
import {useTodos} from '../../hooks/useTodos.js';

export default function TodoList() {
  const todos = useTodos();
  console.log("Todos List:", todos); // 디버깅용 로그 추가

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