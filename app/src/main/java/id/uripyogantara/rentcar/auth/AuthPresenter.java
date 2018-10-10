package id.uripyogantara.rentcar.auth;

import id.uripyogantara.rentcar.api.ApiService;
import id.uripyogantara.rentcar.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthPresenter {
    private AuthView view;
    private ApiService service;

    public AuthPresenter(AuthView view, ApiService service) {
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
                }else{
                    view.onError();
                }
                view.hideLoading();
            }

            @Override
            public void onFailure(retrofit2.Call<User> call, Throwable t) {
                view.onFailure(t);
                view.hideLoading();
            }
        });
    }

    public void register(String name,String username,String email,String phone,String password,int userType){
        view.showLoading();
        service.register(name, username, email, phone, password, userType)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else{
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        view.onFailure(t);
                        view.hideLoading();
                    }
                });
    }

    public void registerStore(String name,String username,String email,String phone,String password,int userType,String storeName,
                              String storeAddress,
                              double lat,
                              double lng){
        view.showLoading();
        service.registerStore(name, username, email, phone, password, userType,storeName,storeAddress,lat,lng)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else{
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        view.onFailure(t);
                        view.hideLoading();
                    }
                });
    }
}
