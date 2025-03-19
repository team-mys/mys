import { useState } from 'react';
import { twMerge } from 'tailwind-merge';
import {
  MdAdd,
  MdCheck,
  MdCheckBox,
  MdCheckBoxOutlineBlank,
  MdEdit,
} from 'react-icons/md';
import { IoMdTrash } from 'react-icons/io';

export default function MainListItem({ todo, onDelete, onComplete, onUpdate }) {
  const { id, text, checked } = todo;

  const [isEditing, setIsEditing] = useState(false);
  const [editText, setEditText] = useState(text);
  const [showSubListItem, setShowSubListItem] = useState(false);

  return (
    <div className='p-3.5 flex items-center [&:nth-child(even)]:bg-zinc-100 [&+&]: border-t-1 border-gray-300'>
      <div
        onClick={() => onComplete(id)}
        className={twMerge(
          'flex-1/2 flex items-center',
          checked ? '[svg]:text-xl line-through text-gray-500' : ''
        )}
      >
        {checked ? (
          <MdCheckBox size={25} className='fill-orange-400 text-lg' />
        ) : (
          <MdCheckBoxOutlineBlank size={25} className='fill-orange-400' />
        )}
        {isEditing ? (
          <input
            type='text'
            value={editText}
            onChange={(e) => {
              setEditText(e.target.value);
            }}
            className='ml-2 mr-6 w-[560px] border-b border-b-gray-300 text-gray-700 outline-none'
          />
        ) : (
          <span className='pl-1'>{text}</span>
        )}
      </div>
      <div className='flex items-center cursor-pointer px-2'>
        {isEditing ? (
          <button
            onClick={() => {
              onUpdate(id, editText);
              setIsEditing(false);
            }}
            className='text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500'
          >
            <MdCheck size={22} />
          </button>
        ) : (
          <button
            className='text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500'
            onClick={() => {
              setIsEditing(true);
            }}
          >
            <MdEdit size={22} />
          </button>
        )}
      </div>
      <div className='cursor-pointer flex items-center gap-2'>
        <button
          onClick={() => onDelete(id)}
          className='text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500'
        >
          <IoMdTrash size={22} />
        </button>
        <button
          onClick={() => {
            setShowSubListItem(true);
          }}
          className='text-gray-500 hover:text-gray-300  rounded-full border p-0.5 border-gray-500'
        >
          <MdAdd size={22} />
        </button>
      </div>
    </div>
  );
}