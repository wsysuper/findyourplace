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
	private Integer questionId;
	private Integer answerId;
	private Boolean hasPoint;
	private Integer hasPolylines;
	private Set mappolylines = new HashSet(0);
	private Set mappoints = new HashSet(0);

	// Constructors

	/** default constructor */
	public Googlemap() {
		hasPoint = false;
		hasPolylines = 0;
		// where I exactly live right now
		latitude = 31.021338250285662;
		longitude = 121.43236219882965;
		zoomLevel = 16;
	}

	/** full constructor */
	public Googlemap(Double latitude, Double longitude, Integer zoomLevel,
			Integer questionId, Integer answerId, Boolean hasPoint,
			Integer hasPolylines, Set mappolylines, Set mappoints) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.zoomLevel = zoomLevel;
		this.questionId = questionId;
		this.answerId = answerId;
		this.hasPoint = hasPoint;
		this.hasPolylines = hasPolylines;
		this.mappolylines = mappolylines;
		this.mappoints = mappoints;
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

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public Boolean getHasPoint() {
		return this.hasPoint;
	}

	public void setHasPoint(Boolean hasPoint) {
		this.hasPoint = hasPoint;
	}

	public Integer getHasPolylines() {
		return this.hasPolylines;
	}

	public void setHasPolylines(Integer hasPolylines) {
		this.hasPolylines = hasPolylines;
	}

	public Set getMappolylines() {
		return this.mappolylines;
	}

	public void setMappolylines(Set mappolylines) {
		this.mappolylines = mappolylines;
	}

	public Set getMappoints() {
		return this.mappoints;
	}

	public void setMappoints(Set mappoints) {
		this.mappoints = mappoints;
	}

}