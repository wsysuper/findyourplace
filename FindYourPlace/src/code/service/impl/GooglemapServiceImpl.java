package code.service.impl;

import java.util.HashSet;
import java.util.Set;

import code.dao.GooglemapDao;
import code.model.Answer;
import code.model.Googlemap;
import code.model.Mappoint;
import code.model.Question;
import code.service.GooglemapService;

public class GooglemapServiceImpl implements GooglemapService {

	private GooglemapDao googlemapDao;
	private Googlemap map;

	public GooglemapDao getGooglemapDao() {
		return googlemapDao;
	}

	public void setGooglemapDao(GooglemapDao googlemapDao) {
		this.googlemapDao = googlemapDao;
	}

	public boolean saveGooglemap(Double latitude, Double longitude,
			int zoomLevel, String markArr) {
		// TODO Auto-generated method stub
		// System.out.println(latitude);
		// System.out.println(longitude);
		// System.out.println(zoomLevel);
		// System.out.println(markArr);

		map = new Googlemap();
		map.setLatitude(latitude);
		map.setLongitude(longitude);
		map.setZoomLevel(zoomLevel);
		if (markArr.length() != 0) {
			Set mappoints = parse(markArr);
			map.setMappoints(mappoints);
		}
		System.out.println("saving:");
		System.out.println(map.getLatitude());
		System.out.println(map.getLongitude());
		System.out.println(map.getZoomLevel());
		System.out.println(markArr);
		
		System.out.println(map.getMappoints().isEmpty());
		//return false;
		return googlemapDao.addGooglemap(map);
	}

	private Set parse(String markArr) {

		String[] outer = markArr.split(";");

		Set latlng = new HashSet(0);
		for(int i = 0; i < outer.length; i++)
		{
			String[] inner = outer[i].split(",");
			
			if(inner[0].equals("1"))
			{
				latlng.add(new Mappoint(Double.valueOf(inner[1]),Double.valueOf(inner[2])));
			}
		}
		return latlng;
	}
}
