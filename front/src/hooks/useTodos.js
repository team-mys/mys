import {useCallback, useContext} from 'react';
import {TodoContext, TodoDispatchContext} from '../context/TodoContext.jsx';
// import axios from 'axios';

export function useTodos() {
  const context = useContext(TodoContext);
  if (context === null) {
    throw new Error('useTodos는 TodoProvider안에서 사용되어야 한다.');
  }
  return context;
}

export function useTodoDispatch() {
  const context = useContext(TodoDispatchContext);
  if (context === null) {
    throw new Error('useTodoDispatch는 TodoProvider안에서 사용되어야한다.');
  }
  return context;
}

export function useCreateTodo() {
  const dispatch = useTodoDispatch();
  return useCallback((text) => {
    const todo = {
      id: Date.now(),
      text,
      checked: false,
    };
    //todo: axios를 통한 api 통신 로직
    dispatch({ type: 'CREATE', todo });
  }, [dispatch]);
}

//export function useCreateTodo() {
//  const dispatch = useTodoDispatch();
//  return useCallback(async (text) => {
//    const todo = {
//      id: Date.now(),
//      text,
//      checked: false
//    };
//    try {
//      const response = await axios.post("", todo);
//      dispatch({type: 'CREATE', todo: response.data});
//    } catch (error) {
//      console.error("할일 추가 실패", error);
//    }
//  }, [dispatch]);
//}

export function useDeleteTodo() {
  const dispatch = useTodoDispatch();
  return useCallback((id) => {
    //todo: axios를 통한 api 통신 로직
    dispatch({ type: 'DELETE', id });
  }, [dispatch]);
}

export function useCompleteTodo() {
  const dispatch = useTodoDispatch();
  return useCallback((id) => {
    //todo: axios를 통한 api 통신 로직
    dispatch({ type: 'COMPLETE', id });
  }, [dispatch]);
}

export function useUpdateTodo() {
  const dispatch = useTodoDispatch();
  return useCallback((id, text) => {
    //todo: axios를 통한 api 통신 로직
    dispatch({ type: 'UPDATE', id, text });
  }, [dispatch]);
}