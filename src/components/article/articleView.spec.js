import React from 'react'
import TestUtils from 'react-addons-test-utils'
import {findDOMNode} from 'react-dom'
import {expect} from 'chai'
import {shallow} from 'enzyme'

import {ArticleView} from './articleView'
import {NewArticle} from './newArticle'


describe('ArticlesView (component tests)', ()=> {
	
	it('should render articles', ()=>{
		const articles = [{_id:1, text:'hello world!', author:'by8', date:'2016-10-24',comments:[],img:''},
						  	{_id:2, text:'hello javascript', author:'by8', date:'2016-10-24',comments:[],img:''}]
		const node = shallow(<ArticleView articleList = {articles} dispatch={_ => _}/>)
		expect(node.children().length).to.eql(5);
		expect(node.children().nodes[3].key).to.eql('1');
		expect(node.children().nodes[4].key).to.eql('2');
	})


	it('should dispatch actions to create a new article',()=> {
		let called = false
		const node = TestUtils.renderIntoDocument(<div><NewArticle createNewArticle={_ => called = true}/></div>)
		const elements = findDOMNode(node).children[0]
		TestUtils.Simulate.click(elements.children[4])
		expect(called).to.be.true
	})
})