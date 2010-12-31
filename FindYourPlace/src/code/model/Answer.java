package code.model;

import java.io.Serializable;
import java.sql.Date;

import java.io.Serializable;
import java.sql.Date;


public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;
	//唯一标识
	int answerID;
	//问题
	Question question;
	String content;
	//答题者
	User user;
	//发布日期
	Date pubDate;
	//图片地址
	String pictureURL;
	boolean isStandard;
	//int reward;

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
	/*public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}*/

}

