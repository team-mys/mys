import {createContext, useReducer} from 'react';
import todoReducer from '../reducer/todoReducer.js';

export const TodoContext = createContext(null);
export const TodoDispatchContext = createContext(null);


export function TodoProvider({ children }) {
  const [todos, dispatch] = useReducer(todoReducer, []);

  return (
    <TodoContext.Provider value={todos}>
      <TodoDispatchContext.Provider value={dispatch}>
        {children}
      </TodoDispatchContext.Provider>
    </TodoContext.Provider>
  );
}