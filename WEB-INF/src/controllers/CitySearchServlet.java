package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import java.util.ArrayList;

import models.User;
import models.City;

import com.google.gson.Gson;

public class CitySearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null){
			String skey=request.getParameter("skey");
			ArrayList<City> cityList=City.searchCity(skey);
			Gson gson=new Gson();
			String responseText=gson.toJson(cityList);
			response.getWriter().write(responseText);
		}
		else{
			response.getWriter().write("Session Expired");
		}
	}
}