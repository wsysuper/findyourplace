package code.service.impl;

import java.sql.Date;

import code.dao.AnswerDao;
import code.dao.QuestionDao;
import code.dao.UserDao;
import code.model.Answer;
import code.model.Question;
import code.model.User;
import code.service.AnswerService;

public class AnswerServiceImpl implements AnswerService {
	private AnswerDao answerDao;
	private QuestionDao questionDao;
	private UserDao userDao;
	
	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	
	public boolean addAnswer(Question question, User user,Answer answer) {
		// TODO Auto-generated method stub
		if((question==null) || (user == null))return false;
		else {
			answer.setPubDate(new Date(System.currentTimeMillis()));
			answer.setUser(user);
			answer.setQuestion(question);
		    
			return answerDao.addAnswer(answer);
		}
	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
