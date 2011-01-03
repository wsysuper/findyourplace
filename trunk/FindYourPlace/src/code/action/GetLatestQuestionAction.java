package code.action;

import java.util.List;

import code.model.Question;
import code.service.QuestionService;

import com.opensymphony.xwork2.ActionSupport;

public class GetLatestQuestionAction extends ActionSupport {
	/**
	 * @author panhanyang
	 */
	private static final long serialVersionUID = -5800657496386576188L;
	
	private List<Question> latestQuestion;
	private QuestionService questionService;
	
	public List<Question> getLatestQuestion() {
		return latestQuestion;
	}
	public void setLatestQuestion(List<Question> latestQuestion) {
		this.latestQuestion = latestQuestion;
	}
	public QuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	public String execute() {
		latestQuestion = questionService.getLatestQuestion();
		System.out.println("latest!!");
		System.out.println(latestQuestion.size());
		return SUCCESS;
	}
}
