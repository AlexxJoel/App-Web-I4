import React, { useState, useEffect } from 'react'
import { useMemo } from 'react'
import { Badge, Card, Col, Row } from 'react-bootstrap'
import DataTable from 'react-data-table-component'
import { ButtonCircle } from '../../shared/components/ButtonCircle'
import { FilterComponent } from '../../shared/components/FilterComponent'
import { Loading } from '../../shared/components/Loading'
import AxiosClient from '../../shared/plugins/axios'

const options = {
  rowsPerPageText: 'Registro por páginas', 
  rangeSeparatorText: 'de'
}

export const CategoryScreen = () => {

  const [categories, setCategories] = useState([])
  const [selectedCategory, setSelectedCategory] = useState({})
  const [isLoading, setIsLoading] = useState(false)
  const [isEditing, setIsEditing] = useState(false)
  const [filterText, setFilterText] = useState('')
  const [isOpen, setIsOpen] = useState(false)
  

  const fiteredCategories = categories.filter(
    category => category.name && category.name.toLowerCase().includes(filterText.toLowerCase())
  )

  useEffect(async () => {
      try {
        setIsLoading(true); 
        const data = await AxiosClient({url: "/category/"}); 
        if (!data.error) {
          setCategories(data.data);        
        }

      } catch (error) {

        console.log("Error alert ")
        
      }finally{
        setIsLoading(false); 
      }

  }, []); 

  const  headerComponent = useMemo(() => {
    const  handlerClear = () => {
      if(filterText) setFilterText('')

      return(
        <FilterComponent
          onFilter={(e) => setFilterText(e.target.value) }
          onClear={handlerClear}
          filterText={filterText}
        />
      )

    }
  }, [filterText])
   
  const columns = useMemo(() =>[
    {name: "#", cell:(row, index) => <div>{index+1}</div> , sortable:true },
    {name: "Category", cell:(row) => <div>{row.name}</div> , sortable:true , selector: (row) => row.name },
    {name: "Estado", cell:(row) => row.status?<Badge bg='success'>Activo</Badge>: <Badge bg='dnager'>Inactivo</Badge> , sortable:true , selector: (row) => row.status },
    {name: "Acciones", cell:(row) => {
    <>
      <ButtonCircle icon='edit' type={"btn btn-outline-warning btn-circle"} size='16' onClick={() => {
        setIsEditing(true); setSelectedCategory(row)
      }} />  
      
      {
       row.status ? (<ButtonCircle icon='trash-2' type={"btn btn-outline-danger btn-circle"} onClick={() => {}} size='16'/>): (<ButtonCircle icon='pocket' type={"btn btn-outline-success btn-circle"} onClick={() => {}} size='16'/>)
      }
      
     </> }, sortable:true , selector: (row) => row.name },


  ], [])

  return (
    <Card>
        <Card.Header >
            <Row>
                <Col>categorías</Col>
                <Col className = "text-end"> <ButtonCircle type={"btn btn-success"} onClick={(arg) =>{} } icon="plus" size={16}/> </Col>
            </Row>
        </Card.Header>

        <Card.Body className='mt-0 pt-0'>
            <DataTable columns={columns} data={fiteredCategories} progressPending={isLoading} progressComponent={<Loading/>} noDataComponent={"Sin registros"} pagination paginationComponentOptions={options} subHeader subHeaderComponent={headerComponent  } persistTableHead striped={true} highlightOnHover={true} />
        </Card.Body>
    </Card>
  )
}
