package code.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.dao.GooglemapDao;
import code.model.Googlemap;

public class GooglemapDaoHibernate extends HibernateDaoSupport implements
		GooglemapDao {

	public boolean addGooglemap(Googlemap googlemap) {
		try {
			getHibernateTemplate().save(googlemap);
		} catch (RuntimeException re) {
			throw re;
		}
		return true;
	}

}
