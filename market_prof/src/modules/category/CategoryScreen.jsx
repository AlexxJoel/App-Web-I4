import React, { useState } from 'react'
import { Card, Col, Row } from 'react-bootstrap'
import DataTable from 'react-data-table-component'
import { ButtonCircle } from '../../shared/components/ButtonCircle'
import { Loading } from '../../shared/components/Loading'

export const CategoryScreen = () => {

  const [categories, setCategories] = useState([])
  const [selectedCategory, setSelectedCategory] = useState({})
  const [isLoading, setIsLoading] = useState(true)
  const [isEditing, setIsEditing] = useState(false)
  const [filterText, setFilterText] = useState('')
  const [isOpen, setIsOpen] = useState(false)

  const fiteredCategories = categories.filter(
    category => category.name && category.name.toLowerCase().includes(filterText.toLowerCase())
  )


  return (
    <Card>
        <Card.Header>
            <Row>
                <Col>categorías</Col>
                <Col className = "text-end"> <ButtonCircle type={"btn btn-outline-success"} onClick={(arg) =>{} } icon="plus" size={16}/> </Col>
            </Row>
        </Card.Header>
        <Card.Body>
            <DataTable columns={[]} data={categories} progressPending={isLoading} progressComponent={<Loading/>} noDataComponent={"Sin registros"} pagination paginationComponentOptions={{}} subHeader subHeaderComponent={<></>} persistTableHead striped={true} highlightOnHover={true} />
        </Card.Body>
    </Card>
  )
}
