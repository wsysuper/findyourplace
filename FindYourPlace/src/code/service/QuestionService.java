package code.service;

import code.model.Question;
import code.model.User;

public interface QuestionService {
	//用于添加问题；返回0表示添加成功，1表示用户积分不足，2表示其他失败
	public int addQuestion(Question question, User user);
	//根据问题ID得到问题
	public Question getQuestion(int questionID);
}
