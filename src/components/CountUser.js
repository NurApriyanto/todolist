import React from 'react';
import { 
  MDBCard, 
  MDBCardBody, 
  MDBCardText, 
  MDBCheckbox,
  MDBIcon,
  MDBBtn,
} from 'mdb-react-ui-kit';

export default function CountUser() {
  return (
    <>
    <MDBCardBody
        style={{ 
            display: 'flex', 
            justifyContent: 'center', 
            marginTop: "72px",
            marginLeft: "420px",
            marginBottom: "-45px",
            fontSize: "16px"
        }}>
            
    <MDBCardText>
        <p>User :&nbsp;</p>
    </MDBCardText>

    <MDBCardText>
        <p>2</p>
    </MDBCardText>
    </MDBCardBody>
    </>
  );
}
