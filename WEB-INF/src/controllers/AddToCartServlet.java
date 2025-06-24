package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

import utils.ProductCount;

import com.google.gson.Gson;

public class AddToCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();

		int productId=Integer.parseInt(request.getParameter("product_id"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));

		Map<Integer,Integer> cart=(Map<Integer,Integer>)session.getAttribute("cart");
		if(cart==null){
			cart=new LinkedHashMap<Integer,Integer>();
			session.setAttribute("cart",cart);
		}
		cart.put(productId,quantity);
	//	int cartItemCount=cart.keySet().size();
		Set<Integer> set=cart.keySet();
		int cartItemCount=0;
		for(Integer key:set){
			cartItemCount +=cart.get(key);
		}
		session.setAttribute("cartItemCount",cartItemCount);
		ProductCount pc=new ProductCount(cartItemCount);
		Gson gson=new Gson();
		String resp=gson.toJson(pc);
		response.getWriter().write(resp);
	}
}