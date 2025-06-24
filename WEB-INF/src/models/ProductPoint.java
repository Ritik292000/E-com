package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class ProductPoint{
	private Integer productPointId;
	private Product product;
	private String	pointHeader;
	private String	pointValue;

	public ProductPoint(String pointHeader,String pointValue){
		this.pointHeader=pointHeader;
		this.pointValue=pointValue;
	}

	public static ArrayList<ProductPoint> getAllProductPoints(Integer productId){
		ArrayList<ProductPoint> productPoints=new ArrayList<ProductPoint>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select point_header,point_value from product_points where product_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,productId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				productPoints.add(new ProductPoint(rs.getString(1),rs.getString(2)));
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
		return productPoints;
	}

	public static Boolean saveProductPoints(Integer productId,String[] pointHeader,String[] pointValue){
		Boolean flag=false;
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="insert into product_points (product_id,point_header,point_value) values (?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,productId);
			
			for(int i=0;i<pointHeader.length;i++){
				pst.setString(2,pointHeader[i]);
				pst.setString(3,pointValue[i]);
				pst.executeUpdate();
			}
			flag=true;
		}catch(ClassNotFoundException | SQLException e){
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
		return flag;
	}

	public void setProductPointId(Integer productPointId){
		this.productPointId=productPointId;
	}
	public Integer getProductPointId(){
		return productPointId;
	}
	public void setProduct(Product product){
		this.product=product;
	}
	public Product getProduct(){
		return product;
	}
	public void setPointHeader(String pointHeader){
		this.pointHeader=pointHeader;
	}
	public String getPointHeader(){
		return pointHeader;
	}
	public void setPointValue(String pointValue){
		this.pointValue=pointValue;
	}
	public String getPointValue(){
		return pointValue;
	}
}