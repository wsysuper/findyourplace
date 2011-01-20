package code.service.searchengine;

import java.util.List;

import code.dao.QuestionDao;
import code.dao.GooglemapDao;
import code.dao.hibernate.GooglemapDaoHibernate;

public class MapSearchEngine implements IMapSearchEngine{
	QuestionDao questionDao;
	GooglemapDao googlemapDao;
	public MapSearchEngine(QuestionDao questionDao,GooglemapDao googlemapDao){
		this.questionDao = questionDao;
		this.googlemapDao =googlemapDao;
	}
	public List getMSResultQuestionList(double lat, double lng) {
		System.out.println("in getMSResultQuestionList");
		// TODO Auto-generated method stub
		List mapResult = googlemapDao.getAreaGooglemap(lng, lat);
		List questionList = questionDao.getMapQuestionList(mapResult);
		if(questionList.size() == 0)
			System.out.println("questionList is empty");
		return questionList;
	}

}
