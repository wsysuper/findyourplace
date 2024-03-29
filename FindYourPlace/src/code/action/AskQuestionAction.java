package code.action;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import code.model.Question;
import code.model.User;
import code.service.GooglemapService;
import code.service.QuestionService;

import com.opensymphony.xwork2.ActionSupport;

public class AskQuestionAction extends ActionSupport {
	/**
	 * @author panhanyang
	 */
	private static final long serialVersionUID = 1L;

	// 在主页或搜索条中获得相应信息作为提问标题，跳转到提问页面
	private String keyWords;
	private Double latitude; // for show & save
	private Double longitude; // for show & save
	private int zoomLevel; // for show & save
	private boolean addGoogleMap;
	private GooglemapService googlemapService;
	private String markArr; // for save 

	public String getMarkArr() {
		return markArr;
	}

	public void setMarkArr(String markArr) {
		this.markArr = markArr;
	}

	public GooglemapService getGooglemapService() {
		return googlemapService;
	}

	public void setGooglemapService(GooglemapService googlemapService) {
		this.googlemapService = googlemapService;
	}

	public boolean isAddGoogleMap() {
		return addGoogleMap;
	}

	public void setAddGoogleMap(boolean addGoogleMap) {
		this.addGoogleMap = addGoogleMap;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public int getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 用于提交问题
	private Question question;
	private User user;
	private QuestionService questionService;
	
	// 如果提交问题失败，显示失败原因
	private String result;

	// 上传图片用
	private File upload;
	private String fileName;
	// 上传文件的类型
	private String uploadContentType;
	// 上传图片的源文件名
	private String uploadFileName;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void validate() {
		//仅在提交问题时进行validate
		if (question != null) {
			if (question.getTitle() == null
					|| question.getTitle().trim().equals("")) {
				addFieldError("question.title", getText("qtitle.required"));
			}
			if (question.getContent() == null
					|| question.getContent().trim().equals("")) {
				addFieldError("question.content", getText("qcontent.required"));
			}
			if (question.getReward() < 0) addFieldError("question.reward",getText("qreward.error"));
			//验证上传的文件是否为图片
			if (getUploadFileName() != null) {
				if (!getUploadContentType().startsWith("image")) {
					addFieldError("upload", getText("qimage.error"));
				}
			}
		}
	}
	
	//得到关键字，进入提问页面
	public String askQuestion() {
		return SUCCESS;
	}
	
	//提交问题
	public String submitQuestion() {
		//如果要进行文件上传
		if (getUploadFileName() != null) {
			fileName = new Date().getTime() + getExtention(this.getUploadFileName());
			question.setPictureURL(fileName);
		}
	
		HttpSession session = ServletActionContext.getRequest().getSession();
		user = new User();
		//单点登录已将用户名放到session中
		//user.setUserName((String)session.getAttribute(CASFilter.CAS_FILTER_USER));
		//非单点登录得到用户名
		user.setUserName((String)session.getAttribute("user"));
		int id=0;
		if(this.addGoogleMap)
		 id=googlemapService.saveGooglemap(latitude, longitude, zoomLevel, markArr);
		else
		 id=googlemapService.saveGooglemap(null, null, 0, markArr);
		
		
		switch (questionService.addQuestion(question, user,id)) {
		case 0: {
			if (this.getUploadFileName() != null) return "upload";
			else return SUCCESS;
		}
		case 1: {
			result = getText("qnopoint.error");
			return INPUT;
		}
		default: {
			result = getText("qfail.error");
			return INPUT;
		}
		}
	}

	//得到上传文件的扩展名
    private static String getExtention(String fileName)  {
        int pos = fileName.lastIndexOf( "." );
        return fileName.substring(pos);
   }
}
