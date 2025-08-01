package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;
import models.Product;

public class SavePaymentDetailsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String resp="";

		if(user!=null){
			String paymentDetails=request.getParameter("payment_details");
			Product product=(Product)session.getAttribute("product");
			product.setPaymentDetails(paymentDetails);
			if(product.savePaymentDetails()){
				resp="{\"resp\":1}";
			}
			else{
				resp="{\"resp\":0}";
			}
		}
		else{
			resp="{\"resp\":-1}";
		}
		response.getWriter().write(resp);
	}
}