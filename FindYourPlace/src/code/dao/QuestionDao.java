package code.dao;

import code.model.Question;
import java.util.*;
public interface QuestionDao {
	public boolean addQuestion(Question question);
	public Question getQuestion(int questionId);
	public List<Question> getPreFoundQuestionList(String content);
	public List<Question> getBlurFoundQuestionList(String content);
}
