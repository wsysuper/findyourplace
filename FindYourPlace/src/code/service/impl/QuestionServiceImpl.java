package code.service.impl;

import java.sql.Date;

import code.dao.QuestionDao;
import code.dao.UserDao;
import code.model.Question;
import code.model.User;
import code.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {
	private QuestionDao questionDao;
	private UserDao userDao;
	
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

	public int addQuestion(Question question, User user) {
		// TODO Auto-generated method stub
		if (user == null) return 2;
		else {
			//扣除用户的相应积分，防止用户不断提问
			boolean success = userDao.deductPoint(user.getUserName(), question.getReward());
			if (success) {
				//设置提问时间
				question.setPubDate(new Date(System.currentTimeMillis()));
				question.setUser(user);
				//返回0表示成功
				if (questionDao.addQuestion(question)) return 0;
				else return 2;
			}
			//返回1表示积分不足
			else return 1;
		}
	}
	
	public Question getQuestion(int questionID) {
		return questionDao.getQuestion(questionID);
	}
}
