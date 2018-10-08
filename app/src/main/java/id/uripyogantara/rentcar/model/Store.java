package id.uripyogantara.rentcar.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Store implements Parcelable {

	@SerializedName("address")
	private String address;

	@SerializedName("lng")
	private double lng;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("lat")
	private double lat;

	protected Store(Parcel in) {
		address = in.readString();
		lng = in.readDouble();
		updatedAt = in.readString();
		userId = in.readInt();
		name = in.readString();
		createdAt = in.readString();
		id = in.readInt();
		lat = in.readDouble();
	}

	public static final Creator<Store> CREATOR = new Creator<Store>() {
		@Override
		public Store createFromParcel(Parcel in) {
			return new Store(in);
		}

		@Override
		public Store[] newArray(int size) {
			return new Store[size];
		}
	};

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
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

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"Store{" + 
			"address = '" + address + '\'' + 
			",lng = '" + lng + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",name = '" + name + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(address);
		dest.writeDouble(lng);
		dest.writeString(updatedAt);
		dest.writeInt(userId);
		dest.writeString(name);
		dest.writeString(createdAt);
		dest.writeInt(id);
		dest.writeDouble(lat);
	}
}