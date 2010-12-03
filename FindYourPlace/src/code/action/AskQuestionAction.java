package code.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import code.model.Question;
import code.model.User;
import code.service.QuestionService;

public class AskQuestionAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Question question;
	private User user;
	private QuestionService questionService;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	//public User getUser() {
		//return user;
	//}

	//public void setUser(User user) {
		//this.user = user;
	//}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public void validate() {
		if (question.getTitle() == null
				|| question.getTitle().trim().equals("")) {
			addFieldError("question.title", getText("qtitle.required"));
		}
		if (question.getContent() == null
				|| question.getContent().trim().equals("")) {
			addFieldError("question.content", getText("qcontent.required"));
		}
	}

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		user = (User)session.getAttribute("user");
		if (questionService.addQuestion(question, user)) return SUCCESS;
		else return INPUT;
	}
}
