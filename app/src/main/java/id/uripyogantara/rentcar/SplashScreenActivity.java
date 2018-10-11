package id.uripyogantara.rentcar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.uripyogantara.rentcar.admin.AdminActivity;
import id.uripyogantara.rentcar.auth.login.LoginActivity;
import id.uripyogantara.rentcar.user.UserActivity;
import id.uripyogantara.rentcar.utils.Constant;
import id.uripyogantara.rentcar.utils.PreferencesHelper;

public class SplashScreenActivity extends AppCompatActivity {

    PreferencesHelper preferencesHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        preferencesHelper=new PreferencesHelper(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (preferencesHelper.getLogin()){
                    if (preferencesHelper.getUserType()==Constant.UserType.USER){
                        intent=new Intent(SplashScreenActivity.this,UserActivity.class);
                    }else {
                        intent=new Intent(SplashScreenActivity.this,AdminActivity.class);
                    }
                }else {
                    intent=new Intent(SplashScreenActivity.this,LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },200);
    }
}
