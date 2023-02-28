import React from 'react'
import { Button, Container, Nav, Navbar } from 'react-bootstrap'
import { Form, Link } from 'react-router-dom'

const AdminNavbar = () => {
  return (
    <Navbar bg="light" expand="lg">
    <Container fluid>
      <Navbar.Brand href="#">Navbar scroll</Navbar.Brand>
      <Navbar.Toggle aria-controls="navbarScroll" />
      <Navbar.Collapse id="navbarScroll">
        <Nav
          className="me-auto my-2 my-lg-0"
          style={{ maxHeight: '100px' }}
          navbarScroll
        >
          <Link href="#action1">Home</Link>
          <Link href="#action1">Home</Link>
          <Link href="#action1">Home</Link>
         
        </Nav>
    
        <Form className="d-flex">
          <Form.Control
            type="search"
            placeholder="Search"
            className="me-2"
            aria-label="Search"
          />
          <Button variant="outline-success">Search</Button>
        </Form>
      </Navbar.Collapse>
    </Container>
  </Navbar>
  )
}

export default AdminNavbar