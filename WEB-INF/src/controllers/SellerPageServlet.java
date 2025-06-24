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

import java.util.ArrayList;

public class SellerPageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		String nextPage="signin.jsp";
		User user=(User)session.getAttribute("user");
		if(user!=null){
			ArrayList<Seller> sellers=Seller.collectSellerAccount(user.getUserId());
			request.setAttribute("sellers",sellers);
			nextPage="seller_page.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}