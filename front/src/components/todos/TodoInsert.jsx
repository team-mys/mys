import {MdAdd} from 'react-icons/md';
import {useCallback, useState} from 'react';

export default function TodoInsert({onCreate}) {
  const [value, setValue] = useState('');

  const onChange = useCallback(e => {
    setValue(e.target.value);
  }, [])

  const onSubmit = useCallback(e => {
      // submit 이벤트는 브라우저에서 새로고침 발생
      e.preventDefault(); // 새로고침 방지
      if (!value.trim()) return; // 공백일 경우 return
      onCreate(value);
      setValue(''); // value 값 초기화
    },
    [onCreate, value]
  );

  return (
    <form className="flex bg-gray-600" onSubmit={onSubmit}>
      <input
        value={value}
        onChange={onChange}
        placeholder="할 일을 입력하세요"
        className="p-3 text-base font-mono font-semibold text-white outline-none
              placeholder:text-gray-200 placeholder:font-bold placeholder:font-sans flex-1"
      />
      <button
        type="submit"
        className="bg-gray-400 text-white px-3 text-lg flex
               items-center cursor-pointer hover:bg-gray-300"
      >
        <MdAdd size={20}/>
      </button>
    </form>
  );
}