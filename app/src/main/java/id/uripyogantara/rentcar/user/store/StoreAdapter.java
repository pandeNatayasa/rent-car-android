package id.uripyogantara.rentcar.user.store;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.model.Store;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
    private Context context;
    private List<Store> stores;

    public StoreAdapter(Context context, List<Store> stores) {
        this.context = context;
        this.stores = stores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_store,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(stores.get(i));
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgStore;
        TextView tvStoreName,tvStoreAddress;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgStore=itemView.findViewById(R.id.img_store);
            tvStoreName=itemView.findViewById(R.id.tv_store_name);
            tvStoreAddress=itemView.findViewById(R.id.tv_store_address);
        }

        public void bind(Store store){
            tvStoreAddress.setText(store.getAddress());
            tvStoreName.setText(store.getName());
        }
    }
}
