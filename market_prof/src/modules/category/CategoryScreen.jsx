import React from 'react'
import { Card } from 'react-bootstrap'
import DataTable from 'react-data-table-component'
import { ButtonCircle } from '../../shared/components/ButtonCircle'

export const CategoryScreen = () => {

  const [categories, setCategories] = useState([])
  const [selectedCategory, setSelectedCategory] = useState(second)
  const [isLoading, setIsLoading] = useState(false)
  const [isEditing, setIsEditing] = useState(false)
  const [isOpen, setIsOpen] = useState(false)


  return (
    <Card>
        <Card.Header>
            <Row>
                <Col>categorías</Col>
                <Col className = "text-end"> <ButtonCircle type={"btn btn-outline-success"} onClick={(arg) =>{} } icon="plus" size={16}/> </Col>
            </Row>
        </Card.Header>
        <Card.Body>
            <DataTable columns={[]} data={categories} progressPending={isLoading} progressComponent={<></>} noDataComponent={"Sin registros"} pagination paginationComponentOptions={{}} subHeader subHeaderComponent={<></>} persistTableHead striped={true} highlightOnHover={true} />
        </Card.Body>
    </Card>
  )
}
