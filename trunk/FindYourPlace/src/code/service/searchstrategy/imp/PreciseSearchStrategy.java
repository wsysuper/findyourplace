package code.service.searchstrategy.imp;

import java.util.List;

import code.dao.QuestionDao;
import code.dao.hibernate.QuestionDaoHibernate;
import code.model.Answer;
import code.model.Question;
import code.service.searchstrategy.SearchStrategy;

public class PreciseSearchStrategy extends SearchStrategy{
	private QuestionDao questionDao;
	public PreciseSearchStrategy(QuestionDao newQuestionDao){
		System.out.println("in blur search constructor\n");
		questionDao = new QuestionDaoHibernate();
		questionDao = newQuestionDao;
	}
	public List getResultQuestionList(String content){
		return questionDao.getPreFoundQuestionList(content);
	}
	public List<List<Answer>> getResultAnswerList(List<Question> questionList){
		return null;
		
	}
	public int getResultQuestionNum(){
		return 0;
		
	}
}
