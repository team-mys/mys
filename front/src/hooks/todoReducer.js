const todoReducer = (todos, action) => {
  switch (action.type) {
    case 'CREATE':
      return todos.concat(action.todo);
    case 'DELETE':
      return todos.filter((todo) => todo.id !== action.id);
    case 'UPDATE':
      return todos.map((todo) =>
        todo.id === action.id
          ? {
              ...todo,
              text: action.text,
            }
          : todo
      );
    case 'COMPLETE':
      return todos.map((todo) =>
        todo.id === action.id
          ? {
              ...todo,
              checked: !todo.checked,
            }
          : todo
      );
    default:
      return todos;
  }
};

export default todoReducer;