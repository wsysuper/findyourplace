package code.dao;

import code.model.Googlemap;

public interface GooglemapDao {
	abstract public boolean addGooglemap(Googlemap map);
	abstract public Googlemap getGooglemap(int mapID);
}
