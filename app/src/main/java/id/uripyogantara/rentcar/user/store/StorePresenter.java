package id.uripyogantara.rentcar.user.store;

import java.util.List;

import id.uripyogantara.rentcar.api.ApiService;
import id.uripyogantara.rentcar.model.Car;
import id.uripyogantara.rentcar.model.Store;
import id.uripyogantara.rentcar.user.car.CarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StorePresenter {
    private StoreView view;
    private ApiService service;

    public StorePresenter(StoreView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void getStores(){
        view.showLoading();

        service.getAllStore()
                .enqueue(new Callback<List<Store>>() {
                    @Override
                    public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<List<Store>> call, Throwable t) {
                        view.onFailure(t);
                        view.hideLoading();
                    }
                });
    }
}
