package controllers;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;

import utils.TextLocal;
import utils.OTPGenerator;

public class SendOTPServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null){
			String mobile=request.getParameter("mobile");
			String otp=OTPGenerator.generateOTP();
			String message="Your one time password is "+otp+" Please donot share it with anyone";
		//	TextLocal.sendSms(message,mobile);
			session.setAttribute("otp",otp);
		}
		else{
			response.getWriter().write("expired");
		}
	}
}