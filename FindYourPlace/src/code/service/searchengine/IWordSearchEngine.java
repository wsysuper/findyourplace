package code.service.searchengine;

import java.util.List;

public interface IWordSearchEngine {
	public abstract void setWordSearchType(int searchType);
	public abstract List getWSResultQuestionList(String content);
}
