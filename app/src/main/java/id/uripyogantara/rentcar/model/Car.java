package id.uripyogantara.rentcar.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Car implements Parcelable {

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

	protected Car(Parcel in) {
		storeId = in.readInt();
		updatedAt = in.readString();
		name = in.readString();
		rentalPrice = in.readInt();
		description = in.readString();
		createdAt = in.readString();
		id = in.readInt();
		picture = in.readString();
	}

	public static final Creator<Car> CREATOR = new Creator<Car>() {
		@Override
		public Car createFromParcel(Parcel in) {
			return new Car(in);
		}

		@Override
		public Car[] newArray(int size) {
			return new Car[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(storeId);
		dest.writeString(updatedAt);
		dest.writeString(name);
		dest.writeInt(rentalPrice);
		dest.writeString(description);
		dest.writeString(createdAt);
		dest.writeInt(id);
		dest.writeString(picture);
	}
}