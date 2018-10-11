package id.uripyogantara.rentcar.admin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.admin.car.AdminCarFragment;
import id.uripyogantara.rentcar.admin.transaction.AdminTransactionFragment;
import id.uripyogantara.rentcar.user.car.CarFragment;
import id.uripyogantara.rentcar.user.profil.ProfilFragment;
import id.uripyogantara.rentcar.user.store.StoreFragment;
import id.uripyogantara.rentcar.user.transaction.TransactionFragment;

public class AdminActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationViewEx bnve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setFragment(new AdminTransactionFragment());
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
                setFragment(new AdminTransactionFragment());
                break;
            case R.id.menu_car:
                setFragment(new AdminCarFragment());
                break;
            case R.id.menu_profil:
                setFragment(new ProfilFragment());
                break;
        }
        return true;
    }
}
