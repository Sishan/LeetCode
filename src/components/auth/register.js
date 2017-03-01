import React from 'react'

import { connect } from 'react-redux'
import { RegisterAction} from './registerActions'

//The register form JSX


const Register = ({dispatch}) => {
	let accountName, displayName, email, dateOfBirth, zipcode, password, confirmPassword;

	return(
	<div className="col-sm-6 well">
		<div className = "text-center">
			<h2>Register Here</h2>
		</div>
		<form  onSubmit= {(e) => {
			e.preventDefault();
			dispatch(RegisterAction());
		}}>
		<div className="form-group row">
			<label htmlFor="example-text-input" className="col-xs-4 col-form-label">Account name</label>
			<div className="col-xs-8">
				<input className="form-control" type="text"  placeholder="Enter account name" id="account name" pattern="[A-Za-z][A-Za-z0-9]*" ref={(node) => { accountName = node }} required/>
			</div>
		</div>
		<div className="form-group row">
			<label htmlFor="example-text-input" className="col-xs-4 col-form-label">Display name (optional)</label>
			<div className="col-xs-8">
				<input className="form-control" type="text" placeholder="Enter display name" id="display name" ref={(node) => { displayName = node }}/>
			</div>
		</div>
		<div className="form-group row">
			<label htmlFor="example-text-input" className="col-xs-4 col-form-label">Email address</label>
			<div className="col-xs-8">
				<input className="form-control" type="email" placeholder="a@b.com" id="email address" pattern="\S+@\S+\.\S+" ref={(node) => { email = node }} required/>
			</div>
		</div>
		<div className="form-group row">
			<label htmlFor="example-text-input" className="col-xs-4 col-form-label">Date of birth</label>
			<div className="col-xs-8">
				<input className="form-control" type="date" id="date of birth" ref={(node) => { dateOfBirth = node }} required/>
			</div>
		</div>
		<div className="form-group row">
			<label htmlFor="example-text-input" className="col-xs-4 col-form-label">Zipcode</label>
			<div className="col-xs-8">
				<input className="form-control" type="text" id="zipcode" placeholder="77005" pattern="^\d{5}(?:[-\s]\d{4})?$" ref={(node) => { zipcode = node }}required/>
			</div>
		</div>
		<div className="form-group row">
			<label  className="col-xs-4 col-form-label">Password</label>
			<div className="col-xs-8">
				<input className="form-control" type="password" id="password" placeholder="Password" id="password" ref={(node) => { password = node }} required/>
			</div>
		</div>
			<div className="form-group row">
			<label htmlFor="example-text-input" className="col-xs-4 col-form-label">Password Confirmation</label>
			<div className="col-xs-8">
				<input className="form-control" type="password" id="password confirmation" placeholder="Confirm Password" ref={(node) => { confirmPassword = node }} required/>
			</div>
		</div>
		<input type="hidden" name="timestamp" id="timestamp"/>

		<div className = "form-group row">
			<div className="col-xs-4 col-md-offset-2">
				<input type="submit" className="btn btn-primary" value="Submit"/>
			</div>
			<div className="col-xs-4 col-md-offset-2">
				<input type="button" className="btn btn-primary" value="Clear" onClick={()=>{
					accountName.value=''
					displayName.value=''
					email.value=''
					dateOfBirth.value=''
					password.value=''
					confirmPassword=''
				}}/>
			</div>

		</div>
		</form>
	</div>
	)}

	export default connect()(Register)