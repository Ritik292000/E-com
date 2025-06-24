package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;

public class Seller{
	private Integer sellerId;
	private User user;
	private String sellerAccountName;
	private Timestamp startDate;


	public Seller(){
		super();
	}
	public Seller(Integer sellerId,String sellerAccountName){
		this.sellerId=sellerId;
		this.sellerAccountName=sellerAccountName;
	}
	public Seller(User user,String sellerAccountName){
		this.user=user;
		this.sellerAccountName=sellerAccountName;
	}
	public Seller(Integer sellerId,String sellerAccountName,Timestamp startDate){
		this.sellerId=sellerId;
		this.sellerAccountName=sellerAccountName;
		this.startDate=startDate;
	}
/*###################### Method #################################*/
	public void createSellerAccount(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="insert into sellers (user_id,seller_ac_name,start_date) values (?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,user.getUserId());
			pst.setString(2,sellerAccountName);
			pst.setTimestamp(3,new Timestamp(new Date().getTime()));
			pst.executeUpdate();
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
	public static ArrayList<Seller> collectSellerAccount(Integer userId){
		ArrayList<Seller> sellers=new ArrayList<Seller>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select * from sellers where user_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,userId);
			ResultSet rst=pst.executeQuery();
			while(rst.next()){
				sellers.add(new Seller(rst.getInt(1),rst.getString(3),rst.getTimestamp(4)));
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

		return sellers;
	}

	public void setSellerId(Integer sellerId){
		this.sellerId=sellerId;
	}
	public Integer getSellerId(){
		return sellerId;
	}
	public void setUser(User user){
		this.user=user;
	}
	public User getUser(){
		return user;
	}
	public void setSellerAccountName(String sellerAccountName){
		this.sellerAccountName=sellerAccountName;
	}
	public String getSellerAccountName(){
		return sellerAccountName;
	}
	public void setStartDate(Timestamp startDate){
		this.startDate=startDate;
	}
	public Timestamp getStartDate(){
		return startDate;
	}
}