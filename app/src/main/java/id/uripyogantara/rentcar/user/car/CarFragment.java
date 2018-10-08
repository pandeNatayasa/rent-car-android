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

import java.util.List;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.api.ApiClient;
import id.uripyogantara.rentcar.model.Car;
import id.uripyogantara.rentcar.user.detailcar.DetailCarActivity;

public class CarFragment extends Fragment implements CarAdapter.OnClickListener, CarView {

    private RecyclerView rvCar;
    private CarAdapter adapter;
    private CarPresenter presenter;
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

        presenter=new CarPresenter(this,ApiClient.getService(getContext()));
        presenter.getCars();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onClick(int position) {
        startActivity(new Intent(getContext(),DetailCarActivity.class));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onSuccess(List<Car> cars) {
        adapter=new CarAdapter(getContext(),cars);
        adapter.setOnClickListener(this);
        rvCar.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCar.setAdapter(adapter);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
