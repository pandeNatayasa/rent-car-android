package id.uripyogantara.rentcar.user.detailstore.car;

import java.util.List;

import id.uripyogantara.rentcar.api.ApiService;
import id.uripyogantara.rentcar.model.Car;
import id.uripyogantara.rentcar.user.car.CarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreCarPresenter {
    private CarView view;
    private ApiService service;

    public StoreCarPresenter(CarView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void getStoreCars(int storeId){
        view.showLoading();

        service.showCarByStore(storeId)
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
