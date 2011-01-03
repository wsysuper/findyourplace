package code.dao;

import code.model.Answer;
import code.model.Question;
import java.util.*;
public interface AnswerDao {
	public boolean addAnswer(Answer answer);
	public Question getQuestion(int questionID);
	public List<Answer> getAnswerList(int questionID);
	
}
