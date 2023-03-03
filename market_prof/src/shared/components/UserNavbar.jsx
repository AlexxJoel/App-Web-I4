import React from "react";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from "react-router-dom";

const UserNavbar = () => {
  return (
    <Navbar bg="light" expand="lg">
      <Container fluid>
        <Navbar.Brand href="#">Navbar scroll</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: "100px" }}
            navbarScroll
          >
            <Link to="#action1">Home</Link>
            <Link to="#action1">Home</Link>
            <Link to="#action1">Home</Link>
          </Nav>

            <Link to={"/auth"} className="btn btn-outline-success">Iniciar Sesión</Link>
          
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default UserNavbar;
