package code.action;

import code.model.Googlemap;
import code.model.Question;
import code.service.QuestionService;

import com.opensymphony.xwork2.ActionSupport;

public class ShowQuestionAction extends ActionSupport {
	/**
	 * @author panhanyang
	 */
	private static final long serialVersionUID = 8935399949970729556L;

	private int questionID;
	//用于页面显示问题
	private Question question;
	private QuestionService questionService;
	//用于页面显示问题答案
	//private List answerList;
	
	private int mapId;

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
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

	public String execute() {
		question = questionService.getQuestion(questionID);
		System.out.println(question);
		if (question == null) return INPUT;
		else {
			//把Set转换成List
			//answerList = new ArrayList(question.getAnswerSet());
			if (question.getGoogleMap() == null) mapId = 0;
			else mapId = question.getGoogleMap().getMapId();
			return SUCCESS;
		}
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
}
