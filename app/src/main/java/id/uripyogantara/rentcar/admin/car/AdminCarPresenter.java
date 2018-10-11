package id.uripyogantara.rentcar.admin.car;

import java.util.List;

import id.uripyogantara.rentcar.api.ApiService;
import id.uripyogantara.rentcar.model.Car;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminCarPresenter {
    private AdminCarView view;
    private ApiService service;

    public AdminCarPresenter(AdminCarView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void getCars(){
        view.showLoading();

        service.storeCar()
                .enqueue(new Callback<List<Car>>() {
                    @Override
                    public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<List<Car>> call, Throwable t) {
                        view.onFailure(t);
                    }
                });
    }
}
