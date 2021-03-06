package id.uripyogantara.rentcar.user.transaction;

import java.util.List;

import id.uripyogantara.rentcar.model.Transaction;

public interface TransactionView {
    void showLoading();
    void hideLoading();
    void onSuccess(List<Transaction> transactions);
    void onError();
    void onFailure(Throwable t);
}
