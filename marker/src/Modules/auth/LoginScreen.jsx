import {useContext,useEffect} from "react";
import {AuthContext} from "../context/AuthContext";
import {Navigation, useNavigation} from "react-router-dom";
import {Form, useFormik} from "formik";
import * as Yup from "yup";
import AxiosClient from "../../Shared/plugins/axios";
import Alert from "../../Shared/components/Alert";
import {Button, Col, Container, Figure, FormGroup, Row} from "react-bootstrap";
import * as PropTypes from "prop-types";

function H4(props) {
    return null;
}

H4.propTypes = {
    className: PropTypes.string,
    children: PropTypes.node
};
export const LoginScreen = () => {
    const Navigation = useNavigation();
    const {user, dispatch} = useContext(AuthContext);
    const formik = useFormik({
        initialValues: {
            username,
            password,
        },

        validationSchema: Yup.object.shape({
            username: Yup.string().required('Username is required').min(4, 'Username must be at least 4 characters'),
            password: Yup.string().required('Password is required').min(4, 'Password must be at least 4 characters'),
        }),
        onSubmit: async (values) => {
            try {
                const URI = 'auth/login';
                const response = await AxiosClient({
                    method: 'POST',
                    url: URI,
                    data: JSON.stringify(values),
                })
                if (!response.error) {
                    const action = {
                        type: 'login',
                        payload: response.data,
                    }
                    dispatch(action);
                    navigation('/products', {replace: true});
                }
            }catch (e) {
                Alert.fire({
                    title: 'Verify your credentials',
                    text: "Username or password are incorrect",
                    icon: 'error',
                    confirmaButtonText: 'Accept',
                    confirmaButtonColor: '#3085d6',
                })
                console.warn(e)
            }
        }
    })

    const handleReturn = () => {
        navigation('/');
    }

    useEffect(() => {
        document.title = 'Login';
    },[])
    if (user.isLogged) {
        return <Redirect to="/" />
    }
    return (
        <>
            <section className="h-100 gradient-form"
                     style={{backgroundColor: '#eee' }}>
                <Container className="py-5 h-100">
                    <Row className="justify-content-center align-items-center h-100">
                        <Col>
                            <div className="card rounded-3 text-black">
                                <Row className="g-0">
                                    <Col lg={6}>
                                        <div className="card-body p-md-5 mx-md-4">
                                            <div className="text-center">
                                                <Figure>
                                                    <Figure.Image />
                                                </Figure>
                                                <H4 className='mt-1 mb-5 pb-1'>
                                                    Market
                                                </H4>
                                            </div>
                                            <Form className="mt-4" onSubmit={formik.handleSubmit}>
                                                <Form.Group className="form-outline mb-4" >
                                                    <Form.Label className="form-label" htmlFor="username">Username</Form.Label>

                                                <Form.Control placeholder="mikemoreno" type="text" id="username" name="username" onChange={formik.handleChange} value={formik.values.username} autoComplete="off" />
                                                    {
                                                        formik.errors.username?
                                                            <span className="error-text">
                                                                {formik.errors.username}
                                                            </span>:null
                                                    }
                                                </Form.Group>

                                                <Form.Group className="form-outline mb-4" >
                                                    <Form.Label className="form-label" htmlFor="password">Password</Form.Label>

                                                    <Form.Control placeholder="*****" type="password" id="password" name="password" onChange={formik.handleChange} value={formik.values.password} autoComplete="off" />
                                                    {
                                                        formik.errors.username?
                                                            <span className="error-text">
                                                                {formik.errors.password}
                                                            </span>:null
                                                    }
                                                </Form.Group>
                                                <Form.Group className="form-outline mb-5">
                                                    <div className="text-end pt-1 pb-1">
                                                        <a href="#!" className="text-muted">
                                                            Forgot Your password?
                                                        </a>
                                                    </div>
                                                </Form.Group>
                                                <Form.Group className="form-outline mb-4">
                                                    <div className="text-center pt-1 pb-1">
                                                        <Button variant="secondary" className="btn-hover gradient-custom-2" type="submit" disabled={!(formik.isValid && formik.dirty)}></Button>
                                                    </div>
                                                    <FeatherIcon icon={"log-in"}> &nbsp; Login </FeatherIcon>
                                                </Form.Group>

                                            </Form>
                                        </div>
                                    </Col>
                                    <Col lg={6} className='align-iteams-center gradient-custom-2'>
                                        <div className="text-white px-3 py-4 p-md-5 mx-md-4">
                                            <h4 className="mb-4">MARKET</h4>
                                            <p className="small mb-0">
                                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque consectetur dignissimos distinctio et, eum fuga fugit incidunt inventore, labore maiores nesciunt obcaecati perferendis, quasi qui quia quod repellendus tempora? A.
                                            </p>
                                        </div>
                                    </Col>
                                </Row>
                            </div>
                        </Col>
                    </Row>
                </Container>

            </section>
        </>
)
}