import React, { useState } from 'react';
// components
import Navbar from './components/Navbar';
import AddTodoModal from './components/AddTodoModal';
import Todos from './components/Todos';

export default function App() {
  // changing body background color
  document.body.style = 'background: #20212C;';

  const [todos, setTodos] = useState([
    {
      id: Math.round(Math.random() * 1000),
      taskName: 'Makan',
      description: 'Makan-makan',
      isCompleted: false,
    },
    {
      id: Math.round(Math.random() * 1000),
      taskName: 'Bersih',
      description: 'Bersih-Bersih',
      isCompleted: false,
    },
  ])

  return (
    <>
      <Navbar />
      <AddTodoModal todos={todos} setTodos={setTodos}/>
      <Todos todos={todos} setTodos={setTodos}/>
    </>
  );
}