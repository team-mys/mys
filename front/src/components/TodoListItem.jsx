import {useState} from 'react';
import {twMerge} from 'tailwind-merge';
import {MdCheck, MdCheckBoxOutlineBlank, MdEdit} from 'react-icons/md';
import {IoMdTrash} from 'react-icons/io';

export default function TodoListItem() {
  const [isEditing, setIsEditing] = useState(false);
  const [editText, setEditText] = useState('');

  return (
    <div
      className="p-3 flex items-center [&:nth-child(even)]:bg-gray-100 [&+&]: border-t-1 border-gray-300">
      <div className={twMerge('cursor-pointer flex-1/2 flex items-center')}>
        {/*<MdCheckBox size={20} className="fill-orange-400 text-lg"/> */}
        <MdCheckBoxOutlineBlank size={20}/>
        {isEditing ? (
          <input
            type="text"
            onChange={(e) => {
              setEditText(e.target.value);
            }}
            className="mx-2 border-b border-b-gray-200 text-gray-700 outline-none"
          />
        ) : (
          <span className={twMerge('pl-1')}>텍스트</span>
        )}
      </div>
      {isEditing ? (
        <button onClick={() => {
          setIsEditing(false);
        }}
                className="text-gray-500 hover:text-gray-300">
          <MdCheck size={25}/>
        </button>
      ) : (
        <div
          className="flex items-center cursor-pointer text-gray-500 hover:text-gray-300"
          onClick={() => {
            setIsEditing(true);
          }}>
          <MdEdit size={25}/>
        </div>
      )}
      <div
        className="flex px-1.5 items-center cursor-pointer text-gray-500 hover:text-gray-300">
        <IoMdTrash size={25}/>
      </div>
    </div>
  );
}