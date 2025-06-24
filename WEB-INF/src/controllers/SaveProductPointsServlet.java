package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;
import models.Product;
import models.ProductPoint;

public class SaveProductPointsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String resp="";

		if(user!=null){
			String[] productTitles=request.getParameterValues("p_ttl");
			String[] productValues=request.getParameterValues("p_val");
			Product product=(Product)session.getAttribute("product");
			if(ProductPoint.saveProductPoints(product.getProductId(),productTitles,productValues)){
				resp+="{\"resp\":1}";
			}
			else{
				resp+="{\"resp\":0}";
			}
		}
		else{
			resp+="{\"resp\":-1}";
		}
		response.getWriter().write(resp);
	}
}