import React from 'react';
import { 
  MDBCard, 
  MDBCardBody, 
  MDBCardText, 
  MDBCheckbox,
  MDBIcon,
  MDBBtn,
} from 'mdb-react-ui-kit';

export default function Todos({ todos }) {
  return (
    <>
      <MDBCard className='mx-auto my-4 ' style={{ maxWidth: '22rem', backgroundColor: '#272833', }}>
        <MDBCardBody className='' style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline' }}>
          <MDBCardText style={{ color: '#D8D8D8', display: 'flex', alignItems: 'baseline'}}>
          <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' />
            <p className='ms-2 mt-2'>
              the explanation presentedasdasd
            </p>
          </MDBCardText>
          <MDBBtn tag='a' color='none' className='m-1 pe-4 ps-1' style={{ color: '#D94C4C' }}>
            <MDBIcon fas icon='times' size='lg'/>
          </MDBBtn>
        </MDBCardBody>
      </MDBCard>

      <MDBCard className='mx-auto my-4' style={{ maxWidth: '22rem', backgroundColor: '#272833' }}>
        <MDBCardBody style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline' }}>
          <MDBCardText style={{ color: '#D8D8D8', display: 'flex', }}>
          <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' />
            <p className='ms-2'>
              biasanya saya nyari tutor dari orang luar, tapi setelah ketemu video ini saya baru sadar ternyata ada produk dalam negeri yang lebih bagus hehe
              pembahasannya lengkap dan mudah dimengerti, ditunggu video2 selanjutnya. thanks
            </p>
          </MDBCardText>
          <MDBBtn tag='a' color='none' className='m-1 pe-4 ps-1' style={{ color: '#D94C4C' }}>
            <MDBIcon fas icon='times' size='lg' />
          </MDBBtn>
        </MDBCardBody>
      </MDBCard>
    </>
  );
}