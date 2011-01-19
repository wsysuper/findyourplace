package code.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import code.model.Googlemap;
import code.model.Mappoint;
import code.service.GooglemapService;

import com.opensymphony.xwork2.ActionSupport;

public class GooglemapAction extends ActionSupport {
	/**
	 * @author WSY
	 */
	private static final long serialVersionUID = 1L;

	private GooglemapService googlemapService;

	private Googlemap gmap;
	private Integer questionID;
	private Integer answerID;

	private Double[] pointArr; // for show
	private Double latitude; // for show & save
	private Double longitude; // for show & save
	private int zoomLevel; // for show & save
	private String markArr; // for save

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

	public Integer getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}

	public Integer getAnswerID() {
		return answerID;
	}

	public void setAnswerID(Integer answerID) {
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
		gmap = new Googlemap();
		Set<Mappoint> mappoints = new HashSet(0);
		mappoints.add(new Mappoint(31.021338250285662, 121.43236219882965));
		mappoints.add(new Mappoint(31.023374776798356, 121.43765419721603));

		gmap.setHasPoint(true);
		gmap.setHasPolylines(0);
		gmap.setLatitude(31.022634644658957);
		gmap.setLongitude(121.43495589494705);
		gmap.setZoomLevel(16);
		gmap.setMappoints(mappoints);
		// /////////////////CODES ABOVE IS ONLY USED FOR TEST///////////////////////
		// /////////////////WHEN PRACTICALLY USINT IT, JUST PASS AN INSTANCE OF GMAP///////////////////////

		latitude = gmap.getLatitude();
		longitude = gmap.getLongitude();
		zoomLevel = gmap.getZoomLevel();
		Set<Mappoint> pointSet = null;
		if (gmap.getHasPoint()) {
			pointSet = gmap.getMappoints();
			Iterator<Mappoint> iter = pointSet.iterator();
			pointArr = new Double[pointSet.size() * 2];// 该数组依次存各个MapPoint的纬度经度
			int i = 0;
			while (iter.hasNext()) {
				Mappoint temp = iter.next();
				pointArr[i++] = temp.getLatitude();
				pointArr[i++] = temp.getLongitude();
			}
		}
		return SUCCESS;

	}

	public String saveMap() {
		googlemapService.saveGooglemap(latitude, longitude, zoomLevel, markArr);
		return SUCCESS;
	}
}
