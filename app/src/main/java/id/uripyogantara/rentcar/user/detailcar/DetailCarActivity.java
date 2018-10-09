package id.uripyogantara.rentcar.user.detailcar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.api.ApiClient;
import id.uripyogantara.rentcar.model.Car;
import id.uripyogantara.rentcar.model.Response;
import id.uripyogantara.rentcar.model.Store;
import id.uripyogantara.rentcar.user.store.StoreActivity;
import id.uripyogantara.rentcar.utils.Constant;
import id.uripyogantara.rentcar.utils.CurrencyFormater;
import id.uripyogantara.rentcar.utils.DateFormater;

public class DetailCarActivity extends AppCompatActivity implements View.OnClickListener, DetailCarView {
    public static final String KEY_CAR="car";
    public static final String KEY_STORE="store";

    TextView tvStoreName,tvCarName,tvRentalPrice,tvDescription;
    ImageView imgCar;
    ImageButton btnRent;

    Car car;
    Store store;

    int year_x,month_x,day_x;

    String dateStart,dateEnd,timeStart,timeEnd;

    DetailCarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_car);
        init();
        setToolbar();
        setView();

        year_x=2018;
        day_x=11;
        month_x=9;
        timeStart="10:00";
        timeEnd="10:00";
    }

    private void init(){
        car=getIntent().getParcelableExtra(KEY_CAR);
        store=getIntent().getParcelableExtra(KEY_STORE);

        presenter=new DetailCarPresenter(ApiClient.getService(this),this);

        imgCar=findViewById(R.id.img_car);
        btnRent=findViewById(R.id.btn_rent);

        tvStoreName =findViewById(R.id.tv_store_name);
        tvCarName=findViewById(R.id.tv_car_name);
        tvRentalPrice=findViewById(R.id.tv_car_rental_price);
        tvDescription=findViewById(R.id.tv_description);

        tvStoreName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),StoreActivity.class);
                Bundle bundle=new Bundle();
                bundle.putParcelable(KEY_STORE,store);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnRent.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_rent:
                showDialog();
                break;
        }
    }
    private void showDialog(){
        ImageButton btnRentDialog;
        final TextView tvDateStart,tvDateEnd,tvMonthStart,tvMonthEnd,tvTimeStart,tvTimeEnd;

        AlertDialog.Builder dialog;

        dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_rent, null);

        btnRentDialog=dialogView.findViewById(R.id.btn_rent_dialog);
        tvDateStart=dialogView.findViewById(R.id.tv_date_start);
        tvDateEnd=dialogView.findViewById(R.id.tv_date_end);
        tvMonthStart=dialogView.findViewById(R.id.tv_month_start);
        tvMonthEnd=dialogView.findViewById(R.id.tv_month_end);

        tvTimeStart=dialogView.findViewById(R.id.tv_time_start);
        tvTimeEnd=dialogView.findViewById(R.id.tv_time_end);

        tvDateStart.setOnClickListener(this);
        tvDateEnd.setOnClickListener(this);
        tvMonthStart.setOnClickListener(this);
        tvMonthEnd.setOnClickListener(this);

        btnRentDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dateTimeStart=dateStart+" "+timeStart;
                String dateTimeEnd=dateEnd+" "+timeEnd;
                presenter.storeTransaction(car.getId(),dateTimeStart,dateTimeEnd);
            }
        });

        tvDateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(tvMonthStart,tvDateStart,1);
            }
        });

        tvDateEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(tvMonthEnd,tvDateEnd,2);
            }
        });

        tvTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(tvTimeStart,1);
            }
        });

        tvTimeEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(tvTimeEnd,2);
            }
        });

        dialog.setView(dialogView);

        dialog.show();
    }

    public void showDatePickerDialog(final TextView tvMonth, final TextView tvDate, final int type){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String strMonth=DateFormater.dateValidation(month+1);
                String strDayOfMonth=DateFormater.dateValidation(dayOfMonth);
                String strDate=year+"-"+DateFormater.dateValidation(month+1)+"-"+DateFormater.dateValidation(dayOfMonth);
                tvMonth.setText(DateFormater.getMonthName(strMonth));
                tvDate.setText(strDayOfMonth);

                if (type==1){
                    dateStart=strDate;
                }else {
                    dateEnd=strDate;
                }
            }
        },year_x,month_x,day_x);
        datePickerDialog.show();
    }

    public void showTimePickerDialog(final TextView tvTime, final int type){
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time=hourOfDay+":"+DateFormater.dateValidation(minute);
                tvTime.setText(time);
                if (type==1){
                    timeStart=time;
                }else {
                    timeEnd=time;
                }
            }
        },10,0,true);

        timePickerDialog.show();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onSuccess(Response response) {
        finish();
        Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, "Error : "+t, Toast.LENGTH_SHORT).show();
    }
}
