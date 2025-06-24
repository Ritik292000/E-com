package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import models.User;
import models.*;

public class ShowProfpicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		OutputStream os=response.getOutputStream();
		String profpath="static/images/profile.png";
		if(user!=null){
			String profpic=user.getProfpic();
	
			if(profpic!=null){
				profpath="/WEB-INF/uploads/"+profpic;
			}
		}	
		InputStream is=getServletContext().getResourceAsStream(profpath);
		byte[] arr=new byte[1024];
		int count=0;
		while((count=is.read(arr))!=-1){
			os.write(arr);
		}
		os.flush();
		os.close();
	}
}