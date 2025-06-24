package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import java.util.ArrayList;
import models.ProductPic;

import com.google.gson.Gson;

public class ProductPicsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int productId=Integer.parseInt(request.getParameter("product_id"));
		ArrayList<ProductPic> productPics=ProductPic.getAllProductPics(productId);
		Gson gson=new Gson();
		String resp=gson.toJson(productPics);
		response.getWriter().write(resp);
	}
}