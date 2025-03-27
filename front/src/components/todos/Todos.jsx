import TodoTemplate from './TodoTemplate.jsx';
import TodoInsert from './TodoInsert.jsx';
import SubHeader from '../layouts/SubHeader.jsx';
import TodoList from './TodoList.jsx';
import {useReducer, useRef} from 'react';
import useTodo from '../../hooks/useTodo.js';

export default function Todos() {
  const [todos, dispatch] = useReducer(useTodo, []);

  // 고유값으로 사용될 id
  // ref를 사용하여 변수 담기
  const nextId = useRef(1);

  const onCreate = (text) => {
    const todo = {
      id: nextId.current,
      text,
      checked: false,
    };
    dispatch({ type: 'CREATE', todo });
    nextId.current += 1;
  };

  const onDelete = (id) => {
    dispatch({ type: 'DELETE', id });
  };

  const onComplete = (id) => {
    dispatch({ type: 'COMPLETE', id });
  };

  const onUpdate = (id, text) => {
    dispatch({ type: 'UPDATE', id, text });
  };

  return (
    <>
      <TodoTemplate>
        <TodoInsert onCreate={onCreate} />
        <SubHeader />
        <TodoList
          todos={todos}
          onDelete={onDelete}
          onComplete={onComplete}
          onUpdate={onUpdate}
        />
      </TodoTemplate>
    </>
  );
}