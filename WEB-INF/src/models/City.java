package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class City{
	private Integer cityId;
	private String city;
	private State stateId;
	
	public City(){
		super();
	}
	public City(Integer cityId,String city){
		super();
		this.cityId=cityId;
		this.city=city;
	}
	public City(Integer cityId,String city,State stateId){
		super();
		this.cityId=cityId;
		this.city=city;
		this.stateId=stateId;
	}

	public static ArrayList<City> searchCity(String skey){
		ArrayList<City> city=new ArrayList<City>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select city_id,city from cities where city like '"+skey+"%'";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rst=pst.executeQuery();
			while(rst.next()){
				city.add(new City(rst.getInt(1),rst.getString(2)));
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
		return city;
	}

	public void setCityId(Integer cityId){
		this.cityId=cityId;
	}
	public Integer getCityId(){
		return cityId;
	}
	public void setCity(String city){
		this.city=city;
	}
	public String getCity(){
		return city;
	}
	public void setStateId(State stateId){
		this.stateId=stateId;
	}
	public State getStateId(){
		return stateId;
	}
}