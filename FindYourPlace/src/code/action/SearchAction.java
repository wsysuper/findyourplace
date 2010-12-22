package code.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import code.model.*;
import code.service.*;

public class SearchAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private List<Question> resultQuestionList;
	private List<Answer> resultAnswerList;
	private SearchService searchService;
	private static String content;
	private int searchType;
	private int resultQuestionNum;
	private int totalPage;
	private int page;
	private Question curQuestion;
	public int getTotalPage() {
		return totalPage;
	}
	public Question getCurQuestion() {
		return curQuestion;
	}
	public void setCurQuestion(Question curQuestion) {
		this.curQuestion = curQuestion;
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
	public List<Question> getResultQuestionList() {
		return resultQuestionList;
	}

	public void setResultQuestionList(List<Question> resultQuestionList) {
		this.resultQuestionList = resultQuestionList;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public int getSearchType() {
		return searchType;
	}

	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}

	public int getResultQuestionNum() {
		return resultQuestionNum;
	}

	public void setResultQuestionNum(int resultQuestionNum) {
		this.resultQuestionNum = resultQuestionNum;
	}
	public SearchService getSearchService() {
		return searchService;
	}
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String search(){
		return SUCCESS;
	}
	public String turnPage(){
		System.out.println("in turnPage");
		resultQuestionList = searchService.getResultQuestionList(content);
		if(page == -1)
			page = 0;
		if(resultQuestionList.size() == 0)
			System.out.println("the result q list is empty!");
		totalPage = this.resultQuestionList.size();
		curQuestion = this.getResultQuestionList().get(page);
		resultAnswerList = searchService.getResultAnswerList(curQuestion.getQuestionID());
		return SUCCESS;
		
		
	}
	public String submitSearch(){
		System.out.println("in execute");
		//HttpSession session = ServletActionContext.getRequest().getSession();
		searchService.setSearchType(searchType);
		System.out.println("SearchAction "+content);
		resultQuestionList = searchService.getResultQuestionList(content);
		curQuestion = resultQuestionList.get(0);
		resultAnswerList = searchService.getResultAnswerList(curQuestion.getQuestionID());
		resultQuestionNum = resultQuestionList.size();
		totalPage = resultQuestionNum;
		if(resultQuestionNum == 0)
			return INPUT;
		else
			return SUCCESS;
	}
	

}
