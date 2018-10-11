package id.uripyogantara.rentcar.admin.transaction;

import java.util.List;

import id.uripyogantara.rentcar.model.Transaction;

public interface AdminTransactionView {
    void showLoading();
    void hideLoading();
    void onSuccess(List<Transaction> transactions);
    void onError();
    void onFailure(Throwable t);
}
