package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import utils.GoogleCaptcha;
import models.User;

public class SigninServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("signin.jsp").forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();

		String nextPage="signin.jsp";
		String recaptcha=request.getParameter("g-recaptcha-response");
		Boolean flag=GoogleCaptcha.checkReCaptcha(recaptcha);

		if(flag){
			String unameEmail=request.getParameter("unameEmail");
			String password=request.getParameter("password");
			User user =new User();
			String message=user.loginUser(unameEmail,password);
			if(message.equals("success")){
				session.setAttribute("user",user);
				response.sendRedirect("profile.do");
			}
			else{
				request.setAttribute("error",message);
				request.getRequestDispatcher(nextPage).forward(request,response);
			}
		}
		else{
			request.setAttribute("error","Captcha Test Failed...");
			request.getRequestDispatcher(nextPage).forward(request,response);
		}
	}
}
