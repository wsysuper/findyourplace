package code.service.impl;

import java.util.List;

import code.dao.QuestionDao;
import code.model.Question;
import code.service.SearchAnswerService;

public class SearchAnswerServiceImpl implements SearchAnswerService{
	private QuestionDao questionDao;
	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public Question getCurrentQuestion(int questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getResultAnswerList(int questionId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
