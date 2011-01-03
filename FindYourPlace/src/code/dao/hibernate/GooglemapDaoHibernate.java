package code.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import code.dao.GooglemapDao;
import code.model.Googlemap;
import java.util.*;

public class GooglemapDaoHibernate extends HibernateDaoSupport implements
		GooglemapDao {

	public boolean addGooglemap(Googlemap map) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(map);
		return true;
	}

	public Googlemap getGooglemap(int mapID) {
		// TODO Auto-generated method stub

		List result = this.getHibernateTemplate().find(
				"from Googlemap m where m.mapID = " + mapID);

		if (result.size() == 0)
			return null;
		else
			return (Googlemap) result.get(0);
	}

}
