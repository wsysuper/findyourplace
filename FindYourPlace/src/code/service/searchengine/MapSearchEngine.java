package code.service.searchengine;

import java.util.List;

import code.dao.QuestionDao;

public class MapSearchEngine implements IMapSearchEngine{
	QuestionDao questionDao;
	public MapSearchEngine(QuestionDao questionDao){
		this.questionDao = questionDao;
	}
	public List getMSResultQuestionList(double lat, double lng) {
		// TODO Auto-generated method stub
		return null;
	}

}
