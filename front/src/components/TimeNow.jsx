import dayjs from 'dayjs';

export default function TimeNow() {
  const now = dayjs().format('YYYY년 MM월 DD일');
  return (
    <div className='text-base font-semibold bg-gray-600 rounded-md text-white py-1 px-2'>
      {now}
    </div>
  );
}