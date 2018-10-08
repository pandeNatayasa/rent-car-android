package id.uripyogantara.rentcar.auth.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.api.ApiClient;
import id.uripyogantara.rentcar.api.ApiService;
import id.uripyogantara.rentcar.auth.AuthPresenter;
import id.uripyogantara.rentcar.auth.AuthView;
import id.uripyogantara.rentcar.model.User;
import id.uripyogantara.rentcar.user.UserActivity;
import id.uripyogantara.rentcar.utils.Constant;
import id.uripyogantara.rentcar.utils.PreferencesHelper;

public class RegisterActivity extends AppCompatActivity implements AuthView {

    Button btnRegister;
    EditText etNama;
    EditText etEmail;
    EditText etTelepon;
    EditText etUsername;
    EditText etPassword;
    RadioGroup rgUserType;

    AuthPresenter presenter;
    PreferencesHelper preferencesHelper;

    int userType=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNama=findViewById(R.id.et_nama);
        etEmail=findViewById(R.id.et_email);
        etTelepon=findViewById(R.id.et_telepon);
        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);

        rgUserType=findViewById(R.id.rg_user_type);
        btnRegister=findViewById(R.id.btn_register);

        rgUserType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rb_user){
                    userType=Constant.UserType.USER;
                }else if (checkedId==R.id.rb_store){
                    userType=Constant.UserType.STORE;
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        presenter=new AuthPresenter(this,ApiClient.getService(this));
        preferencesHelper=new PreferencesHelper(this);
    }


    private void register(){
        String name=etNama.getText().toString();
        String email=etEmail.getText().toString();
        String phone=etTelepon.getText().toString();
        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();
        presenter.register(name,username,email,phone,password,userType);
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
        startActivity(new Intent(this,UserActivity.class));
        finish();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Response Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, "Error : "+t, Toast.LENGTH_SHORT).show();
    }
}
