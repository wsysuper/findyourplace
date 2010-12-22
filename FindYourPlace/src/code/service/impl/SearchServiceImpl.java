package code.service.impl;

import java.util.List;

import code.model.*;
import code.dao.*;
import code.service.*;
import code.service.searchstrategy.*;
import code.service.searchstrategy.imp.*;
public class SearchServiceImpl implements SearchService{
	private QuestionDao questionDao;
	private SearchStrategy searchStrategy;
	public QuestionDao getQuestionDao(){
		return this.questionDao;
	}
	public void setQuestionDao(QuestionDao newQuestionDao){
		this.questionDao = newQuestionDao;
	}
	
	public List getResultQuestionList(String content){
		return searchStrategy.getResultQuestionList(content);
		
	}
	public List<Answer> getResultAnswerList(int questionId){
		return null;
	}
	public int getResultQuestionNum(){
		return 0;
	}
	public void setSearchType(int searchType){
		System.out.println("in set Search type\n");
		switch(searchType)
		{
		case 0:
			System.out.println("choose blur searchstrategy\n");
			searchStrategy = (SearchStrategy) new BlurSearchStrategy(this.questionDao);
			break;
		case 1:
			searchStrategy = (SearchStrategy) new PreciseSearchStrategy(this.questionDao);
			break;
		default:
			break;
		}
		
	}
	

}
