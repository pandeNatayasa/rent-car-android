package id.uripyogantara.rentcar.model;

import com.google.gson.annotations.SerializedName;

public class Transaction{

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("car")
	private Car car;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("car_id")
	private int carId;

	@SerializedName("start_date")
	private String startDate;

	@SerializedName("status")
	private int status;

	@SerializedName("status_name")
	private String statusName;

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setCar(Car car){
		this.car = car;
	}

	public Car getCar(){
		return car;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCarId(int carId){
		this.carId = carId;
	}

	public int getCarId(){
		return carId;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
 	public String toString(){
		return 
			"Transaction{" + 
			"end_date = '" + endDate + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",car = '" + car + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",car_id = '" + carId + '\'' + 
			",start_date = '" + startDate + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}