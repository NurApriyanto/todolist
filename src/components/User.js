import React from 'react';
import { 
  MDBCard, 
  MDBCardBody, 
  MDBCardText, 
  MDBCheckbox,
  MDBIcon,
  MDBBtn,
} from 'mdb-react-ui-kit';

export default function User({users, setUser}) {

  const statusChangeHandler = (id) => {
    const temp = users.map((user) => {
        if (user.id !== id) {
          return user;
        } else {
          return {...user, isCompleted: !user.isCompleted}
        }
      });
      setUser(temp);
  }
  
    const handleDelete = (id) => {
    const temp = users.filter((user) => user.id !== id);
    setUser(temp);
  }
  return (
    <>
    {users.map((user) => (
      <MDBCard key={user.id} className="mx-auto my-4" 
        style={{ 
          maxWidth: '40rem', 
          backgroundColor: '#272833', 
          height:'5rem' 
          }}>
      
        <MDBCardBody 
          style={{ 
            display: 'flex', 
            justifyContent: 'space-between' 
            }}>
          <MDBCardText 
            style={{ 
              color: '#D8D8D8', 
              display: 'flex', 
              }}>
            
            <MDBIcon fas class="fas fa-user-circle fa-2x" 
              style={{ color: "#D94C4C" }}/>
             {/* button di klik nama, bagaimana klik cardnya */}
            <MDBBtn tag='a' color='none' className='m-1' 
              style={{ color: '#D8D8D8' }} >
              {/* onclick={window.location='/ListItem'} */}
              <p className="ms-4" >
              { user.userName }
              </p>
            </MDBBtn>
          </MDBCardText>
          
          <MDBBtn tag='a' color='none' className='m-1' 
            style={{ color: '#D94C4C' }}
            onClick={ () => window.confirm('Yakin?') ? handleDelete(user.id) : 0 }>
            <MDBIcon class="fas fa-trash fa-lg" 
              style={{ color: "#D94C4C" }}/>
          </MDBBtn>
        </MDBCardBody>
      </MDBCard>
      ))}
    </>
  );
}