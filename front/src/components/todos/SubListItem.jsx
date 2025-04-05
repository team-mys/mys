import React, {useState} from 'react';
import {MdCheckBox, MdCheckBoxOutlineBlank, MdEdit} from 'react-icons/md';
import {IoMdTrash} from 'react-icons/io';
import {BsArrowReturnRight} from 'react-icons/bs';
import {twMerge} from 'tailwind-merge';
import SubEdit from './SubEdit.jsx';

function SubListItem({todo, onDelete, onComplete, onUpdate}) {
  const {id, text, checked} = todo;

  const [isEditing, setIsEditing] = useState(false);
  const [editText, setEditText] = useState(text);

  return (
    <div
      className="p-3.5 flex items-center bg-white dark:bg-gray-600 dark:border-gray-700 border-b border-gray-300">
      <div className="pl-3 pr-2">
        <BsArrowReturnRight size={25}
                            className="stroke-[0.5] text-gray-600 dark:text-gray-950"/>
      </div>
      <button onClick={() => onComplete(id)}
              className="flex items-center">
        {checked ? (
          <MdCheckBox size={25} className="fill-orange-400 text-lg"/>
        ) : (
          <MdCheckBoxOutlineBlank size={25} className="fill-orange-400"/>
        )}
      </button>
      <span className={twMerge(
        "px-3 w-[600px] dark:text-white",
        checked ? "text-gray-400 line-through dark:text-gray-950" : "text-black"
      )}>{text}</span>
      <div className="flex items-center cursor-pointer px-2 gap-2">
        <button
          className="text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500"
          onClick={() => setIsEditing(true)}
        >
          <MdEdit size={22}/>
        </button>
        <button
          onClick={() => onDelete(id)}
          className="text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500"
        >
          <IoMdTrash size={22}/>
        </button>
      </div>
      {isEditing &&
        <SubEdit text={editText} onClose={() => setIsEditing(false)}
                 onSave={(newText) => {
                   onUpdate(id, newText);
                   setIsEditing(false);
                 }}/>}
    </div>
  );
}

export default React.memo(SubListItem);