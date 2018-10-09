package id.uripyogantara.rentcar.user.transaction.going;

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
import android.widget.Toast;

import java.util.List;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.api.ApiClient;
import id.uripyogantara.rentcar.model.Transaction;
import id.uripyogantara.rentcar.user.detailcar.DetailCarActivity;
import id.uripyogantara.rentcar.user.transaction.TransactionAdapter;
import id.uripyogantara.rentcar.user.transaction.TransactionPresenter;
import id.uripyogantara.rentcar.user.transaction.TransactionView;

public class OnGoingTransactionFragment extends Fragment implements TransactionAdapter.OnClickListener, TransactionView {

    RecyclerView rvCar;
    TransactionAdapter adapter;

    TransactionPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_rent_going,container,false);
       rvCar=view.findViewById(R.id.rv_rent_going);
       return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter=new TransactionPresenter(this,ApiClient.getService(getContext()));
        presenter.getAllTransaction();
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
        Toast.makeText(getContext(), "loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(getContext(), "loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<Transaction> transactions) {
        rvCar.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new TransactionAdapter(getContext(),transactions);
        adapter.setOnClickListener(this);
        rvCar.setAdapter(adapter);
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(getContext(), "error : "+t, Toast.LENGTH_SHORT).show();
    }
}
