package code.model;

/**
 * Mappolypoint entity. @author MyEclipse Persistence Tools
 */

public class Mappolypoint implements java.io.Serializable {

	// Fields

	private Integer polypointId;
	private Double latitude;
	private Double longitude;
	private Integer polylineId;

	// Constructors

	/** default constructor */
	public Mappolypoint() {
	}

	/** full constructor */
	public Mappolypoint(Double latitude, Double longitude, Integer polylineId) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.polylineId = polylineId;
	}

	// Property accessors

	public Integer getPolypointId() {
		return this.polypointId;
	}

	public void setPolypointId(Integer polypointId) {
		this.polypointId = polypointId;
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

	public Integer getPolylineId() {
		return this.polylineId;
	}

	public void setPolylineId(Integer polylineId) {
		this.polylineId = polylineId;
	}

}