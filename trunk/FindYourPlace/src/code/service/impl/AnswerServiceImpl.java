package code.service.impl;

import java.sql.Date;
import java.util.List;

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
	public Question getQuestion(int questionID) {
		return answerDao.getQuestion(questionID);
	}
	public List getAnswerList(int questionID) {
		return answerDao.getAnswerList(questionID);
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
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
