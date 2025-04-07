import Modal from '../layouts/Modal.jsx';
import {MdClose} from 'react-icons/md';
import {useState} from 'react';
import {useUpdateTodo} from '../../hooks/useTodos.js';

export default function MainEdit({todo, onClose}) {
  const [editText, setEditText] = useState(todo.mainTaskContent);
  const updateTodo = useUpdateTodo();

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!editText.trim()) return;

    try {
      console.log('보내는 데이터:', {
        mainTaskId: todo.mainTaskId,
        mainTaskContent: editText
      });
      await updateTodo(todo.mainTaskId, editText); // 서버에 업데이트 요청
      onClose(); // 성공 시 모달 닫기
    } catch (error) {
      console.error('업데이트 중 에러:', error);
      alert('업데이트에 실패했습니다. 다시 시도해 주세요.');
    }
  };

  return (
    <Modal>
      <div className="flex justify-between pb-2">
        <h2 className="text-xl font-bold flex items-center">
          {todo?.mainTaskId}번 할 일 수정하기
        </h2>
        <button
          onClick={onClose}
          className="bg-gray-200 px-1.5 py-1 rounded-full hover:bg-gray-300 cursor-pointer"
        >
          <MdClose size={20}/>
        </button>
      </div>
      <form onSubmit={handleSubmit}
            className="flex justify-between gap-x-2 rounded-md">
        <input
          type="text"
          value={editText}
          onChange={(e) => setEditText(e.target.value)}
          placeholder="TodoList 메인항목 수정하기"
          className="w-full p-2 border border-gray-200 outline-none"
        />
        <button
          type="submit"
          className="bg-orange-400 text-white w-14 rounded cursor-pointer"
        >
          수정
        </button>
      </form>
    </Modal>
  );
}