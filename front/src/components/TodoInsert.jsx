import {MdAdd} from 'react-icons/md';

export default function TodoInsert() {
  return (
    <form className="flex bg-gray-600">
      <input
        placeholder="할 일을 입력하세요"
        className="p-3 text-base font-mono font-semibold text-white outline-none
              placeholder:text-gray-200 placeholder:font-bold placeholder:font-sans flex-1"
      />
      <button
        type="submit"
        className="bg-gray-400 text-white px-3 text-lg flex
               items-center cursor-pointer hover:bg-gray-300"
      >
        <MdAdd size={20}/>
      </button>
    </form>
  );
}