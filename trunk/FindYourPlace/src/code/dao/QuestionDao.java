package code.dao;

import code.model.Question;
import java.util.*;
public interface QuestionDao {
	public boolean addQuestion(Question question);
	public Question getQuestion(int questionId);
	public List<Question> getPreFoundQuestionList(String content);
	public List<Question> getBlurFoundQuestionList(String content);
	//得到距离当前时间不超过该毫秒数的问题
	public List<Question> getLatestQuestion(int millisec);
	public List<Question> getMapQuestionList(List mapList);
}
