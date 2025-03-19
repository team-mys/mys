import { IoMdRefresh } from 'react-icons/io';

export default function Count() {
  return (
    <div className='flex flex-row rounded-md bg-gray-600 pl-2 pr-1 py-1 gap-2'>
      <h2 className='text-base'>남은 시간 00:00</h2>
      <button className='bg-gray-400 px-1 rounded-sm cursor-pointer hover:bg-gray-300'>
        <IoMdRefresh />
      </button>
    </div>
  );
}