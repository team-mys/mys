import {useEffect, useState} from 'react';
import LoginModal from '../Login.jsx';
import SignUpModal from '../SignUp.jsx';
import {useAuth} from '../../context/AuthContext.jsx';
import Count from '../Count.jsx';

export default function TodoTemplate({children}) {
  const [isLoginModalOpen, setIsLoginModalOpen] = useState(false);
  const [isSignUpModalOpen, setIsSignUpModalOpen] = useState(false);
  const {user, logout} = useAuth();
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('accessToken');
    setIsLoggedIn(!!token);
  }, [user]);

  const userNickName = user?.userName || '사용자';

  return (
    <div
      className="w-[768px] ml-auto mr-auto mt-2 rounded-sm overflow-hidden pt-5">
      <div
        className="dark:bg-gray-800 bg-orange-400 text-white h-14 px-3 flex items-center justify-between">
        <h2 className="flex font-bold text-2xl">{userNickName}의 투두리스트</h2>
        <div className="flex items-center gap-3">
          <Count/>
          {isLoggedIn ? (
            <button
              className="bg-orange-300 text-white px-2 py-1 rounded-md hover:bg-orange-600 cursor-pointer"
              onClick={logout}
            >
              Logout
            </button>
          ) : (
            <button
              className="bg-orange-300 text-white px-2 py-1 rounded-md hover:bg-orange-600 cursor-pointer"
              onClick={() => setIsLoginModalOpen(true)}
            >
              Login
            </button>
          )}
        </div>
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