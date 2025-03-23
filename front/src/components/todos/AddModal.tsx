import Modal from '../layouts/Modal.jsx'
import {MdClose} from 'react-icons/md';
import {useCallback, useState} from 'react';
export default function AddModal({onClose, onCreate}) {
  const [value, setValue] = useState('');

  const onChange = useCallback(e => {
    setValue(e.target.value);
  }, [])

  const onSubmit = useCallback(e => {
      // submit 이벤트는 브라우저에서 새로고침 발생
      e.preventDefault(); // 새로고침 방지
      if (!value.trim()) return; // 공백일 경우 return
      onCreate(value);
      setValue(''); // value 값 초기화
    },
    [onCreate, value]
  );

  return (
    <Modal>
      <div className='flex justify-between pb-2'>
        <h2 className='text-xl font-bold flex items-center'>text에 대한 하위 항목 추가하기</h2>
        <button
          onClick={onClose}
          className='bg-gray-200 px-1.5 py-1 rounded-full hover:bg-gray-300 cursor-pointer'
        >
          <MdClose size={20} />
        </button>
      </div>
      <form className='flex justify-between gap-x-2 rounded-md' onSubmit={onSubmit}>
        <input
          value={value}
          onChange={onChange}
          type='text'
          placeholder='하위 항목 추가하기'
          className='w-full p-2 border border-gray-200 outline-none'
        />
        <button className='bg-orange-400 text-white w-14 rounded cursor-pointer'>
          추가
        </button>
      </form>
    </Modal>
  )
}