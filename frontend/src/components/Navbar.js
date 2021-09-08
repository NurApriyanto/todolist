import React from 'react';
import {
  MDBContainer,
  MDBNavbar,
  MDBNavbarBrand,
  MDBNavbarLink,
} from 'mdb-react-ui-kit';

export default function Navbar() {
  return (
    <>
    <MDBNavbar style={{backgroundColor: '#272833'}} expand='lg'>
      <MDBContainer fluid>
        <MDBNavbarBrand 
          href='#' 
          className='text-light ms-5'
        >
          Logo
        </MDBNavbarBrand>
        <MDBNavbarLink href='#' className='text-light'>
          Icon
        </MDBNavbarLink>
      </MDBContainer>
    </MDBNavbar>
    </>
  );
}