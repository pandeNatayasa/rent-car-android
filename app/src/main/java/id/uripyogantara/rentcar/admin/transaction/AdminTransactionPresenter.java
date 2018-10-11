package id.uripyogantara.rentcar.admin.transaction;

import java.util.List;

import id.uripyogantara.rentcar.api.ApiService;
import id.uripyogantara.rentcar.model.Transaction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminTransactionPresenter {
    private AdminTransactionView view;
    private ApiService service;

    public AdminTransactionPresenter(AdminTransactionView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void getAllTransaction(){
        view.showLoading();
        service.getStoreTransaction()
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
