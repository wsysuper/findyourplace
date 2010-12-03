package code.service.impl;

import java.sql.Date;

import code.dao.QuestionDao;
import code.model.Question;
import code.model.User;
import code.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {
	private QuestionDao questionDao;
	
	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public boolean addQuestion(Question question, User user) {
		// TODO Auto-generated method stub
		if (user == null) return false;
		else {
			question.setPubDate(new Date(System.currentTimeMillis()));
			question.setUser(user);
			return questionDao.addQuestion(question);
		}
	}
}
