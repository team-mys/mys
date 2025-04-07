//const todoReducer = (todos, action) => {
//  switch (action.type) {
//    case 'CREATE':
//      return todos.concat(action.todo);
//    case 'DELETE':
//      return todos.filter((todo) => todo.mainTaskId !== action.id);
//    case 'UPDATE':
//      return todos.map((todo) =>
//        todo.mainTaskId === action.id
//          ? {
//            ...todo,
//            mainTaskContent: action.text,
//          }
//          : todo
//      );
//    case 'COMPLETE':
//      return todos.map((todo) =>
//        todo.mainTaskId === action.id
//          ? {
//            ...todo,
//            checked: !todo.checked,
//          }
//          : todo
//      );
//    default:
//      return todos;
//  }
//};
export default todoReducer;

function todoReducer(state, action) {
  switch (action.type) {
    case 'INIT':
      return action.todos;
    case 'CREATE':
      return [...state, action.todo];
    case 'DELETE':
      return state.filter((todo) => todo.id !== action.id);
    case 'COMPLETE':
      return state.map((todo) =>
        todo.id === action.id ? { ...todo, completed: !todo.completed } : todo
      );
    case 'UPDATE':
      return state.map((todo) =>
        todo.id === action.id ? { ...todo, text: action.text } : todo
      );
    default:
      throw new Error(`Unhandled action type: ${action.type}`);
  }
}