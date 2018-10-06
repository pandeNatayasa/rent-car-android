package id.uripyogantara.rentcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.uripyogantara.rentcar.user.UserActivity;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register=findViewById(R.id.btn_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Halooo", Toast.LENGTH_SHORT).show();
                Intent intentRegister=new Intent(getApplicationContext(),UserActivity.class);
                startActivity(intentRegister);
            }
        });
    }
}
