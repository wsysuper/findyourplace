package code.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Googlemap entity. @author MyEclipse Persistence Tools
 */

public class Googlemap implements java.io.Serializable {

	// Fields

	private Integer mapId;
	private Double latitude;
	private Double longitude;
	private Integer zoomLevel;
//	private Set mappolylines = new HashSet(0);
	private Set mappoints = new HashSet(0);

	// Constructors

	/** default constructor */
	public Googlemap() {
//		hasPoint = false;
//		hasPolylines = 0;
		// where I exactly live right now
		latitude = 31.021338250285662;
		longitude = 121.43236219882965;
		zoomLevel = 16;
	}

	// Property accessors

	public Integer getMapId() {
		return this.mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getZoomLevel() {
		return this.zoomLevel;
	}

	public void setZoomLevel(Integer zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

	public Set getMappoints() {
		return this.mappoints;
	}

	public void setMappoints(Set mappoints) {
		this.mappoints = mappoints;
	}

}