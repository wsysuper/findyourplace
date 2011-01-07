package code.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.model.Mappolyline;

/**
 * A data access object (DAO) providing persistence and search support for
 * Mappolyline entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see code.model.Mappolyline
 * @author MyEclipse Persistence Tools
 */

public class MappolylineDao extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(MappolylineDao.class);
	// property constants
	public static final String MAP_ID = "mapId";

	protected void initDao() {
		// do nothing
	}

	public void save(Mappolyline transientInstance) {
		log.debug("saving Mappolyline instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mappolyline persistentInstance) {
		log.debug("deleting Mappolyline instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mappolyline findById(java.lang.Integer id) {
		log.debug("getting Mappolyline instance with id: " + id);
		try {
			Mappolyline instance = (Mappolyline) getHibernateTemplate().get(
					"code.model.Mappolyline", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Mappolyline instance) {
		log.debug("finding Mappolyline instance by example");
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
		log.debug("finding Mappolyline instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mappolyline as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMapId(Object mapId) {
		return findByProperty(MAP_ID, mapId);
	}

	public List findAll() {
		log.debug("finding all Mappolyline instances");
		try {
			String queryString = "from Mappolyline";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mappolyline merge(Mappolyline detachedInstance) {
		log.debug("merging Mappolyline instance");
		try {
			Mappolyline result = (Mappolyline) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mappolyline instance) {
		log.debug("attaching dirty Mappolyline instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mappolyline instance) {
		log.debug("attaching clean Mappolyline instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MappolylineDao getFromApplicationContext(
			ApplicationContext ctx) {
		return (MappolylineDao) ctx.getBean("MappolylineDAO");
	}
}