import TodoTemplate from './TodoTemplate.jsx';
import TodoInsert from './TodoInsert.jsx';
import SubHeader from '../layouts/SubHeader.jsx';
import TodoList from './TodoList.jsx';
import {TodoProvider} from '../../context/TodoContext.jsx';

export default function Todos() {
  return (
    <>
      <TodoProvider>
        <TodoTemplate>
          <TodoInsert/>
          <SubHeader/>
          <TodoList/>
        </TodoTemplate>
      </TodoProvider>
    </>
  );
}