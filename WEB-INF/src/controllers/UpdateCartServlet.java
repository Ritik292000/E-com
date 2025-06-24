package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import java.util.Map;

public class UpdateCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();

		int productId=Integer.parseInt(request.getParameter("product_id"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));

		Map<Integer,Integer> cart=(Map<Integer,Integer>)session.getAttribute("cart");
		cart.put(productId,quantity);
		response.getWriter().write("{\"done\":\"true\"}");
	}
}