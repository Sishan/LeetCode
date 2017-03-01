import React from 'react'

import Register from './register'
import Login from './login'
import Message from '../message'


//The landing page JSX

const Landing = () => (
	<div>
		<div className="jumbotron text-center">
			<h1>RiceBook</h1>
		</div>

		<div className="container">
			<div className="row">
				<Register/>
				<div className="col-lg-1"></div>
				<Login/>
			</div>
			<Message/>
		</div>

		<footer className="container-fluid text-center">
                <p>RiceBook © 2017</p>
        </footer>
	</div>
)

export default Landing