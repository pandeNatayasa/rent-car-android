package id.uripyogantara.rentcar.user.store.car;

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
import id.uripyogantara.rentcar.model.Store;
import id.uripyogantara.rentcar.user.car.CarAdapter;
import id.uripyogantara.rentcar.user.car.CarView;
import id.uripyogantara.rentcar.user.detailcar.DetailCarActivity;

public class StoreCarFragment extends Fragment implements CarAdapter.OnClickListener, CarView {
    List<Car> cars;
    private RecyclerView rvCar;
    private CarAdapter adapter;
    private StoreCarPresenter presenter;
    Store store;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        store=bundle.getParcelable(DetailCarActivity.KEY_STORE);
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

        presenter=new StoreCarPresenter(this,ApiClient.getService(getContext()));
        presenter.getStoreCars(store.getId());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onClick(int position) {
        Car car=cars.get(position);
        Bundle bundle=new Bundle();
        bundle.putParcelable(DetailCarActivity.KEY_CAR,car);
        bundle.putParcelable(DetailCarActivity.KEY_STORE,car.getStore());
        Intent intent=new Intent(getContext(),DetailCarActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onSuccess(List<Car> cars) {
        this.cars=cars;
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
