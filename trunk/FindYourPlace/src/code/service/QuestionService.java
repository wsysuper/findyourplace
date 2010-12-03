package code.service;

import code.model.Question;
import code.model.User;

public interface QuestionService {
	public boolean addQuestion(Question question, User user);
}
