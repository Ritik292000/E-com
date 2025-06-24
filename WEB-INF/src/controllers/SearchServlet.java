package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import java.util.ArrayList;

import models.Product;

import com.google.gson.Gson;

public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String search = request.getParameter("search");
		ArrayList<Product> products=Product.searchProducts(search);
		Gson gson = new Gson();
		String resp=gson.toJson(products);
		response.getWriter().write(resp);
	}
}