package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

import utils.EmailSender;
import utils.EmailSender.EmailPasswordAuthentication;

import models.Category;

import java.util.ArrayList;

public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent ev){
		ServletContext context=ev.getServletContext();
		EmailSender.EmailPasswordAuthentication.senderEmail=context.getInitParameter("sender_email");
		EmailSender.EmailPasswordAuthentication.senderEmailPassword=context.getInitParameter("sender_email_password");
		
		ArrayList<Category> categories=Category.collectCategories();
		context.setAttribute("categories",categories);

		ArrayList<Integer> x=new ArrayList<Integer>();
		for(int i=1;i<=10;i++){
			x.add(i);
		}
		context.setAttribute("itemCount",x);
	}
	public void contextDestroyed(ServletContextEvent e){
	
	}
}