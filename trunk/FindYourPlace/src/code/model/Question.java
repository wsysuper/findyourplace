package code.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private int questionID;
	//标题
	private String title;
	//内容
	private String content;
	//提问者
	private User user;
	//是否解决
	private boolean solved;
	//发布日期
	private Date pubDate;
	//是否到期
	private boolean expired;
	//图片地址
	private String pictureURL;
	//问题类型
	private int type;
	//积分悬赏
	private int reward;
	//回答集
	private Set answerSet = new HashSet();
	//地图
	private Googlemap googleMap;
	
	//构造函数
	public Question() {
		title = null;
		content = null;
		user = null;
		solved = false;
		pubDate = null;
		expired = false;
		pictureURL = null;
		type = 0;
		reward = 0;
		googleMap = null;
	}
	
	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public boolean isSolved() {
		return solved;
	}
	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}

	public Set getAnswerSet() {
		return answerSet;
	}

	public void setAnswerSet(Set answerSet) {
		this.answerSet = answerSet;
	}

	public Googlemap getGoogleMap() {
		return googleMap;
	}

	public void setGoogleMap(Googlemap googleMap) {
		this.googleMap = googleMap;
	}
}
