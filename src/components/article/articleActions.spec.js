import { expect } from 'chai'
import mockery from 'mockery'
import fetch, {mock} from 'mock-fetch'


describe('Validate Article actions', ()=> {
	
	let Action, resource, url, getArticles, searchKeyword
	
	beforeEach(() => {
		if(mockery.enable) {
			mockery.enable({warnOnUnregistered: false, useCleanCache:true})
			mockery.registerMock('node-fetch', fetch)
			require('node-fetch')
  		}
  		Action = require('../../actions').default
		resource = require('../../actions').resource
  		url = require('../../actions').url
  		getArticles = require('./articleActions').getArticles
  		searchKeyword = require('./articleActions').searchKeyword
	})

	afterEach(() => { 
  		if (mockery.enable) {
			mockery.deregisterMock('node-fetch')
			mockery.disable()
  		}
	})


	it('should fetch articles (mocked request)', (done)=>{
		mock(`${url}/articles`, {
			method: 'GET',
			headers: {'Content-Type':'application/json'},
			json:{articles:[]}
		})

		getArticles()((action)=>{
			try{
				expect(action.type).to.eql(Action.UPDATE_ARTICLES)
				expect(action.articles).to.exist;
				expect(action.articles).to.eql({});
				done()
			}
			catch(e){
				done(e)
			}	
		})
	})


	it('should update the search keyword',()=> {
		const keyword = 'my keyword'
		const action = searchKeyword(keyword);
		expect(action.type).to.eql(Action.SEARCH_KEYWORD)
		expect(action.keyword).to.eql(keyword)
	})
})