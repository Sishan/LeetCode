import React from 'react'
import { connect } from 'react-redux'

import Action, {displayErrorMsg} from '../../actions'

//Avatar JSX

const Avatar = ({avatar,dispatch}) => (
	<div className="row formRow">
		<div className="col-md-4">Profile Image:</div>
		<div className="col-md-4">
			<label className="btn btn-default btn-file">Update Image
				<input type="file" style={{display: 'none'}} onChange={(e)=>{dispatch(displayErrorMsg("Not support upload image yet!"))}}/>
			</label>
		</div>
		<div className="col-md-4"><img src={avatar} style={{height:'100px'}}/></div>
	</div>
)

export default connect((state) => {
	return {avatar:state.profile.avatar}
})(Avatar)