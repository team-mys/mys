export default function Modal({ children }) {
  return (
    <div className='fixed inset-0 flex items-center justify-center bg-black/50  backdrop-blur-xs'>
      <div className='bg-white dark:bg-gray-700 dark:text-white p-6 rounded-md w-[480px] border border-gray-300'>{children}</div>
    </div>
  );
}