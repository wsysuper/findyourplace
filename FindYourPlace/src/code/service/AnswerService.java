package code.service;

import code.model.Answer;
import code.model.Question;
import code.model.User;
import java.util.*;

public interface AnswerService {
	public boolean addAnswer(Question question, User user,Answer answer);
	public Question getQuestion(int questionID);
	public List<Answer> getAnswerList(int questionID);
}
