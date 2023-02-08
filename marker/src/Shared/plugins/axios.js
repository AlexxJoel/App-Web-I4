import axios  from 'axios';

const AxiosClient = axios.create({
    baseURL: 'http://localhost:8080/api-fistapp'
});

const requestedHandler = (reques) => {
    requestedHandler.headers['Accept'] = "aplication/json";
    requestedHandler.headers['Content-Type'] = "aplication/json"
    const sessopm = JSON.parse(
        localStorage.getItem('user')
    ) || null;
    if (session?.isLogged)
        requestedHandler.headers['Authorization'] = `Bearer ${session.token}`;
        return request;  
};

const errorResponseHandler = (error) => {
    return Promise.reject(error);
}

const successResponseHandler = (response) => Promise.resolve(response.data);

AxiosClient.interceptors.response.use(
    requestedHandler,
    (error) => Promise.reject(error)
)

AxiosClient.interceptors.response.use(
    successResponseHandler,
    (error) => errorResponseHandler(error)
)

export default AxiosClient;