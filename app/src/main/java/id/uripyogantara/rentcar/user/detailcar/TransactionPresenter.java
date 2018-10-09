package id.uripyogantara.rentcar.user.detailcar;

import id.uripyogantara.rentcar.api.ApiService;
import id.uripyogantara.rentcar.model.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class TransactionPresenter {
    private ApiService service;
    private TransactionView view;

    public TransactionPresenter(ApiService service, TransactionView view) {
        this.service = service;
        this.view = view;
    }

    public void storeTransaction(int carId,String dateStart,String dateEnd){
        view.showLoading();
        service.storeTransaction(carId,dateStart,dateEnd)
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        view.onFailure(t);
                        view.hideLoading();
                    }
                });
    }
}
