package code.action;



import java.util.List;

import code.model.Question;
import code.service.SearchAnswerService;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAnswerAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List resultAnswerList;
	private int questionId;
	private int totalPage;
	private int page;
	private SearchAnswerService searchAnswerService;
	private Question curQuestion;
	public List getResultAnswerList() {
		return resultAnswerList;
	}
	public void setResultAnswerList(List resultAnswerList) {
		this.resultAnswerList = resultAnswerList;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public SearchAnswerService getSearchAnswerService() {
		return searchAnswerService;
	}
	public void setSearchAnswerService(SearchAnswerService searchAnswerService) {
		this.searchAnswerService = searchAnswerService;
	}
	public String execute(){
		curQuestion = searchAnswerService.getCurrentQuestion(questionId);
		resultAnswerList = searchAnswerService.getResultAnswerList(questionId);
		if(curQuestion == null)
			return INPUT;
		else
		return SUCCESS;
		
	}
	
}
