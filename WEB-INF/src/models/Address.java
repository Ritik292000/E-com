package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import models.User;
import models.City;

import java.util.ArrayList;

public class Address{
	private Integer addressId;
	private User user;
	private String name;
	private String address;
	private City city;
	private Integer pin;
	private Boolean defaultAddress;

	public static final Boolean DEFAULT_ADDRESS=true;
	public static final Boolean NON_DEFAULT_ADDRESS=false;

	public Address(User user,String address,City city,Integer pin){
		this.user=user;
		this.address=address;
		this.city=city;
		this.pin=pin;
	}
	public Address(User user){
		this.user=user;
	}
	public Address(Integer addressId,String name,String address,Integer pin,City city){
		this.addressId=addressId;
		this.name=name;
		this.address=address;
		this.pin=pin;
		this.city=city;
	}
	public Address(User user,String name,String address,City city,Integer pin){
		this.user=user;
		this.name=name;
		this.address=address;
		this.city=city;
		this.pin=pin;
	}


//###################### Method  #######################
	
	public static ArrayList<Address> getAllAddresses(Integer userId){
		ArrayList<Address> addresses=new ArrayList<Address>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select address_id,name,address,pin,c.city_id,city from addresses as a inner join cities as c where a.city_id=c.city_id and user_id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,userId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				addresses.add(new Address(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),new City(rs.getInt(5),rs.getString(6))));
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
		return addresses;
	}

	public void fetchAddress(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select * from addresses as a inner join cities as c where a.city_id=c.city_id and user_id=? and default_address=1";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,user.getUserId());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				addressId=rs.getInt(1);
				name=rs.getString(3);
				address=rs.getString(4);
				pin=rs.getInt(6);
				city=new City(rs.getInt(5),rs.getString(9));
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

	public  Boolean saveAddress(){
		Boolean flag=false;
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="insert into addresses (user_id,address,city_id,pin,default_address,name) values (?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,user.getUserId());
			pst.setString(2,address);
			pst.setInt(3,city.getCityId());
			pst.setInt(4,pin);
			if(name==null){
				pst.setBoolean(5,DEFAULT_ADDRESS);
				pst.setString(6,user.getFullName());
			}
			else{
				pst.setBoolean(5,NON_DEFAULT_ADDRESS);
				pst.setString(6,name);
			}
				pst.executeUpdate();
			flag=true;
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

	public void setAddressId(Integer addressId){
		this.addressId=addressId;
	}
	public Integer getAddressId(){
		return addressId;
	}
	public void setUser(User user){
		this.user=user;
	}
	public User getUser(){
		return user;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setCity(City city){
		this.city=city;
	}
	public City getCity(){
		return city;
	}
	public void setPin(Integer pin){
		this.pin=pin;
	}
	public Integer getpin(){
		return pin;
	}
	public void setDefaultAddress(Boolean defaultAddress){
		this.defaultAddress=defaultAddress;
	}
	public Boolean isDefaultAddress(){
		return defaultAddress;
	}
}