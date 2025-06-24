package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;
import models.Seller;

import java.io.File;

public class NewSellerServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String nextPage="signin.jsp";
		if(user!=null){
			String accountName=request.getParameter("accname");
			Seller seller=new Seller(user,accountName);
			seller.createSellerAccount();
			String uploadPath=getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName());
			File file=new File(uploadPath,accountName);
			file.mkdir();
			nextPage="seller_page.do";
		}
		response.sendRedirect(nextPage);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String nextPage="signin.jsp";
		if(user!=null){
			nextPage="new_seller.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}