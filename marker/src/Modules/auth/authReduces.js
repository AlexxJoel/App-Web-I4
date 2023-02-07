export const authReducer = (state = {}, action)=>{
switch (action.type) {
    case "LOGIN":
        return {
            ...action.playload,
            isLogged: true,
            
        }
        break;
    case "LOGOUT":
        return{
            isLogged: false
        }
        break;
    default:

    return state;
        
}
}