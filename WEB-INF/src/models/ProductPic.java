package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class ProductPic{
	private Integer productPicId;
	private Product product;
	private String productPic;

	public ProductPic(){
		super();
	}
	public ProductPic(Integer productPicId,String productPic){
		this.productPicId=productPicId;
		this.productPic=productPic;
	}
	
	public static ArrayList<ProductPic> getAllProductPics(Integer productId){
		ArrayList<ProductPic> productPics=new ArrayList<ProductPic>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select product_pic_id,product_pic from product_pics where product_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,productId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				productPics.add(new ProductPic(rs.getInt(1),rs.getString(2)));
			}
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return productPics;
	}

	public static String getSingleProductPic(Integer productId){
		String picPath=null;
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select product_pic from product_pics where product_id=? limit 1";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,productId);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				picPath=rs.getString(1);
			}
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return picPath;
	}
	public static void saveProductPic(Integer productId,ArrayList<String> productPics){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="insert into product_pics (product_id,product_pic) values (?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,productId);
			for(String productPic:productPics){
				pst.setString(2,productPic);
				pst.executeUpdate();
			}
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	public void setProductPicId(Integer productPicId){
		this.productPicId=productPicId;
	}
	public Integer getProductPicId(){
		return productPicId;
	}
	public void setProduct(Product product){
		this.product=product;
	}
	public Product getProduct(){
		return product;
	}
	public void setProductPic(String productPic){
		this.productPic=productPic;
	}
	public String getProductPic(){
		return productPic;
	}
}