import Modal from './Modal.jsx';
import {MdClose} from 'react-icons/md';

export default function LoginModal({onClose, toSignUp}) {
  return (
    <Modal>
      <div className="flex justify-between pb-2">
        <h2 className="text-2xl font-bold flex items-center">MYS에 로그인</h2>
        <button onClick={onClose}
                className="bg-gray-200 px-3 py-1 rounded-full hover:bg-gray-300"><MdClose size={25}/>
        </button>
      </div>
      <form className="flex flex-col gap-y-5">
        <input type="text" placeholder="아이디"
               className="w-full p-2 border-b border-gray-200 outline-none"/>
        <input type="password" placeholder="비밀번호"
               className="w-full p-2 border-b border-gray-200 outline-none"/>
        <button className="w-full bg-orange-400 text-white p-1.5 rounded">로그인
        </button>
      </form>
      <button className="underline text-gray-600" onClick={toSignUp}>회원가입
      </button>
    </Modal>
  );
}