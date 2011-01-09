package code.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadImageAction extends ActionSupport {

	/**
	 * @author panhanyang
	 * 可复用的上传文件action
	 */
	private static final long serialVersionUID = -7124276008016467865L;
	
	// 上传文件
	private File upload;
	// 另存为文件名
	private String fileName;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String execute() {
		// 文件保存的路径从配置文件中读取
		File imageFile = new File(ServletActionContext.getServletContext().
				getRealPath(getText("uploadpath")), fileName);
		try {
			FileUtils.copyFile(upload, imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}
}
