package code.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.dao.MappointDao;
import code.model.Mappoint;

public class MappointDaoHibernate extends HibernateDaoSupport implements
		MappointDao {
	public void addMappoint(Mappoint transientInstance) {
		// TODO Auto-generated method stub
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
