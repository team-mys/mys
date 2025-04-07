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
import {useSubTodos} from '../../hooks/useSubTodos.js';

export default function MainListItem({todo}) {
  const {mainTaskId, mainTaskContent, checked} = todo;

  const { subtasks, addSubtask, updateSubtask, deleteSubtask, toggleComplete } = useSubTodos(mainTaskId);

  const deleteTodo = useDeleteTodo();
  const completeTodo = useCompleteTodo();
  const updateTodo = useUpdateTodo();

  const [isEditing, setIsEditing] = useState(false);
  const [isAdding, setIsAdding] = useState(false);

  const handleSave = async (newText) => {
    await updateTodo(mainTaskId, newText);
    setIsEditing(false);
  };

  return (
    <>
      <div
        className="p-3.5 flex flex-row items-center bg-neutral-100 dark:bg-gray-700 dark:border-gray-700 border-b-1 border-gray-300">
        <button onClick={() => completeTodo(mainTaskId)}
                className="flex items-center">
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
          {mainTaskContent}
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
            onClick={() => deleteTodo(mainTaskId)}
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
            onSave={handleSave}
          />
        )}
      </div>
      {subtasks.map(sub => (
        <SubListItem
          key={sub.subTaskId}
          todo={sub}
          onDelete={deleteSubtask}
          onUpdate={updateSubtask}
          onComplete={toggleComplete}
        />
      ))}
      {isAdding && (
        <AddModal
          onClose={() => setIsAdding(false)}
          onCreate={(subText) => {
            addSubtask(subText);
            setIsAdding(false);
          }}
        />
      )}
    </>
  );
}