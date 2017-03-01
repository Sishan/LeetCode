import React from 'react'
import {connect} from 'react-redux'

import {createNewArticles} from './articleActions'

//New artcile section component

export const NewArticle = ({createNewArticle}) =>{

	let textInput

	return (
		<div className="row text-center">
			<textarea rows="4" cols="60" id="new-post-textarea" ref={ (node) => { textInput = node }}></textarea>
			<br/>
			<label className="btn btn-default btn-file">Upload Image<input type="file" style={{display: 'none'}}/></label>
			<button type="button" className="btn btn-danger" onClick={() => {textInput.value = ''}} >Cancel</button>
			<button type="button" className="btn btn-success" onClick= {()=>{createNewArticle()}}>Post</button>
		</div>
	)
}

export default connect(null, (dispatch) => ({
	createNewArticle: () => {dispatch(createNewArticles())}
}))(NewArticle)