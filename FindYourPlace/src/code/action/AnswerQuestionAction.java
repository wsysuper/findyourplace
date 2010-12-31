package code.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import code.model.Question;
import code.model.User;
import code.service.AnswerService;
import code.service.SearchService;
import code.service.impl.AnswerServiceImpl;
import code.service.impl.SearchServiceImpl;
import code.model.Answer;

public class AnswerQuestionAction extends ActionSupport {
	/**
	 * @author chenyan
	 */
	private static final long serialVersionUID = 1L;

	// 在主页或搜索条中获得相应信息作为提问标题，跳转到回答页面
	private String keyWords;

	// 用于提交问题
	private Question question=new Question();
	private User user;
	private Answer answer;
    private AnswerService answerService;
	//upload image 
	 private static final int BUFFER_SIZE = 16 * 1024 ;


	//private String caption;
	private File upload;
	private String uploadContentType;
	private String fileName;
	private String savePath;
	private String uploadFileName;
	private int questionID;
	private List<Answer> resultAnswerList;
	private String questionFileName;
	/*public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}*/

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

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

	

	public void validate() {
		//仅在提交问题时进行validate
		if (answer != null) {
			if (answer.getContent() == null
					|| answer.getContent().trim().equals("")) {
				addFieldError("answer.title", getText("acontent.required"));
			}
		}
	}
	private static void copy(File src, File dst)  {
        try  {
           InputStream in = null ;
           OutputStream out = null ;
            try  {
               in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
               out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                byte [] buffer = new byte [BUFFER_SIZE];
                while (in.read(buffer) > 0 )  {
                   out.write(buffer);
               }
            } finally  {
                if ( null != in)  {
                   in.close();
               }
                 if ( null != out)  {
                   out.close();
               }
           }
        } catch (Exception e)  {
           e.printStackTrace();
       }
   }

    private static String getExtention(String fileName)  {
    	System.out.println(fileName);
        int pos = fileName.lastIndexOf( "." );
        return fileName.substring(pos);
   }
	
	//得到关键字，进入提问页面
	public String answerQuestion() {
		return SUCCESS;
	}
	
	//提交问题
	public String submitAnswer() {
		if(this.getUploadFileName()!=null){
		fileName = new Date().getTime() + getExtention(this.getUploadFileName());
		File imageFile = new File(ServletActionContext.getServletContext().getRealPath( "/UploadImages" ) + "\\" + fileName);
		 copy(upload, imageFile);
		 answer.setPictureURL(fileName);
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		user=new User();
		user.setUserName((String) session.getAttribute("user"));
		
		
		System.out.println(question.getPictureURL());
		if (answerService.addAnswer(question, user,answer)){
			
			
			//System.out.println("AnswerListID:");
			//System.out.println(resultAnswerList.size());
			return SUCCESS;
		}
		else{
		   
			return INPUT;
		}
			
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Answer> getResultAnswerList() {
		return resultAnswerList;
	}

	public void setResultAnswerList(List<Answer> resultAnswerList) {
		this.resultAnswerList = resultAnswerList;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public AnswerService getAnswerService() {
		return answerService;
	}

	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}

	public String getQuestionFileName() {
		return questionFileName;
	}

	public void setQuestionFileName(String questionFileName) {
		this.questionFileName = questionFileName;
	}

}


