package id.uripyogantara.rentcar.login;

import id.uripyogantara.rentcar.model.User;

public interface LoginView {
    void showLoading();
    void hideLoading();
    void onSuccess(User user);
    void onError();
    void onFailure(Throwable t);
}
