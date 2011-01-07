package code.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Mappolyline entity. @author MyEclipse Persistence Tools
 */

public class Mappolyline implements java.io.Serializable {

	// Fields

	private Integer polylineId;
	private Integer mapId;
	private Set mappolypoints = new HashSet(0);

	// Constructors

	/** default constructor */
	public Mappolyline() {
	}

	/** full constructor */
	public Mappolyline(Integer mapId, Set mappolypoints) {
		this.mapId = mapId;
		this.mappolypoints = mappolypoints;
	}

	// Property accessors

	public Integer getPolylineId() {
		return this.polylineId;
	}

	public void setPolylineId(Integer polylineId) {
		this.polylineId = polylineId;
	}

	public Integer getMapId() {
		return this.mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Set getMappolypoints() {
		return this.mappolypoints;
	}

	public void setMappolypoints(Set mappolypoints) {
		this.mappolypoints = mappolypoints;
	}

}