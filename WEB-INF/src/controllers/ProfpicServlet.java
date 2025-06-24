package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.File;

import models.User;

import java.util.List;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class ProfpicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String nextPage="signin.do";
		if(user!=null){
			nextPage="profpic.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory dfif=new DiskFileItemFactory();
				ServletFileUpload sfu=new ServletFileUpload(dfif);
				List<FileItem> fileItems=null;
				try{
					fileItems=sfu.parseRequest(request);
				}
				catch(FileUploadException e){
					e.printStackTrace();
				}
				FileItem fileItem=fileItems.get(0);
				String userName=user.getUserName();
				String uploadPath=getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName());
				String fileName=fileItem.getName();
				File file=new File(uploadPath,fileName);
				try{
					fileItem.write(file);
					user.setProfpic(userName+"/"+fileName);
					user.saveProfpic();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			response.sendRedirect("home.do");
		}
		else{
			response.sendRedirect("signin.do");
		}
	}
}