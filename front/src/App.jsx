import Todos from './components/todos/Todos.jsx';
import {AuthProvider} from './context/AuthContext.jsx';

export default function App() {

  return (
    <>
      <AuthProvider>
        <Todos/>
      </AuthProvider>
    </>
  );
}