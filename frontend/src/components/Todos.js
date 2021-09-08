import React from 'react';
import { 
  MDBCard, 
  MDBCardBody, 
  MDBCardText, 
  MDBCheckbox,
  MDBIcon,
  MDBBtn,
} from 'mdb-react-ui-kit';

export default function Todos({ todos, setTodos }) {

  const statusChangeHandler = (id) => {
    const temp = todos.map((todo) => {
        if (todo.id !== id) {
          return todo;
        } else {
          return {...todo, isCompleted: !todo.isCompleted}
        }
      });
      setTodos(temp);
  }

  const handleDelete = (id) => {
    const temp = todos.filter((todo) => todo.id !== id);
    setTodos(temp);
  }

  return (
    <>
      {todos.map((todo) => (
        <MDBCard key={todo.id} className='mx-auto my-4 ' style={{ maxWidth: '22rem', backgroundColor: '#272833', }}>
          <MDBCardBody className='' style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline' }}>
            <MDBCardText style={{ color: '#D8D8D8', display: 'flex', alignItems: 'baseline'}}>
            <MDBCheckbox 
              name='flexCheck' 
              value='' 
              id='flexCheckDefault' 
              defaultChecked={todo.isCompleted}
              onChange={() => statusChangeHandler(todo.id)}
            />
              <p className='ms-2 mt-2'>
                { todo.taskName }
              </p>
            </MDBCardText>
            <MDBBtn 
              tag='a' 
              color='none' 
              className='m-1 pe-4 ps-1' 
              style={{ color: '#D94C4C' }}
              onClick={ () => window.confirm('Yakin?') ? handleDelete(todo.id) : 0 }
            >
              <MDBIcon fas icon='times' size='lg'/>
            </MDBBtn>
          </MDBCardBody>
        </MDBCard>
      ))}
    </>
  );
}