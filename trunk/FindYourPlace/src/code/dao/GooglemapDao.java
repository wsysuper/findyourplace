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

public interface GooglemapDao {
	public int addGooglemap(Googlemap googlemap);
	public Googlemap getGooglemap(int mapID);

	public List getAreaGooglemap(double lon,double lat);
}

