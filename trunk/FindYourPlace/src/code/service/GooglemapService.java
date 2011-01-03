package code.service;

import code.model.Googlemap;

public interface GooglemapService {
	//用于添加问题；返回0表示添加成功，1表示用户积分不足，2表示其他失败
	abstract public boolean addGooglemap(Googlemap map);
	abstract public Googlemap getGooglemap(int mapID);
}
