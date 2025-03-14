import { MdAdd } from 'react-icons/md';

export default function TodoInsert() {
  return (
    <form className='flex bg-gray-600'>
      <input
        placeholder='할 일을 입력하세요'
        className='px-2.5 py-2 text-base font-mono text-white outline-none
              placeholder:text-gray-200 flex-1'
      />
      <button
        type='submit'
        className='bg-gray-400 text-white px-2 text-lg flex
               items-center cursor-pointer hover:bg-gray-300'
      >
        <MdAdd />
      </button>
    </form>
  );
}
