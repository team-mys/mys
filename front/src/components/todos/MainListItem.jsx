import React, {useState} from 'react';
import {twMerge} from 'tailwind-merge';
import {
  MdAdd,
  MdCheckBox,
  MdCheckBoxOutlineBlank,
  MdEdit
} from 'react-icons/md';
import {IoMdTrash} from 'react-icons/io';
import MainEdit from './MainEdit.jsx';
import AddModal from './AddModal.jsx';
import SubListItem from './SubListItem.jsx';
import {
  useCompleteTodo,
  useDeleteTodo,
  useUpdateTodo
} from '../../hooks/useTodos.js';

function MainListItem({todo}) {
  const {id, text, checked} = todo;

  const deleteTodo = useDeleteTodo();
  const completeTodo = useCompleteTodo();
  const updateTodo = useUpdateTodo();

  const [isEditing, setIsEditing] = useState(false);
  const [isAdding, setIsAdding] = useState(false);
  const [subItems, setSubItems] = useState([]);

  const AddSubItem = (subText) => {
    setSubItems([
      ...subItems,
      {
        id: subItems.length + 1,
        text: subText,
        checked: false
      }
    ]);
    setIsAdding(false);
  };

  const DeleteSubItem = (subId) => {
    setSubItems(subItems.filter((subItem) => subItem.id !== subId));
  };

  const EditSubItem = (subId, newText) => {
    setSubItems(
      subItems.map((subItem) =>
        subItem.id === subId
          ? {
            ...subItem,
            text: newText
          }
          : subItem
      )
    );
  };

  const CheckedSubItem = (subId) => {
    setSubItems(
      subItems.map((subItem) =>
        subItem.id === subId
          ? {...subItem, checked: !subItem.checked}
          : subItem
      )
    );
  };

  return (
    <>
      <div
        className="p-3.5 flex flex-row items-center bg-neutral-100 dark:bg-gray-700 dark:border-gray-700 border-b-1 border-gray-300">
        <button onClick={() => completeTodo(id)} className="flex items-center">
          {checked ? (
            <MdCheckBox size={25} className="fill-orange-400 text-lg"/>
          ) : (
            <MdCheckBoxOutlineBlank size={25} className="fill-orange-400"/>
          )}
        </button>
        <span
          className={twMerge(
            'px-3 w-[600px] dark:text-white',
            checked ? 'text-gray-400 line-through dark:text-gray-950' : 'text-black'
          )}
        >
          {text}
        </span>
        <div className="flex items-center cursor-pointer px-2">
          <button
            className="text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500"
            onClick={() => setIsEditing(true)}
          >
            <MdEdit size={22}/>
          </button>
        </div>
        <div className="cursor-pointer flex items-center gap-2">
          <button
            onClick={() => deleteTodo(id)}
            className="text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500"
          >
            <IoMdTrash size={22}/>
          </button>
          <button
            onClick={() => setIsAdding(true)}
            className="text-gray-500 hover:text-gray-300 rounded-full border p-0.5 border-gray-500"
          >
            <MdAdd size={22}/>
          </button>
        </div>
        {isEditing && (
          <MainEdit
            todo={todo}
            onClose={() => setIsEditing(false)}
            onSave={(newText) => {
              updateTodo(id, newText);
              setIsEditing(false);
            }}
          />
        )}
        {isAdding && (
          <AddModal onClose={() => setIsAdding(false)} onCreate={AddSubItem}/>
        )}
      </div>
      {subItems.map((todo) => (
        <SubListItem
          key={todo.id}
          todo={todo}
          onDelete={DeleteSubItem}
          onUpdate={EditSubItem}
          onComplete={CheckedSubItem}
        />
      ))}
    </>
  );
}

export default React.memo(MainListItem);