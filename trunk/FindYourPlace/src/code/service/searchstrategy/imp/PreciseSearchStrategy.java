package code.service.searchstrategy.imp;

import java.util.List;

import code.model.Answer;
import code.model.Question;
import code.service.searchstrategy.SearchStrategy;

public class PreciseSearchStrategy extends SearchStrategy{
	public List<Question> getResultQuestionList(String content){
		return null;
	}
	public List<List<Answer>> getResultAnswerList(List<Question> questionList){
		return null;
		
	}
	public int getResultQuestionNum(){
		return 0;
		
	}
}
