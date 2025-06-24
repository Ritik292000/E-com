package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.File;

import models.User;
import models.Seller;
import models.Product;
import models.ProductPic;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;

public class SaveProductPicsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		Seller seller=(Seller)session.getAttribute("seller");
		Product product=(Product)session.getAttribute("product");
		String nextPage="signin.jsp";
		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory dfif=new DiskFileItemFactory();
				ServletFileUpload sfu=new ServletFileUpload(dfif);
				List<FileItem> fileItems=null;
				try{
					fileItems= sfu.parseRequest(request);
					String uploadPicPath=getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName()+"/"+seller.getSellerAccountName()+"/"+product.getProductId());
					String dbPicPath=user.getUserName()+"/"+seller.getSellerAccountName()+"/"+product.getProductId()+"/";
					ArrayList<String> dbPicPaths=new ArrayList<String>();
					for(FileItem fileItem : fileItems){
						String fileName=fileItem.getName();
						dbPicPaths.add(dbPicPath+fileName);
						try{
							File file=new File(uploadPicPath,fileName);
							fileItem.write(file);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					ProductPic.saveProductPic(product.getProductId(),dbPicPaths);
					nextPage="seller_dashboard.jsp";
				}catch(FileUploadException e){
					e.printStackTrace();
				}
			}
		}
		//request.getRequestDispatcher(nextPage).forward(request,response);
		response.sendRedirect(nextPage);
	}
}