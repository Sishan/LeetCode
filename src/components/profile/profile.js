import React from 'react'
import { connect } from 'react-redux'

import {nav2Main} from '../../actions'
import Message from '../message'
import ProfileForm from './profileForm'

//The profile page JSX
const Profile = ({dispatch}) => (
	<div>
		<div className="jumbotron text-center">
			<h1>My Profile</h1>
			<p><a className="btn btn-primary btn-lg" href="#" onClick={ () => {dispatch(nav2Main())}} role="button">Return to Main Page</a></p>
		</div>
		<Message/>
		<ProfileForm/>
	</div>
)

export default connect()(Profile)