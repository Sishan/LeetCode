import Action, {displayErrorMsg} from '../../actions'

//Not functional yet
export function RegisterAction(){
	return (dispatch) =>{
		if (!validationForm()){
			dispatch(displayErrorMsg("Password does not match!"));
		}
		else{
			dispatch(displayErrorMsg("Register is not functional yet"));
		}
	}
}

const validationForm = () => {
	var password = document.getElementById("password").value
	var passwordConfirm = document.getElementById("password confirmation").value

	if (password != passwordConfirm){
		return false;
	}
	else {
		return true;
	}

}