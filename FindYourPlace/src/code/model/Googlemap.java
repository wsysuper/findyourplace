package code.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Googlemap entity. @author MyEclipse Persistence Tools
 */

public class Googlemap implements java.io.Serializable {

	// Fields

	private Integer mapID;
	private Answer answer;
	private Question question;
	private Double latitude;
	private Double longitude;
	private Integer zoomLevel;
	private Boolean hasPoint;
	private Integer hasPolylines;
	private Set mappolylines = new HashSet(0);
	private Set mappoints = new HashSet(0);

	// Constructors

	/** default constructor */
	public Googlemap() {
	}

	/** full constructor */
	public Googlemap(Answer answer, Question question, Double latitude,
			Double longitude, Integer zoomLevel, Boolean hasPoint,
			Integer hasPolylines, Set mappolylines, Set mappoints) {
		this.answer = answer;
		this.question = question;
		this.latitude = latitude;
		this.longitude = longitude;
		this.zoomLevel = zoomLevel;
		this.hasPoint = hasPoint;
		this.hasPolylines = hasPolylines;
		this.mappolylines = mappolylines;
		this.mappoints = mappoints;
	}

	// Property accessors

	public Integer getMapID() {
		return this.mapID;
	}

	public void setMapID(Integer mapID) {
		this.mapID = mapID;
	}

	public Answer getAnswer() {
		return this.answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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