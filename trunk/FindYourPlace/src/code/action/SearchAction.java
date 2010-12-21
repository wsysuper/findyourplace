package code.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import code.model.*;
import code.service.*;

public class SearchAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private List<Question> resultQuestionList;
	private String content;
	private int searchType;
	private int resultQuestionNum;
	private List<List<Answer>> resultAnswerList; //the answer list correspond to the question list
	private SearchService searchService;
	
	
	
	
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




	public List<List<Answer>> getResultAnswerList() {
		return resultAnswerList;
	}




	public void setResultAnswerList(List<List<Answer>> resultAnswerList) {
		this.resultAnswerList = resultAnswerList;
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

	public String submitSearch(){
		System.out.println("in execute");
		//HttpSession session = ServletActionContext.getRequest().getSession();
		searchService.setSearchType(searchType);
		System.out.println("SearchAction "+content);
		resultQuestionList = searchService.getResultQuestionList(content);
		
		resultQuestionNum = resultQuestionList.size();
		if(resultQuestionNum == 0)
			return INPUT;
		else
			return SUCCESS;
	}
	

}
