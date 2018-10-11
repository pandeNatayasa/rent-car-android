package id.uripyogantara.rentcar.api;

import java.util.List;

import id.uripyogantara.rentcar.model.Car;
import id.uripyogantara.rentcar.model.Response;
import id.uripyogantara.rentcar.model.Store;
import id.uripyogantara.rentcar.model.Transaction;
import id.uripyogantara.rentcar.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<User> login(@Field("username") String username,@Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<User> register(
            @Field("name")      String name,
            @Field("username")  String username,
            @Field("email")     String email,
            @Field("phone")     String phone,
            @Field("password")  String password,
            @Field("user_type") int userType);

    @FormUrlEncoded
    @POST("register")
    Call<User> registerStore(
            @Field("name")      String name,
            @Field("username")  String username,
            @Field("email")     String email,
            @Field("phone")     String phone,
            @Field("password")  String password,
            @Field("user_type") int userType,
            @Field("store_name")  String storeName,
            @Field("store_address")  String storeAddress,
            @Field("lat")  double lat,
            @Field("lng")  double lng
    );

    @FormUrlEncoded
    @POST("transaction")
    Call<Response> storeTransaction(
            @Field("car_id")        int carId,
            @Field("start_date")    String dateStart,
            @Field("end_date")      String dateEnd);

    @GET("car")
    Call<List<Car>> allCar();

    @GET("car/store")
    Call<List<Car>> storeCar();

    @GET("transaction")
    Call<List<Transaction>> getAllTransaction();

    @GET("transaction/store")
    Call<List<Transaction>> getStoreTransaction();

    @GET("store/{id}/car")
    Call<List<Car>> showCarByStore(@Path("id") int storeId);

    @GET("store")
    Call<List<Store>> getAllStore();
}
