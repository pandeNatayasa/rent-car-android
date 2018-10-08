package id.uripyogantara.rentcar.api;

import java.util.List;

import id.uripyogantara.rentcar.model.Car;
import id.uripyogantara.rentcar.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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

    @GET("car")
    Call<List<Car>> allCar();
}
