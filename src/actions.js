import Promise from 'bluebird'
import fetch from 'isomorphic-fetch'

//All simple dispatch action type and functions

const local = false;
export const url = local? 'http://localhost:2222' : 'https://webdev-dummy.herokuapp.com'


const Action = {
    ERRORMSG:'error message',
    SUCCESSMSG: 'success message',

    NAV2MAIN: 'navigate to main page',
    NAV2INDEX: 'navigate to index page',
    NAV2PROFILE: 'navigate to profile page',

    LOGIN: 'login',
    LOGOUT: 'logout',

    UPDATE_PROFILE: 'update profile',

    UPDATE_FOLLOWERS: 'update followers',

    UPDATE_ARTICLES: 'update articles',
    SEARCH_KEYWORD: 'search keyword'
}

export default Action

export function displayErrorMsg(msg){
    return {type: Action.ERRORMSG, errorMsg: msg};
}

export function displaySuccessMsg(msg){
    return {type: Action.SUCCESSMSG, successMsg: msg};
}

export function nav2Main(){
    return {type: Action.NAV2MAIN};
}

export function nav2Profile(){
    return {type: Action.NAV2PROFILE};
}

export function nav2Index(){
    return {type: Action.NAV2INDEX};
}

export function resource(method, endpoint, payload){
    const options =  {
        method,
        credentials: 'include',
        headers: {'Content-Type': 'application/json'}
    }
    
    if (payload) options.body = JSON.stringify(payload)

    return fetch(`${url}/${endpoint}`, options)
    .then(response => {
        if (response.status === 200) {
            if (response.headers.get('Content-Type').indexOf('json') > 0) {
                return response.json()
            }else {
                return response.text()
            }
        } else {
            // useful for debugging, but remove in production
            //console.error(`${method} ${endpoint} ${response.statusText}`)
            throw new Error(response.statusText)
        }
    })
}