import { twMerge } from 'tailwind-merge';
import { MdCheckBoxOutlineBlank, MdEdit } from 'react-icons/md';
import { IoMdTrash } from 'react-icons/io';

export default function TodoListItem() {
  return (
    <div className='p-2.5 flex items-center [&:nth-child(even)]:bg-[#f8f9fa] [&+&]: border-t-1 border-[#dee2e6]'>
      <div className={twMerge('cursor-pointer flex-1/2 flex items-center')}>
        {/*<MdCheckBox size={20} className="fill-orange-400 text-lg"/> */}
        <MdCheckBoxOutlineBlank size={20} />
        <span className={twMerge('pl-1')}>텍스트</span>
      </div>
      <div className='flex items-center cursor-pointer text-gray-500 hover:text-gray-300'>
        <MdEdit size={20} />
      </div>
      <div className='flex px-1.5 items-center cursor-pointer text-gray-500 hover:text-gray-300'>
        <IoMdTrash size={20} />
      </div>
    </div>
  );
}
