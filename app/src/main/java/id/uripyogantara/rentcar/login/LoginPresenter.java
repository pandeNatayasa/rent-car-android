package id.uripyogantara.rentcar.login;

import android.telecom.Call;

import id.uripyogantara.rentcar.api.ApiService;
import id.uripyogantara.rentcar.model.User;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class LoginPresenter {
    private LoginView view;
    private ApiService service;

    public LoginPresenter(LoginView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void login(String username,String password){
        view.showLoading();
        service.login(username,password)
        .enqueue(new Callback<User>() {
            @Override
            public void onResponse(retrofit2.Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    view.onSuccess(response.body());
                    view.hideLoading();
                }else{
                    view.onError();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<User> call, Throwable t) {
                view.onFailure(t);
            }
        });
    }
}
