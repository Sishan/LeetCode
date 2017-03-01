import React from 'react'
import { connect } from 'react-redux'
import {loginAction} from './authActions'

//The login section react component

const Login = ({dispatch}) => {
	let username, password;

	return (
		<div className="col-sm-5 well">
			<div className = "text-center">
				<h2>Login</h2>
			</div>
			<div>
				<div className="form-group row">
					<label className="col-xs-4 col-form-label">Account name</label>
					<div className="col-xs-8">
						<input className="form-control" type="text" name="account name" placeholder="Account Name" ref={(node) => { username = node }} required/>
					</div>
				</div>
				<div className="form-group row">
					<label className="col-xs-4 col-form-label">Password</label>
					<div className="col-xs-8">
						<input className="form-control" type="password" name="password" placeholder="Password" ref={(node) => { password = node }} required/>	
					</div>
				</div>
				<div className="row formRow alert fade in" id="log-notice"></div>
					<div className = "col-sm-4 col-md-offset-5">
						<button type="button" className="btn btn-primary" onClick={() => {dispatch(loginAction(username.value, password.value))}}>Login</button>
					</div>
			</div>
		</div>
	)
}

export default connect()(Login)