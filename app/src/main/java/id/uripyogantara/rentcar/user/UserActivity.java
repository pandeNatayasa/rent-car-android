package id.uripyogantara.rentcar.user;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.user.car.CarFragment;
import id.uripyogantara.rentcar.user.profil.ProfilFragment;
import id.uripyogantara.rentcar.user.transaction.TransactionFragment;

public class UserActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationViewEx bnve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setFragment(new CarFragment());
        bnve=findViewById(R.id.bnve);


        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);

        bnve.setOnNavigationItemSelectedListener(this);
    }

    private void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_home:
                setFragment(new CarFragment());
                break;
            case R.id.menu_car:
                setFragment(new TransactionFragment());
                break;
            case R.id.menu_profil:
                setFragment(new ProfilFragment());
                break;
        }
        return true;
    }
}
