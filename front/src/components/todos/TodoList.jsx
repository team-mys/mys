import MainListItem from './MainListItem.jsx';

export default function TodoList({ todos, onDelete, onComplete }) {
  return (
    <div className='min-h-[480px] max-h-[768px] overflow-y-auto'>
      {todos.map((todo) => (
        <MainListItem
          key={todo.id}
          todo={todo}
          onDelete={onDelete}
          onComplete={onComplete}
        />
      ))}
    </div>
  );
}