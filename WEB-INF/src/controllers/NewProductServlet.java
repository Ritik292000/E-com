package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.File;

import models.User;
import models.Product;
import models.Category;
import models.Seller;

import com.google.gson.Gson;

public class NewProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session =request.getSession();
		User user=(User)session.getAttribute("user");
		String nextPage="signin.jsp";
		if(user!=null){
			nextPage="add_product.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		String nextPage="signin.jsp";
		if(user!=null){
			String productName=request.getParameter("product_name");
			if(productName!=null){
			
				try{
					int categoryId=Integer.parseInt(request.getParameter("categor_id"));
					int quantity= Integer.parseInt(request.getParameter("quantity"));
					int price=Integer.parseInt(request.getParameter("price"));
					int discount=Integer.parseInt(request.getParameter("discount"));
					
					Seller seller=(Seller)session.getAttribute("seller");
					Product product=new Product(seller,new Category(categoryId),productName,quantity,price,discount);
					if(product.saveProduct()){
						String uploadProductPath=getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName()+"/"+seller.getSellerAccountName());
						File file=new File(uploadProductPath,Integer.toString(product.getProductId()));
						file.mkdir();
						session.setAttribute("product",product);
						Gson gson=new Gson();
						String resp=gson.toJson(product);
						response.getWriter().write(resp);
				
					}
					else{
						response.getWriter().write("{}");
					}
				}
				catch(NumberFormatException e){
					response.getWriter().write("[]");
				}
			}
		}
		else{
			response.getWriter().write("{\"resp\":0}");
		}
	}
}