import Modal from '../layouts/Modal.jsx';
import { MdClose } from 'react-icons/md';
import {useState} from 'react';

export default function MainEdit({todo, onClose, onSave }) {
  const [editText, setEditText] = useState(todo.text);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!editText.trim()) return;
    onSave(editText);
    onClose();
  };

  return (
    <Modal>
      <div className='flex justify-between pb-2'>
        <h2 className='text-xl font-bold flex items-center'>
          id번 할 일 수정하기
        </h2>
        <button
          onClick={onClose}
          className='bg-gray-200 px-1.5 py-1 rounded-full hover:bg-gray-300 cursor-pointer'
        >
          <MdClose size={20} />
        </button>
      </div>
      <form onSubmit={handleSubmit} className='flex justify-between gap-x-2 rounded-md'>
        <input
          type='text'
          value={editText}
          onChange={(e) => setEditText(e.target.value)}
          placeholder='TodoList 메인항목 수정하기'
          className='w-full p-2 border border-gray-200 outline-none'
        />
        <button
          type='submit'
          className='bg-orange-400 text-white w-14 rounded cursor-pointer'
        >
          수정
        </button>
      </form>
    </Modal>
  );
}