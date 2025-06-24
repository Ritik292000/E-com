package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;
import models.City;
import models.Address;

public class AddressServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String nextPage="signin.jsp";
		if(user!=null){
			Address address=new Address(user);
			address.fetchAddress();
			session.setAttribute("address",address);
			nextPage="address.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null){
			String addr=request.getParameter("address");
			int cityId=Integer.parseInt(request.getParameter("city_id"));
			String cityName=request.getParameter("city");
			City city=new City(cityId,cityName);
			int pin=Integer.parseInt(request.getParameter("pin"));
			Address address=new Address(user,addr,city,pin);
			if(address.saveAddress()){
				response.sendRedirect("profpic.do");
			}
			else{
				request.getRequestDispatcher("address.jsp").forward(request,response);
			}
		}
		else{
			request.getRequestDispatcher("signin.do").forward(request,response);
		}
	}
}