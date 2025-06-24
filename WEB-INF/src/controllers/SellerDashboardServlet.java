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

public class SellerDashboardServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String nextPage="signin.jsp";
		if(user!=null){
			int sellerId=Integer.parseInt(request.getParameter("sellerId"));
			String sellerName=request.getParameter("sellerName");
			Seller seller=new Seller(sellerId,sellerName);
			session.setAttribute("seller",seller);
			nextPage="seller_dashboard.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}