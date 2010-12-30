package code.service.searchengine;

import java.util.List;

import code.dao.QuestionDao;
import code.service.searchstrategy.SearchStrategy;
import code.service.searchstrategy.imp.BlurSearchStrategy;
import code.service.searchstrategy.imp.PreciseSearchStrategy;

public class WordSearchEngine implements IWordSearchEngine{
	QuestionDao questionDao;
	private SearchStrategy searchStrategy;
	public WordSearchEngine(QuestionDao questionDao){
		this.questionDao = questionDao;
	}
	public List getWSResultQuestionList(String content) {
		return searchStrategy.getResultQuestionList(content);
	}

	public void setWordSearchType(int searchType) {
		System.out.println("in set Search type\n");
		switch(searchType)
		{
		case 0:
			System.out.println("choose blur searchstrategy\n");
			searchStrategy = (SearchStrategy) new BlurSearchStrategy(this.questionDao);
			
			break;
		case 1:
			searchStrategy = (SearchStrategy) new PreciseSearchStrategy(this.questionDao);
			break;
		default:
			break;
		}
		
	}

}
