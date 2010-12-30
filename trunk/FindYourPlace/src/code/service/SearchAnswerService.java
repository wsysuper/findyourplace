package code.service;

import java.util.List;

import code.model.Question;

public interface SearchAnswerService {
	public abstract List getResultAnswerList(int questionId);
	public abstract Question getCurrentQuestion(int questionId);
}
