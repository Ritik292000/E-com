package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;
import models.Address;
import models.City;

import java.util.ArrayList;

public class ShowAddressesServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		 User user=(User)session.getAttribute("user");
		 String nextPage="signin.do";
		 if(user!=null){
			ArrayList<Address> addresses=Address.getAllAddresses(user.getUserId());
			request.setAttribute("addresses",addresses);
			nextPage="all_addresses.jsp";
		 }
		 request.getRequestDispatcher(nextPage).forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null){
			String name=request.getParameter("name");
			int cityId=Integer.parseInt(request.getParameter("city_id"));
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			int pin=Integer.parseInt(request.getParameter("pin"));

			Address addr=new Address(user,name,address,new City(cityId,city),pin);
			addr.saveAddress();
		}
		response.getWriter().write("{\"done\":1}");
	}
}