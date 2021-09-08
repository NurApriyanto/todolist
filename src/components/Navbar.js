import React from 'react';
import {
  MDBContainer,
  MDBNavbar,
  MDBNavbarBrand,
  MDBNavbarLink,
  MDBIcon
} from 'mdb-react-ui-kit';

export default function Navbar() {
  return (
    <>
    <MDBNavbar style={{backgroundColor: "#272833"}} expand='lg'>
      <MDBContainer fluid>
        <MDBNavbarBrand 
          href='#' 
          className="text-light ms-5"
        >
          Logo
        </MDBNavbarBrand>
        <MDBNavbarLink href='#' className="text-light">
        <MDBIcon fas class="fas fa-user-circle fa-2x" style={{ color: "#D94C4C" }}/>
        </MDBNavbarLink>
      </MDBContainer>
    </MDBNavbar>
    </>
  );
}