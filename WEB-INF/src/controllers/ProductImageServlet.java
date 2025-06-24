package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import models.ProductPic;

public class ProductImageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int productId=Integer.parseInt(request.getParameter("product_id"));
		String picPath=ProductPic.getSingleProductPic(productId);
		InputStream is=getServletContext().getResourceAsStream("/WEB-INF/uploads/"+picPath);
		OutputStream os=response.getOutputStream();
		byte[] ar=new byte[1024];
		int count=0;
		while((count=is.read(ar))!=-1){
			os.write(ar);
		}
		os.flush();
		os.close();
	}
}