import {useCallback, useContext} from 'react';
import {TodoContext, TodoDispatchContext} from '../context/TodoContext.jsx';
import axios from 'axios';

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
  return useCallback(async (text) => {
    const token = localStorage.getItem('accessToken');
    if (!token) {
      console.error('JWT 토큰이 없습니다. 로그인 후 시도하세요.');
      return;
    }

    try {
      const todo = {mainTaskContent: text};
      console.log("보내는 데이터:", todo);

      const response = await axios.post(import.meta.env.VITE_MAIN_POST, todo, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        }
      });

      dispatch({type: 'CREATE', todo: response.data});
    } catch (error) {
      console.error('할 일 추가 실패:', error.response?.data || error.message);
    }
  }, [dispatch]);
}

export function useDeleteTodo() {
  const dispatch = useTodoDispatch();

  return useCallback(async (id) => {
    console.log('삭제할 id:', id);
    try {
      const token = localStorage.getItem('accessToken');
      const url = `http://59.24.237.51:8080/api/v1/maintask/${id}`

      const response = await axios.delete(url, {
        headers: {
         'Authorization': `Bearer ${token}`,
        }
      });

      if (response.status === 200 || response.status === 204) {
        dispatch({ type: 'DELETE', id });
      }
    } catch (error) {
      console.error('할 일 삭제 중 오류 발생:', error);
      console.error('에러 응답 메시지:', error.response?.data);
    }
  }, [dispatch]);
}

export function useCompleteTodo() {
  const dispatch = useTodoDispatch();
  return useCallback((id) => {
    //todo: axios를 통한 api 통신 로직
    dispatch({type: 'COMPLETE', id});
  }, [dispatch]);
}

export function useUpdateTodo() {
  const dispatch = useTodoDispatch();

  return useCallback(async (id, text) => {
    const token = localStorage.getItem('accessToken');
    try {
      const todo = {
        mainTaskContent: text,
        mainTaskId: id
      };

      console.log('보낼 데이터:', todo);
      const response = await axios.put(`http://59.24.237.51:8080/api/v1/maintask`, todo, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        }
      });
      const updatedTodo = response.data;

      if (response.status === 200 || response.status === 201) {
        dispatch({
          type: 'UPDATE', id, text
        });
        console.log('할 일 업데이트 성공:', updatedTodo);
      }
    } catch (error) {
      console.error('할 일 업데이트 실패:', error.response?.data || error.message);
    }
  }, [dispatch]);
}

export function useFetchTodos() {
  const dispatch = useTodoDispatch();

  return useCallback(async (userId) => {
    const token = localStorage.getItem('accessToken');
    if (!token) {
      console.error('JWT 토큰이 없습니다. 로그인 후 시도하세요.');
      return;
    }

    try {
      const response = await axios.get(`http://59.24.237.51:8080/api/v1/maintasks/all`, {
        params: { userId },
        headers: {
          'Authorization': `Bearer ${token}`
        }
      });
      const todos = response.data.mainTaskList;
      console.log('불러온 todos:', todos);
      dispatch({ type: 'INIT', todos });
    } catch (error) {
      console.error('할 일 목록 가져오기 실패:', error.response?.data || error.message);
    }
  }, [dispatch]);
}