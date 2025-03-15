import TodoListItem from './TodoListItem.jsx';

export default function TodoList() {
  return (
    <div className='min-h-[480px] max-h-[768px] overflow-y-auto'>
      <TodoListItem />
      <TodoListItem />
      <TodoListItem />
    </div>
  );
}