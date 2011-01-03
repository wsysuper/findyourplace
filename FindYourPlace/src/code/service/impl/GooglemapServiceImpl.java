package code.service.impl;

import code.dao.GooglemapDao;
import code.model.Googlemap;
import code.service.GooglemapService;

public class GooglemapServiceImpl implements GooglemapService {

	private GooglemapDao googlemapDao;
	
	public GooglemapDao getGooglemapDao() {
		return googlemapDao;
	}

	public void setGooglemapDao(GooglemapDao googlemapDao) {
		this.googlemapDao = googlemapDao;
	}

	public boolean addGooglemap(Googlemap map) {
		// TODO Auto-generated method stub
		return googlemapDao.addGooglemap(map);
	}

	public Googlemap getGooglemap(int mapID) {
		// TODO Auto-generated method stub
		return googlemapDao.getGooglemap(mapID);
	}

}
