package id.uripyogantara.rentcar.user.detailcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.model.Car;
import id.uripyogantara.rentcar.model.Store;
import id.uripyogantara.rentcar.user.toko.TokoActivity;
import id.uripyogantara.rentcar.utils.Constant;
import id.uripyogantara.rentcar.utils.CurrencyFormater;

public class DetailCarActivity extends AppCompatActivity {
    public static final String KEY_CAR="car";
    public static final String KEY_STORE="store";

    TextView tvStoreName,tvCarName,tvRentalPrice,tvDescription;
    ImageView imgCar;

    Car car;
    Store store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_car);
        init();
        setToolbar();
        setView();
    }

    private void init(){
        car=getIntent().getParcelableExtra(KEY_CAR);
        store=getIntent().getParcelableExtra(KEY_STORE);

        imgCar=findViewById(R.id.img_car);

        tvStoreName =findViewById(R.id.tv_store_name);
        tvCarName=findViewById(R.id.tv_car_name);
        tvRentalPrice=findViewById(R.id.tv_car_rental_price);
        tvDescription=findViewById(R.id.tv_description);

        tvStoreName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TokoActivity.class));
            }
        });
    }

    private void setToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setView(){
        String rentalPrice=CurrencyFormater.toRupiah(car.getRentalPrice())+" /hari";
        tvStoreName.setText(store.getName());
        tvCarName.setText(car.getName());
        tvRentalPrice.setText(rentalPrice);
        tvDescription.setText(car.getDescription());

        Glide.with(this).load(Constant.URL.carImage(car.getPicture())).into(imgCar);
    }
}
