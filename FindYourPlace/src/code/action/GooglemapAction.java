package code.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import code.dao.GooglemapDao;
import code.dao.hibernate.GooglemapDaoHibernate;
import code.model.Googlemap;
import code.service.GooglemapService;

import com.opensymphony.xwork2.ActionSupport;

public class GooglemapAction extends ActionSupport {
	/**
	 * @author WSY
	 */
	private static final long serialVersionUID = 1L;

	private int mapID;
	private Googlemap gmap;

	private GooglemapService googlemapService;
	
	public int getMapID() {
		return mapID;
	}

	public void setMapID(int mapID) {
		this.mapID = mapID;
	}

	public Googlemap getGmap() {
		return gmap;
	}

	public void setGmap(Googlemap gmap) {
		this.gmap = gmap;
	}

	public GooglemapService getGooglemapService() {
		return googlemapService;
	}

	public void setGooglemapService(GooglemapService googlemapService) {
		this.googlemapService = googlemapService;
	}

	public String execute() {
		if(getMapID() != 0)
		{

			gmap = googlemapService.getGooglemap(getMapID());

			System.out.println(gmap.getLatitude());
			System.out.println(gmap.getLongitude());
			System.out.println(gmap.getZoomLevel());
	/*		 = new Googlemap();
			gmap.setLatitude(31.02128538276489);
			gmap.setLongitude(121.43219321966171);
			gmap.setZoomLevel(12);

			Double pointlat = 31.02128538276489;
			Double pointlon = 121.43219321966171;
*/
			HttpSession session = ServletActionContext.getRequest().getSession();
			
			session.setAttribute("lat", gmap.getLatitude());
			session.setAttribute("lon", gmap.getLongitude());
			session.setAttribute("zoom", gmap.getZoomLevel());
//			session.setAttribute("pointlat", pointlat);
//			session.setAttribute("pointlon", pointlon);

			return SUCCESS;
		}
		else
			return INPUT;

	}
}
