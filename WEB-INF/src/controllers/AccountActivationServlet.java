package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;

public class AccountActivationServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String userName=request.getParameter("ukey");
		String activationCode=request.getParameter("actcode");

		if(User.activateAccount(userName,activationCode)){
			request.setAttribute("success","Account Activated");
		}
		else{
			request.setAttribute("fail","Account Activation failed");
		}
		request.getRequestDispatcher("result.jsp").forward(request,response);
	
	}
}