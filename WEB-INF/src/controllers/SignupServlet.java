package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.File;
import models.User;
import utils.GoogleCaptcha;
import utils.EmailSender;
import utils.ActivationCode;
import utils.EmailMessage;


public class SignupServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		Boolean flag=true;
		String err="";		
		String nextPage="signup.jsp";
		String userName=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String rePassword=request.getParameter("repassword");
		String recaptcha=request.getParameter("g-recaptcha-response");

		flag=GoogleCaptcha.checkReCaptcha(recaptcha);

		if(flag){	
			//################# validation #########################
			
			
			Pattern p=null;
			Matcher m=null;

			
			
			p=Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{4,29}$");
			m=p.matcher(userName);
			if(!m.matches()){
				flag=false;
				err+="<p>Only alphabat and numeric character are allowed</p>";
			}

			p=Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
			m=p.matcher(email);
			if(!m.matches()){
				flag=false;
				err+="<p>Invalid Email</p>";
			}

			int passwordLength=password.length();
			if(passwordLength<6||passwordLength>12){
				flag=false;
				err+="<p>Atleast 6 and atmost 12 character length of password is required</p>";
			}

			if(!password.equals(rePassword)){
				flag=false;
				err+="<p>Password and Repassword must match</p>";
			}

			if(flag){
				String activeCode=ActivationCode.generateActivationCode();
				User user=new User(userName,email,password,activeCode);
				if(user.saveUser()){
						
						String message=EmailMessage.generateActivationMail(userName,activeCode);
						String subject="ecom account Activate Mail";
						EmailSender.sendEmail(email,subject,message);

						String uploadPath=getServletContext().getRealPath("/WEB-INF/uploads");
						File file=new File(uploadPath,userName);
						file.mkdir();

						response.sendRedirect("signin.jsp");
				}
				else{
					flag=false;
					err+="<p>Either duplicate username or duplicate email</p>";
				}
			}
		}
		else{
				err+="Captcha Test Failed";
		}
		if(!flag){
			request.setAttribute("error",err);
			request.getRequestDispatcher(nextPage).forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("signup.jsp").forward(request,response);
	}
}