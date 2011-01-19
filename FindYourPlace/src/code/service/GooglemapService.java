package code.service;

import code.model.Googlemap;

public interface GooglemapService {
	abstract public int saveGooglemap(Double latitude, Double longitude, int zoomLevel, String markArr);
	abstract public double getActionLatitude(Googlemap gmap);
	abstract public double getActionLongitude(Googlemap gmap);
	abstract public int getActionZoomLevel(Googlemap gmap);
	abstract public Double[] getActionPointArr(Googlemap gmap);
	abstract public Googlemap getGooglemapByID(int mapID);
}
