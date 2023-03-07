import FeatherIcon from 'feather-icons-react'
import { useFormik } from 'formik'
import React from 'react'
import { Button, Col, Form, FormControl, Modal, Row } from 'react-bootstrap'
import * as yup from 'yup'
import Alert, {confirmMsg,  confirmTitle, errorMsg, errorTitle, successMsg, successTitle} from '../../../shared/plugins/alerts'
import AxiosClient from '../../../shared/plugins/axios'

const CategoryForm = ({isOpen, setCategories, onClose}) => {

    const form = useFormik({
        initialValues:{
            name: '',
            status: true
        }, 
        validationSchema: yup.object().shape({
            name: yup.string().required("Campo Obligatorio").min(4, "Minimo cuatro caracteres")
        }),
        onSubmit: async (values) => {
            Alert.fire({
                title: confirmTitle, 
                text: confirmMsg, 
                icon: "warning", 
                confirmButtonColor: "009574",
                confirmButtonText: "Aceptar", 
                cancelButtonColor: "#DD6B55", 
                cancelButtonText: "Cancelar", 
                reverseButtons: true,
                backdrop: true, 
                showCancelButton: true, 
                showLoaderOnConfirm: true,
                allowOutsideClick: () => !Alert.isLoading, 
                preConfirm: async () => {
                    try {
                        const response = await AxiosClient({
                            method: "POST", 
                            url: "/category/", 
                            data: JSON.stringify(values)
                        })
                        if(!response.error){
                            setCategories((categories)=> [response.data, ...categories])
                            Alert.fire({
                                title: successTitle,
                                text: successMsg,
                                icon: "success", 
                                confirmButtonColor: "3085d6", 
                                confirmButtonText: "Aceptar", 

                            }).then((result) =>{
                                if(result.isConfirmed){
                                    handleClose(); 
                                }
                            } )
                        }


                        return response; 
                    } catch (error) {
                        Alert.fire({
                            title: errorTitle,
                            text: errorMsg,
                            icon: "error", 
                            confirmButtonColor: "3085d6", 
                            confirmButtonText: "Aceptar", 

                        }).then((result) =>{
                            if(result.isConfirmed){
                                handleClose(); 
                            }
                        } )
                    }
                } 
            })
        } 
    })

    const handleClose = () => {
        form.resetForm(); 
        onClose(); 
    }

    

  return (
    <Modal backdrop="static" keyboard={false} show={isOpen} onHide={handleClose}>
        <Modal.Header closeButton>
            <Modal.Title>Registrar categoria</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Form onSubmit={form.handleSubmit}>
                <Form.Group className='mb-3'>
                    <Form.Label>Nombre</Form.Label>
                    <FormControl name='name' placeholder='Calazado' value={form.values.name} onChange={form.handleChange}/>
                    { form.errors.name && (<span className='error-text'>{form.errors.name}</span>)}
                </Form.Group>

                <Form.Group className='mb-3'>
                    <Row>
                        <Col className='text-end'>
                            <Button className='me-2' variant='outline-danger' onClick={handleClose}> 
                                <FeatherIcon icon="x"/>
                                &nbsp;Cerrar
                            </Button>

                            <Button className='me-2' variant='outline-succes' type='submit' onClick={handleClose}> 
                                <FeatherIcon icon="check"/>
                                &nbsp;Guardar
                            </Button>
                        </Col>
                    </Row>
                </Form.Group>

            </Form>
        </Modal.Body>

    </Modal>
  )
}

export default CategoryForm
