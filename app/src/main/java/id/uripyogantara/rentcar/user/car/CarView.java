package id.uripyogantara.rentcar.user.car;

import java.util.List;

import id.uripyogantara.rentcar.model.Car;

public interface CarView {
    void showLoading();
    void hideLoading();
    void onSuccess(List<Car> cars);
    void onError();
    void onFailure(Throwable t);
}
