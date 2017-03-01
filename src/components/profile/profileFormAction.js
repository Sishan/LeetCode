import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import Action, {displayErrorMsg} from '../../actions'

//Not functional yet
export function ProfileFormAction(props){
	return (dispatch, props) =>{
		if (!validationPassword()){
			dispatch(displayErrorMsg("Password does not match!"));
		}

		if (updateName(props)){
			dispatch({type:Action.UPDATE_PROFILE, username: document.getElementById("displayName").value});
			document.getElementById("displayName").value = ''
		}


		if (updateEmail(props)){
			dispatch({type:Action.UPDATE_PROFILE, email: document.getElementById("emailAddress").value});
			document.getElementById("emailAddress").value = ''
		}


		if (updateZipcode(props)){
			dispatch({type:Action.UPDATE_PROFILE, zipcode: document.getElementById("zipcode").value});
			document.getElementById("zipcode").value = ''
		}

		// else {
		// 	dispatch(displayErrorMsg("Update is not functional yet"));
		// }
	}
}


const validationPassword = () => {
	var password = document.getElementById("password").value
	var passwordConfirm = document.getElementById("passwordConfirm").value

	console.log(password);
	console.log(passwordConfirm)
	if (password != passwordConfirm){
		document.getElementById("password").value = ''
		document.getElementById("passwordConfirm").value = ''
		return false;
	}
	else {
		return true;
	}
}

const updateName = (props) => {
	var curName = props.username
	var inputName = document.getElementById("displayName").value
	if (inputName != '' && inputName != curName){
		return true;
	}
	else{
		return false;
	}
}

const updateEmail = (props) => {
	var curEmail = props.email
	var inputEmail = document.getElementById("emailAddress").value
	if (inputEmail != '' && inputEmail != curEmail){
		return true;
	}
	else{
		return false;
	}
}


const updateZipcode = (props) => {
	var curZipcode = props.zipcode
	var inputZipcode = document.getElementById("zipcode").value
	if (inputZipcode != '' && inputZipcode != curZipcode){
		return true;
	}
	else{
		return false;
	}
}


export default connect((state) => {
	return {
		username: state.profile.username,
		avatar: state.profile.avatar,
		zipcode: state.profile.zipcode,
		email: state.profile.email,
		dob: state.profile.dob
	}
})(ProfileFormAction)