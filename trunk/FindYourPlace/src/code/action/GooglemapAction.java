package code.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import code.dao.hibernate.GooglemapDaoHibernate;
import code.model.Googlemap;
import code.model.Mappoint;
import code.service.GooglemapService;

import com.opensymphony.xwork2.ActionSupport;

public class GooglemapAction extends ActionSupport {
	/**
	 * @author WSY
	 */
	private static final long serialVersionUID = 1L;
	private int questionID;
	private GooglemapService googlemapService;

	private Googlemap gmap;
	
	private int answerID;

	private Double[] pointArr; // for show
	private Double latitude; // for show & save
	private Double longitude; // for show & save
	private int zoomLevel; // for show & save
	private String markArr; // for save
	private int mapId;

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public GooglemapService getGooglemapService() {
		return googlemapService;
	}

	public void setGooglemapService(GooglemapService googlemapService) {
		this.googlemapService = googlemapService;
	}

	public Googlemap getGmap() {
		return gmap;
	}

	public void setGmap(Googlemap gmap) {
		this.gmap = gmap;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public Double[] getPointArr() {
		return pointArr;
	}

	public void setPointArr(Double[] pointArr) {
		this.pointArr = pointArr;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public int getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

	public String getMarkArr() {
		return markArr;
	}

	public void setMarkArr(String markArr) {
		this.markArr = markArr;
	}

	@SuppressWarnings("unchecked")
	public String showMap() {
		// gmap = googlemapService.getGooglemap(getMapID());

		// /////////////////FROM HERE///////////////////////
		System.out.println("questionid:"+questionID);
		System.out.println("mapId"+mapId);
		Googlemap map = new Googlemap();
		
		map=this.googlemapService.getGooglemapByID(mapId);
		if(map.getLatitude()==null && map.getLongitude()==null && map.getZoomLevel()==0)
		{
		
		}
		System.out.println("mapId"+map.getMapId());
		System.out.println("mapId"+map.getLatitude());
		System.out.println("mapId"+map.getLongitude());
		System.out.println("mapId"+map.getZoomLevel());
		
		gmap = new Googlemap();
		Set<Mappoint> mappoints = new HashSet(0);
		mappoints.add(new Mappoint(31.021338250285662, 121.43236219882965));
		mappoints.add(new Mappoint(31.023374776798356, 121.43765419721603));

		gmap.setLatitude(map.getLatitude());
		gmap.setLongitude(map.getLongitude());
		gmap.setZoomLevel(map.getZoomLevel());
		gmap.setMappoints(mappoints);
		// /////////////////CODES ABOVE IS ONLY USED FOR TEST///////////////////////
		// /////////////////WHEN PRACTICALLY USINT IT, JUST PASS AN INSTANCE OF GMAP///////////////////////
		//gmap=googlemapService.getGooglemapByID(4);

		latitude = googlemapService.getActionLatitude(gmap);//gmap.getLatitude();
		longitude = googlemapService.getActionLongitude(gmap);
		zoomLevel = googlemapService.getActionZoomLevel(gmap);
		pointArr = googlemapService.getActionPointArr(gmap);
		
		return SUCCESS;
	}

	public String saveMap() {
		googlemapService.saveGooglemap(latitude, longitude, zoomLevel, markArr);
		return SUCCESS;
	}
}
