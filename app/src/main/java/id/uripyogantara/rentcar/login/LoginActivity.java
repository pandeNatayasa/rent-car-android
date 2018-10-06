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
import retrofit2.Call;

public class LoginActivity extends AppCompatActivity implements LoginView {
    Button btnLogin;
    TextView tvRegister;
    EditText etUsername,etPassword;
    ApiClient apiClient;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=findViewById(R.id.btn_login);
        tvRegister=findViewById(R.id.tv_register);
        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        apiClient=new ApiClient(this);
        presenter=new LoginPresenter(this,apiClient.getService());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(etUsername.getText().toString(),etPassword.getText().toString());
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    private void login(){
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
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
        startActivity(new Intent(LoginActivity.this,UserActivity.class));
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
}
