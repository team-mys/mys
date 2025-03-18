export default function Modal({children}) {
  return (
    <div
      className="fixed inset-0 flex items-center justify-center bg-gray-200 bg-opacity-50">
      <div className="bg-white p-6 rounded-md w-[480px]">
        {children}
      </div>
    </div>
  )
}