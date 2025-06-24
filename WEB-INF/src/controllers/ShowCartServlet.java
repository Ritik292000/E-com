package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import java.util.Map;
import java.util.ArrayList;
import java.util.Set;

import models.Product;

public class ShowCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		Map<Integer,Integer> cart =(Map<Integer,Integer>)session.getAttribute("cart");
		if(cart!=null){
			Set<Integer> productIds=cart.keySet();
			ArrayList<Product> products=Product.getProductDetailsForCart(productIds);
			session.setAttribute("products",products);
		}
		request.getRequestDispatcher("cart.jsp").forward(request,response);
	}
}