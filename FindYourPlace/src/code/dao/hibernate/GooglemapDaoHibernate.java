package code.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.dao.GooglemapDao;
import code.model.Googlemap;
import code.model.Question;

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
	public Googlemap getGooglemap(int mapID) {
		// TODO Auto-generated method stub
		List result = this.getHibernateTemplate().
			find("from Googlemap where mapID = " + mapID);
		if (result.size() == 0) 
		{
			System.out.println("why?");
			return null;
		}
		else
		{
			System.out.println("OOOK");
			return (Googlemap)result.get(0);
		}
	}
	public List getAreaGooglemap(double lon,double lat)
	{
		double range = 300;
		double latlow = lat-range;
		double lathigh = lat+range;
		double lonlow = lon-range;
		double lonhigh = lon+range;
		System.out.println("in googlemapdao getAreaGooglemap");
		if(this.getHibernateTemplate() == null)
			System.out.println("this hibernateTemplate is null");
		else
			System.out.println("this hibernateTemplate isnot null");
		
		List result = this.getHibernateTemplate().find(
				"from Googlemap m where m.latitude <= "+lathigh+
				" and m.latitude >= "+latlow+
				" and m.longitude <=" + lonhigh+
				" and m.longitude >= "+lonlow);
		if(result.size() == 0)
			System.out.println("mapDao result is empty");
		else
			System.out.println("mapDao result is not empty");
		return result;
	}
	
}
