package code.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.model.Mappolypoint;

/**
 * A data access object (DAO) providing persistence and search support for
 * Mappolypoint entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see code.model.Mappolypoint
 * @author MyEclipse Persistence Tools
 */

public class MappolypointDao extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(MappolypointDao.class);
	// property constants
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String POLYLINE_ID = "polylineId";

	protected void initDao() {
		// do nothing
	}

	public void save(Mappolypoint transientInstance) {
		log.debug("saving Mappolypoint instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mappolypoint persistentInstance) {
		log.debug("deleting Mappolypoint instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mappolypoint findById(java.lang.Integer id) {
		log.debug("getting Mappolypoint instance with id: " + id);
		try {
			Mappolypoint instance = (Mappolypoint) getHibernateTemplate().get(
					"code.model.Mappolypoint", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Mappolypoint instance) {
		log.debug("finding Mappolypoint instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Mappolypoint instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Mappolypoint as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List findByPolylineId(Object polylineId) {
		return findByProperty(POLYLINE_ID, polylineId);
	}

	public List findAll() {
		log.debug("finding all Mappolypoint instances");
		try {
			String queryString = "from Mappolypoint";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mappolypoint merge(Mappolypoint detachedInstance) {
		log.debug("merging Mappolypoint instance");
		try {
			Mappolypoint result = (Mappolypoint) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mappolypoint instance) {
		log.debug("attaching dirty Mappolypoint instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mappolypoint instance) {
		log.debug("attaching clean Mappolypoint instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MappolypointDao getFromApplicationContext(
			ApplicationContext ctx) {
		return (MappolypointDao) ctx.getBean("MappolypointDAO");
	}
}