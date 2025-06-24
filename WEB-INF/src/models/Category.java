package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class Category{
	private Integer categoryId;
	private String category;

	public Category(){
		super();
	}
	public Category(Integer categoryId){
		this.categoryId=categoryId;
	}
	public Category(Integer categoryId,String category){
		this.categoryId=categoryId;
		this.category=category;
	}

	public static ArrayList<Category> collectCategories(){
		ArrayList<Category> categories=new ArrayList<Category>();
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query="select * from categories";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
				
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
		return categories;
	}

	public void setCategoryId(Integer categoryId){
		this.categoryId=categoryId;
	}
	public Integer getCategoryId(){
		return categoryId;
	}
	public void setCategory(String category){
		this.category=category;
	}
	public String getCategory(){
		return category;
	}
}