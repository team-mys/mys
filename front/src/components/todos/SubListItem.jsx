import { useState } from 'react';
import { MdCheck, MdCheckBoxOutlineBlank, MdEdit } from 'react-icons/md';
import { IoMdTrash } from 'react-icons/io';
import { BsArrowReturnRight } from 'react-icons/bs';

export default function SubListItem() {
  const [isEditing, setIsEditing] = useState(false);
  const [editText, setEditText] = useState('');

  return (
    <div className='p-3.5 flex items-center [&:nth-child(even)]:bg-gray-100 [&+&]: border-t-1 border-gray-300'>
      <div className='pl-3 pr-2'>
        <BsArrowReturnRight size={25} className='stroke-[0.5] text-gray-600' />
      </div>
      <div className='flex-1/2 flex items-center'>
        {/*<MdCheckBox size={20} className="fill-orange-400 text-lg"/> */}
        <MdCheckBoxOutlineBlank size={23} className='fill-orange-400' />
        {isEditing ? (
          <input
            type='text'
            onChange={(e) => {
              setEditText(e.target.value);
            }}
            className='ml-2 mr-5 border-b w-[520px] border-b-gray-300 text-gray-700 outline-none'
          />
        ) : (
          <span className='pl-1'>텍스트</span>
        )}
      </div>
      {isEditing ? (
        <button
          onClick={() => {
            setIsEditing(false);
          }}
          className='text-gray-500 cursor-pointer hover:text-gray-300 rounded-full border p-0.5 border-gray-500'
        >
          <MdCheck size={22} />
        </button>
      ) : (
        <button
          className='flex items-center cursor-pointer text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500'
          onClick={() => {
            setIsEditing(true);
          }}
        >
          <MdEdit size={22} />
        </button>
      )}
      <button className='flex items-center cursor-pointer mx-3 text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500'>
        <IoMdTrash size={22} />
      </button>
    </div>
  );
}