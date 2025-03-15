import {useState} from 'react';
import LoginModal from './Login.jsx';
import SignUpModal from './SignUp.jsx';

export default function TodoTemplate({children}) {
  const [isLoginModalOpen, setIsLoginModalOpen] = useState(false);
  const [isSignUpModalOpen, setIsSignUpModalOpen] = useState(false);

  return (
    <div
      className="w-[768px] ml-auto mr-auto mt-2 rounded-sm overflow-hidden pt-5">
      <div
        className="bg-orange-400 text-white h-14 px-3 flex items-center justify-between">
        <h2 className="flex font-bold text-2xl">user의 투두리스트</h2>
        <button
          className="bg-orange-300 text-white px-2 py-1 rounded-md hover:bg-orange-600"
          onClick={() => setIsLoginModalOpen(true)}>Login
        </button>
      </div>
      <div className="bg-white">{children}</div>
      {isLoginModalOpen && (
        <LoginModal
          onClose={() => setIsLoginModalOpen(false)}
          toSignUp={() => {
            setIsLoginModalOpen(false);
            setIsSignUpModalOpen(true);
          }}
        />
      )}
      {isSignUpModalOpen && (
        <SignUpModal
          onClose={() => setIsSignUpModalOpen(false)}
          toLogin={() => {
            setIsSignUpModalOpen(false);
            setIsLoginModalOpen(true);
          }}
        />
      )}
    </div>
  );
}