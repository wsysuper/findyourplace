package code.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.model.Googlemap;

/**
 * A data access object (DAO) providing persistence and search support for
 * Googlemap entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see code.model.Googlemap
 * @author MyEclipse Persistence Tools
 */

public class GooglemapDao extends HibernateDaoSupport {

	private static final Log log = LogFactory.getLog(GooglemapDao.class);
	// property constants
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String ZOOM_LEVEL = "zoomLevel";
	public static final String QUESTION_ID = "questionId";
	public static final String ANSWER_ID = "answerId";
	public static final String HAS_POINT = "hasPoint";
	public static final String HAS_POLYLINES = "hasPolylines";

	protected void initDao() {
		// do nothing
	}
	
	public boolean addGooglemap(Googlemap googlemap)
	{
		save(googlemap);
		return true;
	}

	public void save(Googlemap transientInstance) {
		log.debug("saving Googlemap instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Googlemap persistentInstance) {
		log.debug("deleting Googlemap instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Googlemap findById(java.lang.Integer id) {
		log.debug("getting Googlemap instance with id: " + id);
		try {
			Googlemap instance = (Googlemap) getHibernateTemplate().get(
					"code.model.Googlemap", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Googlemap instance) {
		log.debug("finding Googlemap instance by example");
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
		log.debug("finding Googlemap instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Googlemap as model where model."
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

	public List findByZoomLevel(Object zoomLevel) {
		return findByProperty(ZOOM_LEVEL, zoomLevel);
	}

	public List findByQuestionId(Object questionId) {
		return findByProperty(QUESTION_ID, questionId);
	}

	public List findByAnswerId(Object answerId) {
		return findByProperty(ANSWER_ID, answerId);
	}

	public List findByHasPoint(Object hasPoint) {
		return findByProperty(HAS_POINT, hasPoint);
	}

	public List findByHasPolylines(Object hasPolylines) {
		return findByProperty(HAS_POLYLINES, hasPolylines);
	}

	public List findAll() {
		log.debug("finding all Googlemap instances");
		try {
			String queryString = "from Googlemap";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Googlemap merge(Googlemap detachedInstance) {
		log.debug("merging Googlemap instance");
		try {
			Googlemap result = (Googlemap) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Googlemap instance) {
		log.debug("attaching dirty Googlemap instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Googlemap instance) {
		log.debug("attaching clean Googlemap instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GooglemapDao getFromApplicationContext(ApplicationContext ctx) {
		return (GooglemapDao) ctx.getBean("GooglemapDAO");
	}
}