package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Set;

public class Product{
	private Integer productId;
	private Seller seller;
	private Category category;
	private String productName;
	private Integer quantity;
	private Integer sold;
	private Integer price;
	private Integer discount;
	private String description;
	private String warranty;
	private String returningPolicy;
	private String shipmentDetails;
	private String paymentDetails;

	public Product(){
		super();
	}
	public Product(Integer productId){
		this.productId=productId;
	}
	public Product(Seller seller,Category category,String productName,Integer quantity,Integer price,Integer discount){
		this.seller=seller;
		this.category=category;
		this.productName=productName;
		this.quantity=quantity;
		this.price=price;
		this.discount=discount;
	}

	public Product(Integer productId,String productName,Integer quantity,Integer sold,Integer price,Integer discount){
		this.productId=productId;
		this.productName=productName;
		this.quantity=quantity;
		this.sold=sold;
		this.price=price;
		this.discount=discount;
	}

	public Product(Integer productId,String productName,Integer quantity,Integer sold,Integer price,Integer discount,Seller seller){
		this.productId=productId;
		this.productName=productName;
		this.quantity=quantity;
		this.sold=sold;
		this.price=price;
		this.discount=discount;
		this.seller=seller;
	}
	
	public Product(Integer productId,String productName,Integer price,Integer discount){
		this.productId=productId;
		this.productName=productName;
		this.price=price;
		this.discount=discount;
	}

//################### METHODS #########################

	public static ArrayList<Product> getProductDetailsForCart(Set<Integer> productIds){
		ArrayList<Product> products=new ArrayList<Product>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select product_id,product_name,price,discount from products where product_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			for(Integer productId:productIds){
				pst.setInt(1,productId);
				ResultSet rs=pst.executeQuery();
				if(rs.next()){
					products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
				}
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
		return products;
	}

	public static ArrayList<Product> searchProducts(String searchKey){
		ArrayList<Product> products=new ArrayList<Product>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select product_id,product_name,quantity,sold,price,discount,p.seller_id,seller_ac_name from products as p inner join sellers as s where p.seller_id=s.seller_id and  product_name like '%"+searchKey+"%'";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),new Seller(rs.getInt(7),rs.getString(8))));
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
		return products;
	}
	
	public void getProductInfo(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select product_name,quantity,sold,price,discount,description,warranty,returning_policy,shipment_details,payment_details,p.seller_id,seller_ac_name from products as p inner join sellers as s where product_id=? and p.seller_id=s.seller_id";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,productId);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				productName=rs.getString(1);
				quantity=rs.getInt(2);
				sold=rs.getInt(3);
				price=rs.getInt(4);
				discount=rs.getInt(5);
				description=rs.getString(6);
				warranty=rs.getString(7);
				returningPolicy=rs.getString(8);
				shipmentDetails=rs.getString(9);
				paymentDetails=rs.getString(10);
				seller=new Seller(rs.getInt(11),rs.getString(12));
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

	public static ArrayList<Product> collectAllProducts(Integer sellerId){
		ArrayList<Product> products=new ArrayList<Product>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select product_id,product_name,quantity,sold,price,discount from products where seller_id=? order by product_id desc";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,sellerId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
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
		return products;
	}
		
	public Boolean savePaymentDetails(){
		Boolean flag=false;
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="update products set payment_details=? where product_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,paymentDetails);
			pst.setInt(2,productId);
			int resp=pst.executeUpdate();
			if(resp==1){
				flag=true;
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
		return flag;
	}


	public Boolean saveShipmentDetails(){
		Boolean flag=false;
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="update products set shipment_details=? where product_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,shipmentDetails);
			pst.setInt(2,productId);
			int resp=pst.executeUpdate();
			if(resp==1){
				flag=true;
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
		return flag;
	}

	public Boolean saveReturningPolicy(){
		Boolean flag=false;
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="update products set returning_policy=? where product_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,returningPolicy);
			pst.setInt(2,productId);
			int resp=pst.executeUpdate();
			if(resp==1){
				flag=true;
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
		return flag;
	}
	public Boolean saveWarranty(){
		Boolean flag=false;
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="update products set warranty=? where product_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,warranty);
			pst.setInt(2,productId);
			int resp=pst.executeUpdate();
			if(resp==1){
				flag=true;
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
		return flag;
	}
	public Boolean saveDescription(){
		Boolean flag=false;
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="update products set description=? where product_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,description);
			pst.setInt(2,productId);
			int resp=pst.executeUpdate();
			if(resp==1){
				flag=true;
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
		return flag;
	}

	public Boolean saveProduct(){
		Boolean flag=false;
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="insert into products (seller_id,category_id,product_name,quantity,price,discount) value (?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,seller.getSellerId());
			pst.setInt(2,category.getCategoryId());
			pst.setString(3,productName);
			pst.setInt(4,quantity);
			pst.setInt(5,price);
			pst.setInt(6,discount);

			int res=pst.executeUpdate();

			if(res==1){
				flag=true;
				ResultSet rst=pst.getGeneratedKeys();
				if(rst.next()){
					productId=rst.getInt(1);
				
				}
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
		return flag;
	}

	public void setProductId(Integer productId){
		this.productId=productId;
	}
	public Integer getProductId(){
		return productId;
	}
	public void setSeller(Seller seller){
		this.seller=seller;
	}
	public Seller getSeller(){
		return seller;
	}
	public void setCategory(Category category){
		this.category=category;
	}
	public Category getCategory(){
		return category;
	}
	public void setProductName(String productName){
		this.productName=productName;
	}
	public String getProductName(){
		return productName;
	}
	public void setQuantity(Integer quantity){
		this.quantity=quantity;
	}
	public Integer getQuantity(){
		return quantity;
	}
	public void setSold(Integer sold){
		this.sold=sold;
	}
	public Integer getSold(){
		return sold;
	}
	public void setPrice(Integer price){
		this.price=price;
	}
	public Integer getPrice(){
		return price;
	}
	public void setDiscount(Integer discount){
		this.discount=discount;
	}
	public Integer getDiscount(){
		return discount;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return description;
	}
	public void setWarranty(String warranty){
		this.warranty=warranty;
	}
	public String getWarranty(){
		return warranty;
	}
	public void setReturningPolicy(String returningPolicy){
		this.returningPolicy=returningPolicy;
	}
	public String getReturningPolicy(){
		return returningPolicy;
	}
	public void setShipmentDetails(String shipmentDetails){
		this.shipmentDetails=shipmentDetails;
	}
	public String getShipmentDetails(){
		return shipmentDetails;
	}
	public void setPaymentDetails(String paymentDetails){
		this.paymentDetails=paymentDetails;
	}
	public String getPaymentDetails(){
		return paymentDetails;
	}
}