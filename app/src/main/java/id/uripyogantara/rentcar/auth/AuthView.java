package id.uripyogantara.rentcar.auth;

import id.uripyogantara.rentcar.model.User;

public interface AuthView {
    void showLoading();
    void hideLoading();
    void onSuccess(User user);
    void onError();
    void onFailure(Throwable t);
}
