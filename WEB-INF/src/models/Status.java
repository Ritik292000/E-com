package models;

public class Status{
	private Integer statusId;
	private String status;
	
	public Status(Integer statusId){
		this.statusId=statusId;
	}
	
	public Status(Integer statusId,String status){
		this.statusId=statusId;
		this.status=status;
	}

	public void setStatusId(Integer statusId){
		this.statusId=statusId;
	} 
	public Integer getStatusId(){
		return statusId;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
}