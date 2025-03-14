import TodoListItem from './TodoListItem.jsx';

export default function TodoList() {
  return (
    <div className='min-h-[320px] max-h-[512px] overflow-y-auto'>
      <TodoListItem />
      <TodoListItem />
      <TodoListItem />
    </div>
  );
}
