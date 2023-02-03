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