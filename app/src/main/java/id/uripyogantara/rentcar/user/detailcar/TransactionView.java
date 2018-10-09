package id.uripyogantara.rentcar.user.detailcar;

import id.uripyogantara.rentcar.model.Response;

public interface TransactionView {
    void showLoading();
    void hideLoading();
    void onSuccess(Response response);
    void onError();
    void onFailure(Throwable t);
}
