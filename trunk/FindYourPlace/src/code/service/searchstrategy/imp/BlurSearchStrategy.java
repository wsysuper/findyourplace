package code.service.searchstrategy.imp;

import java.util.List;

import code.model.Answer;
import code.model.Question;
import code.dao.*;
import code.dao.hibernate.QuestionDaoHibernate;
import code.service.searchstrategy.*;
public class BlurSearchStrategy extends SearchStrategy {
	private QuestionDao questionDao;
	public BlurSearchStrategy(QuestionDao newQuestionDao){
		System.out.println("in blur search constructor\n");
		questionDao = new QuestionDaoHibernate();
		questionDao = newQuestionDao;
	}
	public List getResultQuestionList(String content){
		System.out.println("in blursearchstrategy\n");
		if(questionDao == null)
			System.out.println("questionDao null\n");
		System.out.println(content);
		return questionDao.getBlurFoundQuestionList(content);
	}
	public List<List<Answer>> getResultAnswerList(List<Question> questionList){
		return null;
		
	}
	public int getResultQuestionNum() {
		// TODO Auto-generated method stub
		return 0;
	}
}
