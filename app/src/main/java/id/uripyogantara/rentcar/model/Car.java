package id.uripyogantara.rentcar.model;

import com.google.gson.annotations.SerializedName;

public class Car{

	@SerializedName("store_id")
	private int storeId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("name")
	private String name;

	@SerializedName("rental_price")
	private int rentalPrice;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("store")
	private Store store;

	@SerializedName("picture")
	private String picture;

	public void setStoreId(int storeId){
		this.storeId = storeId;
	}

	public int getStoreId(){
		return storeId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRentalPrice(int rentalPrice){
		this.rentalPrice = rentalPrice;
	}

	public int getRentalPrice(){
		return rentalPrice;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
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

	public void setStore(Store store){
		this.store = store;
	}

	public Store getStore(){
		return store;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}

	@Override
 	public String toString(){
		return 
			"Car{" + 
			"store_id = '" + storeId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",name = '" + name + '\'' + 
			",rental_price = '" + rentalPrice + '\'' + 
			",description = '" + description + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",store = '" + store + '\'' + 
			",picture = '" + picture + '\'' + 
			"}";
		}
}