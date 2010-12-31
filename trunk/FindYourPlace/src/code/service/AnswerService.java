package code.service;

import code.model.Answer;
import code.model.Question;
import code.model.User;

public interface AnswerService {
	public boolean addAnswer(Question question, User user,Answer answer);
}
