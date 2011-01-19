package code.service;

import code.model.Answer;
import code.model.Question;

public interface GooglemapService {
	abstract public boolean saveGooglemap(Double latitude, Double longitude, int zoomLevel, String markArr);
}
