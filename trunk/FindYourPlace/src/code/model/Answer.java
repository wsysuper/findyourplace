package code.model;

import java.io.Serializable;
import java.sql.Date;

import java.io.Serializable;
import java.sql.Date;


public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;
	//唯一标识
	private int answerID;
	//问题
	private Question question;
	private String content;
	//答题者
	private User user;
	//发布日期
	private Date pubDate;
	//图片地址
	private String pictureURL;
	private boolean isStandard;
	//地图
	private int mapId;

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	//构造函数
	public Answer() {
		content = null;
		user = null;
		isStandard = false;
		pubDate = null;
		pictureURL = null;
		//reward = 0;
		question=null;
	}

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public Question getQuestion() {
		return this.question;
	}
	
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean getIsStandard() {
		return this.isStandard;
	}
	public void setIsStandard(boolean standard) {
		this.isStandard = standard;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public void setStandard(boolean isStandard) {
		this.isStandard = isStandard;
	}

	

	

}

