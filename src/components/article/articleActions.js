import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import Action, {resource} from '../../actions'


const initialStates = require('../../initialState')
//Actions related articles


export function getArticles() {
	return (dispatch) => {
		
			const articles = initialStates.articles.reduce((object,item) => {
				object[item._id] = item;
				return object;
			},{})
			dispatch({type:Action.UPDATE_ARTICLES, articles});
		
	}
}


// export function getArticles() {
// 	return (dispatch, getState) => {
// 		return resource('GET', 'articles')
// 		.then((response)=>{
// 			const articles = response.articles.reduce((object,item) => {
// 				object[item._id] = item;
// 				return object;
// 			},{})
// 			dispatch({type:Action.UPDATE_ARTICLES, articles});
// 		})
// 	}
// }

// export function createNewArticles(props){
// 	return (dispatch) => {
		
// 			const articles = initialStates.articles.reduce((object,item) => {
// 				object[item._id] = item;
// 				return object;
// 			},{})
// 			var id = (Math.floor(Math.random() * 900000) + 1)
// 			var newArticle = {"_id":id,"text":"test articles","date":"2017-06-30T19:22:22.758Z","img":"http://lorempixel.com/348/308/","comments":[],"author":"a tester user"}
			
// 			articles[id] = newArticle
// 			dispatch({type:Action.UPDATE_ARTICLES, articles});
		
// 	}
// }



export function createNewArticles(){

	return (dispatch) => {


			var id = (Math.floor(Math.random() * 900000) + 1)
			var newArticle = {"_id":id,"text":"test articles","date":"2017-06-30T19:22:22.758Z","img":"http://lorempixel.com/348/308/","comments":[],"author":"a tester user"}
			
			//console.log(articles)
			article[id] = newArticle
			dispatch({type:Action.UPDATE_ARTICLES, article});
		
	}
}




// export function createNewArticles(){
// 	return {type:Action.ERRORMSG, errorMsg:"Creating new articles is not functional yet!"};
// }



export function searchKeyword(keyword){
	return {type:Action.SEARCH_KEYWORD, keyword};
}

export default connect((state) => {
	return {
		articles: state.articles.articles
	}
})(createNewArticles)