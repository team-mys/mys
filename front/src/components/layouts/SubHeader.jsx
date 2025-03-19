import {MdOutlineDarkMode} from 'react-icons/md';
import TimeNow from '../TimeNow.jsx';

export default function SubHeader() {

  return (
    <section className='bg-blue-50 border-b border-gray-200 px-1.5 py-2.5 justify-between flex items-center'>
      <TimeNow />
      <button className='mr-2 cursor-pointer rounded-full p-0.5 hover:bg-gray-400'><MdOutlineDarkMode  size={25}/></button>
    </section>
  )
}