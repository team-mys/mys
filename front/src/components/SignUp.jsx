import {MdClose} from 'react-icons/md';
import Modal from './layouts/Modal.jsx';
import {useCallback, useState} from 'react';
import {useAuth} from '../context/AuthContext.jsx';

export default function SignUpModal({onClose, toLogin}) {
  const {signup} = useAuth();
  const [form, setForm] = useState({
    userName: '',
    userPassword: '',
    userNickName: ''
  });

  const onSignUpChange = useCallback((e) => {
    setForm((prevForm) => ({ ...prevForm, [e.target.name]: e.target.value }));
  }, []);

  const onSignUpSubmit = useCallback(
    (e) => {
      e.preventDefault();
      signup(form);
      toLogin();
    },
    [form, signup]
  );

  return (
    <Modal>
      <div className="flex justify-between pb-2">
        <h2 className="text-2xl font-bold flex items-center">MYS에 회원가입</h2>
        <button
          onClick={onClose}
          className="bg-gray-200 px-3 py-1 rounded-full hover:bg-gray-300 cursor-pointer"
        >
          <MdClose size={25}/>
        </button>
      </div>
      <form className="flex flex-col gap-y-5" onSubmit={onSignUpSubmit}>
        <input
          onChange={onSignUpChange}
          type="name"
          name="userName"
          placeholder="이름"
          className="w-full p-2 border-b border-gray-200 outline-none"
        />
        <input
          onChange={onSignUpChange}
          name="userNickName"
          type="text"
          placeholder="아이디"
          className="w-full p-2 border-b border-gray-200 outline-none"
        />
        <input
          onChange={onSignUpChange}
          name="userPassword"
          type="password"
          placeholder="비밀번호"
          className="w-full p-2 border-b border-gray-200 outline-none"
        />
        <button
          type="submit"
          className="w-full bg-orange-400 text-white p-1.5 rounded cursor-pointer">
          회원가입 완료
        </button>
      </form>
    </Modal>
  );
}