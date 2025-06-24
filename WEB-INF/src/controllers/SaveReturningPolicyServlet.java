package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;
import models.Product;

public class SaveReturningPolicyServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String resp="";

		if(user!=null){
			String returningPolicy=request.getParameter("returning_policy");
			Product product=(Product)session.getAttribute("product");
			product.setReturningPolicy(returningPolicy);
			if(product.saveReturningPolicy()){
				resp="{\"resp\":1}";
			}
			else{
				resp="{\"resp\":0}";
			}
		}
		else{
			resp="{\"resp\":-1}";
		}
		response.getWriter().write(resp);
	}
}