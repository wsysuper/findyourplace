package code.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import code.model.Question;
import code.model.User;
import code.service.QuestionService;

public class AskQuestionAction extends ActionSupport {
	/**
	 * @author panhanyang
	 */
	private static final long serialVersionUID = 1L;

	// 在主页或搜索条中获得相应信息作为提问标题，跳转到提问页面
	private String keyWords;

	// 用于提交问题
	private Question question;
	private User user;
	private QuestionService questionService;

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
		}
	}
	
	//得到关键字，进入提问页面
	public String askQuestion() {
		return SUCCESS;
	}
	
	//提交问题
	public String submitQuestion() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		user = (User) session.getAttribute("user");
		if (questionService.addQuestion(question, user))
			return SUCCESS;
		else
			return INPUT;
	}
}
