import React from 'react'
import { useContext } from 'react'
import { Button, Container, Nav, Navbar } from 'react-bootstrap'
import { Form, Link, useNavigate } from 'react-router-dom'
import { AuthContext } from '../../modules/auth/authContext'

const AdminNavbar = () => {
  const {dispatch} = useContext(AuthContext)
  const navigate = useNavigate(); 
  const hanldeLogout = () => {
    dispatch({type: "LOGOUT"})
    navigate('/auth', {replace: true})
  }

  return (
    <Navbar bg="light" expand="lg">
    <Container fluid>
      <Navbar.Brand href="#">Administrador</Navbar.Brand>
      <Navbar.Toggle aria-controls="navbarScroll" />
      <Navbar.Collapse id="navbarScroll">
        <Nav
          className="me-auto my-2 my-lg-0"
          style={{ maxHeight: '100px' }}
          navbarScroll
        >
          <Link to={"/"} className='nav-link ms-1'>Productos</Link>
          <Link to={"/category"} className='nav-link ms-1'>Categorias</Link>
          <Link to={"/subcategegory"} className='nav-link ms-1'>Subcategoris</Link>
         
        </Nav>
    
          <Button variant="danger" onClick={hanldeLogout}>Cerrar seión</Button>
       
      </Navbar.Collapse>
    </Container>
  </Navbar>
  )
}

export default AdminNavbar