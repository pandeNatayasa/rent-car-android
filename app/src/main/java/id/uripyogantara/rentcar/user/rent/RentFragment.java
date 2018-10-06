package id.uripyogantara.rentcar.user.rent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.user.car.CarFragment;
import id.uripyogantara.rentcar.user.detailcar.DetailCarActivity;
import id.uripyogantara.rentcar.user.profil.ProfilFragment;
import id.uripyogantara.rentcar.user.rent.going.RentGoingFragment;

public class RentFragment extends Fragment{

    PagerAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_rent,container,false);
       adapter=new PagerAdapter(getFragmentManager());

        ViewPager viewPager=view.findViewById(R.id.view_pager_rent);
        TabLayout tabLayout=view.findViewById(R.id.tab_rent);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
       return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    class PagerAdapter extends FragmentStatePagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return new RentGoingFragment();
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
                    return "GOING";
                default:
                    return "HISTORY";
            }
        }
    }
}
