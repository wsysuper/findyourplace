package code.service;

import java.util.List;

import code.model.Answer;

public interface MapSearchService {
	public abstract List getResultQuestionList(double lat,double lng);
	public abstract List<Answer> getResultAnswerList(int questionId);
}
