import React, { useState } from 'react';
// components
import Navbar from './components/Navbar';
import User from './components/User';

export default function App() {
  // changing body background color
  document.body.style = 'background: #20212C;';

  const [users, setUser] = useState([
    {
      id: Math.round(Math.random() * 1000),
      userName: 'Nur Apriyanto',
    },
    {
      id: Math.round(Math.random() * 1000),
      userName: 'Nur',
    },
    {
      id: Math.round(Math.random() * 1000),
      userName: 'Nur',
    },
    {
      id: Math.round(Math.random() * 1000),
      userName: 'Nur',
    },
    {
      id: Math.round(Math.random() * 1000),
      userName: 'Nur',
    },
  ])

  return (
    <>
      <Navbar />
      <User users={users} setUser={setUser}/>
    </>
  );
}