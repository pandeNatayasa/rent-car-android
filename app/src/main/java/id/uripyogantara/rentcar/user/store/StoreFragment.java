package id.uripyogantara.rentcar.user.store;

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
import id.uripyogantara.rentcar.model.Store;
import id.uripyogantara.rentcar.user.detailstore.StoreActivity;

import static id.uripyogantara.rentcar.user.detailcar.DetailCarActivity.KEY_STORE;

public class StoreFragment extends Fragment implements StoreView, StoreAdapter.OnClickListener {
    List<Store> stores;
    private RecyclerView rvStore;
    private StoreAdapter adapter;
    private StorePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_store,container,false);
       rvStore =view.findViewById(R.id.rv_store);
       return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter=new StorePresenter(this,ApiClient.getService(getContext()));
        presenter.getStores();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onSuccess(List<Store> stores) {
        this.stores= stores;
        adapter=new StoreAdapter(getContext(),stores);
        adapter.setOnClickListener(this);
        rvStore.setLayoutManager(new LinearLayoutManager(getContext()));
        rvStore.setAdapter(adapter);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void onClick(int position) {
        Store store=stores.get(position);
        Intent intent=new Intent(getContext(),StoreActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable(KEY_STORE,store);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
