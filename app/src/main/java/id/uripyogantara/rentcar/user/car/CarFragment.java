package id.uripyogantara.rentcar.user.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.user.detailcar.DetailCarActivity;

public class CarFragment extends Fragment implements CarAdapter.OnClickListener {

    RecyclerView rvCar;
    CarAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_car,container,false);
       rvCar=view.findViewById(R.id.rv_car);
       return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvCar.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new CarAdapter(getContext());
        adapter.setOnClickListener(this);
        rvCar.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onClick(int position) {
        startActivity(new Intent(getContext(),DetailCarActivity.class));
    }
}
