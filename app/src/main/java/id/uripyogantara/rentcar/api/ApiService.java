package id.uripyogantara.rentcar.api;

import id.uripyogantara.rentcar.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<User> login(@Field("username") String username,@Field("password") String password);
}
