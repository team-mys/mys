import { useAuth } from '../context/AuthContext';
import dayjs from 'dayjs';
import duration from 'dayjs/plugin/duration';

dayjs.extend(duration);

export default function Count() {
  const { countdown } = useAuth();

  const formatTime = (seconds) => {
    const timeDuration = dayjs.duration(seconds, 'seconds');
    return timeDuration.format('mm:ss');
  };

  return (
    <div className='flex flex-row rounded-md bg-gray-600 p-1 px-2'>
      <h2 className='text-base'>남은 시간 {formatTime(countdown)}</h2>
    </div>
  );
}