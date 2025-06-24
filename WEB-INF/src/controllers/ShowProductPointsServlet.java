package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import models.ProductPoint;

import java.util.ArrayList;

import com.google.gson.Gson;

public class ShowProductPointsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int productId=Integer.parseInt(request.getParameter("product_id"));
		ArrayList<ProductPoint> productPoints=ProductPoint.getAllProductPoints(productId);
		Gson gson=new Gson();
		String resp=gson.toJson(productPoints);
		response.getWriter().write(resp);
	}
}