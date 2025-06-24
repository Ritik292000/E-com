package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import utils.Util;

public class ShowProductPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String picPath="/WEB-INF/uploads/"+request.getParameter("product_pic");
		Util.streamPic(getServletContext(),response.getOutputStream(),picPath);
	}
}