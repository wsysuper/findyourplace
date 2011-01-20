package code.service.factory;

import code.dao.GooglemapDao;
import code.dao.QuestionDao;
import code.service.SearchService;
import code.service.MapSearchService;
import code.service.impl.MapSearchServiceImpl;
import code.service.impl.SearchServiceImpl;
import code.service.searchengine.IMapSearchEngine;
import code.service.searchengine.IWordSearchEngine;
import code.service.searchengine.MapSearchEngine;
import code.service.searchengine.WordSearchEngine;

public class SearchEngineFactory {
	private static SearchEngineFactory searchServiceFactory;
	
	private SearchEngineFactory(){
		
	}
	public static SearchEngineFactory newInstance(){
		if(searchServiceFactory == null){
			searchServiceFactory = new SearchEngineFactory();
		}
		return searchServiceFactory;
	}
	
	public IWordSearchEngine createWordSearchEngine(QuestionDao questionDao){
		return (IWordSearchEngine) new WordSearchEngine(questionDao);
	}
	public IMapSearchEngine createMapSearchEngine(QuestionDao questionDao,GooglemapDao googlemapDao){
		return (IMapSearchEngine) new MapSearchEngine(questionDao,googlemapDao);
	}
	
}
