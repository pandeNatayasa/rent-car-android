package id.uripyogantara.rentcar.user.store.overview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.model.Store;
import id.uripyogantara.rentcar.user.detailcar.DetailCarActivity;

public class StoreOverviewFragment extends Fragment {
    TextView tvStoreName,tvStoreOwner,tvStorePhone,tvStoreEmail,tvStoreAddress;
    Store store;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        store=bundle.getParcelable(DetailCarActivity.KEY_STORE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_store_overview,container,false);
        tvStoreAddress=view.findViewById(R.id.tv_store_address);
        tvStoreName=view.findViewById(R.id.tv_store_name);
        tvStoreOwner=view.findViewById(R.id.tv_store_owner);
        tvStorePhone=view.findViewById(R.id.tv_store_phone);
        tvStoreEmail=view.findViewById(R.id.tv_store_email);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvStoreAddress.setText(store.getAddress());
        tvStoreName.setText(store.getName());
//        tvStoreOwner.setText();
//        tvStorePhone=view.findViewById(R.id.tv_store_phone);
//        tvStoreEmail=view.findViewById(R.id.tv_store_email);
    }
}
