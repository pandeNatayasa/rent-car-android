package id.uripyogantara.rentcar.user.detailstore;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.model.Store;
import id.uripyogantara.rentcar.user.detailstore.car.StoreCarFragment;
import id.uripyogantara.rentcar.user.detailstore.overview.StoreOverviewFragment;

import static id.uripyogantara.rentcar.user.detailcar.DetailCarActivity.KEY_STORE;

public class StoreActivity extends AppCompatActivity {
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    Store store;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko);

        store=getIntent().getParcelableExtra(KEY_STORE);

        viewPager=findViewById(R.id.view_pager_toko);
        tabLayout=findViewById(R.id.tab_toko);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    class PagerAdapter extends FragmentStatePagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment;
            if (i==0){
                fragment=new StoreOverviewFragment();
            }else {
                fragment=new StoreCarFragment();
            }
            Bundle bundle=new Bundle();
            bundle.putParcelable(KEY_STORE,store);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Overview";
                default:
                    return "Car";
            }
        }
    }
}
