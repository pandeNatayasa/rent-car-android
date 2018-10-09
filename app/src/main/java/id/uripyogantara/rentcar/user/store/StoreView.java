package id.uripyogantara.rentcar.user.store;

import java.util.List;

import id.uripyogantara.rentcar.model.Car;
import id.uripyogantara.rentcar.model.Store;

public interface StoreView {
    void showLoading();
    void hideLoading();
    void onSuccess(List<Store> stores);
    void onError();
    void onFailure(Throwable t);
}
