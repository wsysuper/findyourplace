package code.service;

import java.util.List;

import code.model.Question;
import code.model.User;

public interface QuestionService {
	//用于添加问题；返回0表示添加成功，1表示用户积分不足，2表示其他失败
	public int addQuestion(Question question, User user);
	//根据问题ID得到问题
	public Question getQuestion(int questionID);
	//得到最近5天内的问题
	public List<Question> getLatestQuestion();
}
