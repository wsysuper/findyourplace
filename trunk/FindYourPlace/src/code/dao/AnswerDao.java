package code.dao;

import code.model.Answer;
import code.model.Question;
import java.util.*;
public interface AnswerDao {
	public boolean addAnswer(Answer answer);
	public List<Answer> getPreFoundAnswerList(String content);
	public List<Answer> getBlurFoundAnswerList(String content);
}
