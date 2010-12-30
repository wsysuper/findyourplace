package code.service.impl;

import java.util.List;

import code.model.*;
import code.dao.*;
import code.dao.hibernate.QuestionDaoHibernate;
import code.service.*;
import code.service.factory.SearchEngineFactory;
import code.service.searchengine.IMapSearchEngine;
import code.service.searchengine.IWordSearchEngine;
import code.service.searchstrategy.*;
import code.service.searchstrategy.imp.*;
public class SearchServiceImpl implements SearchService{
	private QuestionDao questionDao;
	private IMapSearchEngine imapSearchEngine;
	private IWordSearchEngine iwordSearchEngine;
	public SearchServiceImpl(){
		questionDao = new QuestionDaoHibernate();
	}
	public QuestionDao getQuestionDao(){
		return this.questionDao;
	}
	public void setQuestionDao(QuestionDao newQuestionDao){
		this.questionDao = newQuestionDao;
	}
	
	public List getWSResultQuestionList(String content){
		if(iwordSearchEngine == null)
		{
			this.iwordSearchEngine = (IWordSearchEngine) SearchEngineFactory.newInstance().createMapSearchEngine(questionDao);
			return this.iwordSearchEngine.getWSResultQuestionList(content);
		}
		else
			return this.iwordSearchEngine.getWSResultQuestionList(content);
		
	}
	public List getMSResultQuestionList(double lat,double lng){
		if(imapSearchEngine == null)
		{
			this.imapSearchEngine = SearchEngineFactory.newInstance().createMapSearchEngine(questionDao);
			return this.imapSearchEngine.getMSResultQuestionList(lat, lng);
		}
		else
			return this.imapSearchEngine.getMSResultQuestionList(lat, lng);
	}
	public List<Answer> getResultAnswerList(int questionId){
		return null;
	}
	public int getResultQuestionNum(){
		return 0;
	}
	public void setWordSearchType(int searchType){
		if(iwordSearchEngine == null)
		{
			this.iwordSearchEngine = SearchEngineFactory.newInstance().createWordSearchEngine(questionDao);
			this.iwordSearchEngine.setWordSearchType(searchType);
		}
		else
			this.iwordSearchEngine.setWordSearchType(searchType);
		
	}
	public List<Answer> getWSResultAnswerList(int questionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
