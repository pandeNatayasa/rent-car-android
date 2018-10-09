package id.uripyogantara.rentcar.user.transaction;

import java.util.List;

import id.uripyogantara.rentcar.api.ApiService;
import id.uripyogantara.rentcar.model.Transaction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionPresenter {
    private TransactionView view;
    private ApiService service;

    public TransactionPresenter(TransactionView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void getAllTransaction(){
        view.showLoading();
        service.getAllTransaction()
                .enqueue(new Callback<List<Transaction>>() {
                    @Override
                    public void onResponse(Call<List<Transaction>> call, Response<List<Transaction>> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<List<Transaction>> call, Throwable t) {
                        view.onFailure(t);
                        view.hideLoading();
                    }
                });
    }
}
