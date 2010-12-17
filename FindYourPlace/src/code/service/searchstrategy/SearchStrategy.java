package code.service.searchstrategy;

import java.util.List;

import code.model.Answer;
import code.model.Question;

public abstract class SearchStrategy {
	public abstract List getResultQuestionList(String content);
	public abstract List<List<Answer>> getResultAnswerList(List<Question> questionList);
	public abstract int getResultQuestionNum();
}
