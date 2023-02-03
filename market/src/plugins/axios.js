import * as instance from 'axios';

const AxiosClient = instance.create({
    baseURL: 'http://localhost:8080/first-app'
})

const requestHandler = (req) =>{
    req.headers['Accept']= "application/json";
    req.headers['Content-Type']= "application/json";
    const session = JSON.parse(
        localStorage.getItem('user')
    ) || null;

    if (session?.isLogged){
        req.headers['Authorization'] = `Bearer ${session.token}`;
    }

    return req;
}

const errorResponseHandler = (e)=>{
    return Promise.reject(e)
}

const successResponseHandler = (res)=>{
    return Promise.reject(res.data)
}

//config request
AxiosClient.interceptors.request.use(
    requestHandler,
    (e)=>Promise.reject(e)
);

AxiosClient.interceptors.response.use(
   successResponseHandler, error => errorResponseHandler(error)
);


export default AxiosClient