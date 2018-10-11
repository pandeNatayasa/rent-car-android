package id.uripyogantara.rentcar.admin.car;

import java.util.List;

import id.uripyogantara.rentcar.model.Car;

public interface AdminCarView {
    void showLoading();
    void hideLoading();
    void onSuccess(List<Car> cars);
    void onError();
    void onFailure(Throwable t);
}
