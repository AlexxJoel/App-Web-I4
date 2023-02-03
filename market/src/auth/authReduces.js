export  const authReduces = (state = {}, action) =>{
    switch (action.type) {
        case 'L0GIN':
            return{
                ...action.payload, isLogged: true,
            };
        case 'LOGOUT':
            return {
                isLogged: false
            };
        default:
                return state;
    }
}