package models;

public class UserType{
	private Integer userTypeId;
	private String userType;


	public UserType(Integer userTypeId){
		this.userTypeId=userTypeId;
	}

	public UserType(Integer userTypeId,String userType){
		this.userTypeId=userTypeId;
		this.userType=userType;
	}

	public void setUserTypeId(Integer userTypeId){
		this.userTypeId=userTypeId;
	}
	public Integer getUserTypeId(){
		return userTypeId;
	}
	public void setUserType(String userType){
		this.userType=userType;
	}
	public String getUserType(){
		return userType;
	}
}