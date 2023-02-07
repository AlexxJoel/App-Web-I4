import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';

const Alert = withReactContent(Swal);

export const confirmMsg = "We ask you to wait a moment for the action to finish";
export const confirmTitlle = "Are you sure to perform the action?";
export const successMsg = "The activity carried out has been completed successfully"
export const successTitle = 'Action done successfully';
export const errorMsg= "The requested action has not been performed";
export const errorTitle = "Failed to perform action";
export default Alert;