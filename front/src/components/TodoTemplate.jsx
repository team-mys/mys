export default function TodoTemplate({ children }) {
  return (
    <div className='w-[512px] ml-auto mr-auto mt-2 rounded-sm overflow-hidden pt-5'>
      <div className='bg-orange-400 text-white h-14 font-bold text-2xl flex items-center justify-center'>
        일정관리
      </div>
      <div className='bg-white'>{children}</div>
    </div>
  );
}
