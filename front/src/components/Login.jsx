import {MdClose} from 'react-icons/md';
import Modal from './layouts/Modal.jsx';
import {useAuth} from '../context/AuthContext.jsx';
import {useCallback, useState} from 'react';

export default function LoginModal({onClose, toSignUp}) {
  const {login} = useAuth();

  const [form, setForm] = useState({
    userNickName: '',
    userPassword: ''
  });

  const onLoginChange = useCallback((e) => {
    setForm((prevForm) => ({...prevForm, [e.target.name]: e.target.value}));
  }, []);

  const onLoginSubmit = useCallback(
    (e) => {
      e.preventDefault();
      login(form);
    },
    [form, login]
  );

  return (
    <Modal>
      <div className="flex justify-between pb-2">
        <h2 className="text-2xl font-bold flex items-center">MYS에 로그인</h2>
        <button
          onClick={onClose}
          className="bg-gray-200 px-3 py-1 rounded-full hover:bg-gray-300 cursor-pointer"
        >
          <MdClose size={25}/>
        </button>
      </div>
      <form onSubmit={onLoginSubmit} className="flex flex-col gap-y-5"
            autoComplete="off">
        <input
          onChange={onLoginChange}
          type="text"
          name="userId"
          placeholder="아이디"
          className="w-full p-2 border-b border-gray-200 outline-none"
        />
        <input
          onChange={onLoginChange}
          type="password"
          name="userPassword"
          placeholder="비밀번호"
          className="w-full p-2 border-b border-gray-200 outline-none"
        />
        <button type="submit"
                className="w-full bg-orange-400 text-white p-1.5 rounded cursor-pointer">
          로그인
        </button>
      </form>
      <button
        className="underline text-gray-600 dark:text-gray-200 cursor-pointer pt-1"
        onClick={toSignUp}
      >
        회원가입
      </button>
    </Modal>
  );
}