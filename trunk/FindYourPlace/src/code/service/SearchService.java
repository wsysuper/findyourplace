package code.service;

import code.model.*;
import java.util.*;
import code.service.searchstrategy.*;
public interface SearchService {
	public abstract void setWordSearchType(int searchType);
	public abstract List getWSResultQuestionList(String content);
	public abstract List getMSResultQuestionList(double lat,double lng);
	public abstract List<Answer> getWSResultAnswerList(int questionId);
	public abstract int getResultQuestionNum();
}
