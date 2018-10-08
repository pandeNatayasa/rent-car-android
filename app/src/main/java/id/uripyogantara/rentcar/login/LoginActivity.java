package id.uripyogantara.rentcar.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.RegisterActivity;
import id.uripyogantara.rentcar.api.ApiClient;
import id.uripyogantara.rentcar.model.User;
import id.uripyogantara.rentcar.user.UserActivity;
import id.uripyogantara.rentcar.utils.PreferencesHelper;
import retrofit2.Call;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    protected Button btnLogin;
    protected TextView tvRegister;
    protected EditText etUsername,etPassword;

    private PreferencesHelper preferencesHelper;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init(){
        btnLogin=findViewById(R.id.btn_login);
        tvRegister=findViewById(R.id.tv_register);
        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

        presenter=new LoginPresenter(this,ApiClient.getService(this));

        preferencesHelper=new PreferencesHelper(this);
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(User user) {
        preferencesHelper.setUserLogin(user);
        startActivity(new Intent(LoginActivity.this,UserActivity.class));
        finish();
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, "Failed : "+t, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
        }
    }

    private void login(){
        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();

        if (validate(username,password)){
            presenter.login(username,password);
        }
    }

    private boolean validate(String username,String password){
        if (username.equals("")){
            etUsername.setError("Field username tidak boleh kosong");
            return false;
        }

        if (password.equals("")){
            etPassword.setError("Field password tidak boleh kosong");
            return false;
        }

        return true;
    }
}
