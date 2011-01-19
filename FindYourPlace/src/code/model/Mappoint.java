package code.model;

/**
 * Mappoint entity. @author MyEclipse Persistence Tools
 */

public class Mappoint implements java.io.Serializable {

	// Fields

	private Integer pointId;
	private Double latitude;
	private Double longitude;
	private Googlemap googlemap;

	// Constructors

	/** default constructor */
	public Mappoint() {
	}
	
	/** useful constructor */
	public Mappoint(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	// Property accessors

	public Integer getPointId() {
		return this.pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
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

	public Googlemap getGooglemap() {
		return googlemap;
	}

	public void setGooglemap(Googlemap googlemap) {
		this.googlemap = googlemap;
	}


}