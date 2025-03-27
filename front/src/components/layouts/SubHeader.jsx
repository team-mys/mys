import {MdOutlineDarkMode, MdOutlineLightMode} from 'react-icons/md';
import TimeNow from '../TimeNow.jsx';
import useDarkMode from '../../hooks/useDarkMode.js';

export default function SubHeader() {
  const { toggleDarkMode, isDarkMode } = useDarkMode();
  return (
    <section
      className="bg-blue-50 dark:bg-gray-800 border-b border-gray-200 dark:border-gray-700 px-1.5 py-2.5 justify-between flex items-center">
      <TimeNow/>
      <button
        onClick={toggleDarkMode}
        className="mr-2 cursor-pointer rounded-full p-0.5 hover:bg-gray-400 dark:hover:bg-gray-600"
      >
        {isDarkMode ? <MdOutlineLightMode color='white' size={25} /> : <MdOutlineDarkMode size={25} />}
      </button>
    </section>
  );
}