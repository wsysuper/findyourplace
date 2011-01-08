package code.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadImageAction extends ActionSupport {

	/**
	 * @author panhanyang
	 * 可复用的上传图片action
	 */
	private static final long serialVersionUID = -7124276008016467865L;
	
	// 上传图片
	private static final int BUFFER_SIZE = 16 * 1024 ;

	private File upload;
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
		File imageFile = new File(ServletActionContext.getServletContext().getRealPath( "/UploadImages" ) + "\\" + fileName);
		copy(upload, imageFile);
		return SUCCESS;
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
}
