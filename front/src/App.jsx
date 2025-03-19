import TodoTemplate from './components/todos/TodoTemplate.jsx';
import TodoInsert from './components/todos/TodoInsert.jsx';
import TodoList from './components/todos/TodoList.jsx';
import { useReducer, useRef } from 'react';
import todoReducer from './hooks/todoReducer.js';
import SubHeader from './components/layouts/SubHeader.jsx';

export default function App() {
  const [todos, dispatch] = useReducer(todoReducer, []);

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