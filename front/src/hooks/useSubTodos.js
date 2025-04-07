import axios from 'axios';
import { useState, useEffect } from 'react';

export function useSubTodos(mainTaskId) {
  const [subtasks, setSubtasks] = useState([]);

  useEffect(() => {
    if (!mainTaskId) return;
    axios.get(`http://59.24.237.51:8080/api/v1/subtask/${mainTaskId}`)
    .then(res => setSubtasks(res.data))
    .catch(err => console.error(err));
  }, [mainTaskId]);

  const addSubtask = async (subTaskContent) => {
    const res = await axios.post('http://59.24.237.51:8080/api/v1/subtask', {
      mainTaskId,
      subTaskContent
    });
    setSubtasks(prev => [...prev, res.data]);
  };

  const updateSubtask = async (subTaskId, subTaskContent) => {
    await axios.put('http://59.24.237.51:8080/api/v1/subtask', { subTaskId, subTaskContent });
    setSubtasks(prev =>
      prev.map(sub => sub.subTaskId === subTaskId
        ? { ...sub, subTaskContent }
        : sub
      )
    );
  };

  const deleteSubtask = async (subTaskId) => {
    await axios.delete(`http://59.24.237.51:8080/api/v1/subtask/${subTaskId}`);
    setSubtasks(prev => prev.filter(sub => sub.subTaskId !== subTaskId));
  };

  const toggleComplete = async (subTaskId) => {
    await axios.put(`http://59.24.237.51:8080/api/v1/subtask/check/${subTaskId}`);
    setSubtasks(prev =>
      prev.map(sub => sub.subTaskId === subTaskId
        ? { ...sub, checked: !sub.checked }
        : sub
      )
    );
  };

  return { subtasks, addSubtask, updateSubtask, deleteSubtask, toggleComplete };
}