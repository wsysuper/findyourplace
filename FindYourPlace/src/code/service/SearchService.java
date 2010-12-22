package code.service;

import code.model.*;
import java.util.*;
import code.service.searchstrategy.*;
public interface SearchService {
	public abstract void setSearchType(int searchType);
	public abstract List getResultQuestionList(String content);
	public abstract List<Answer> getResultAnswerList(int questionId);
	public abstract int getResultQuestionNum();
}
