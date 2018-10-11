package id.uripyogantara.rentcar.admin.transaction;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.model.Transaction;
import id.uripyogantara.rentcar.utils.Constant;
import id.uripyogantara.rentcar.utils.CurrencyFormater;
import id.uripyogantara.rentcar.utils.DateFormater;

public class AdminTransactionAdapter extends RecyclerView.Adapter<AdminTransactionAdapter.ViewHolder> {
    private Context context;
    private List<Transaction> transactions;
    private OnClickListener onClickListener;
    public AdminTransactionAdapter(Context context, List<Transaction> transactions) {
        this.context = context;
        this.transactions=transactions;
    }

    public interface OnClickListener{
        void onClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_rent,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(transactions.get(i));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }
    ImageView imgCar;
    TextView tvName, tvRentalPrice,tvStatus,tvDate;
    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCar=itemView.findViewById(R.id.img_car);
            tvName=itemView.findViewById(R.id.tv_car_name);
            tvRentalPrice=itemView.findViewById(R.id.tv_car_rental_price);
            tvDate=itemView.findViewById(R.id.tv_transaction_date);
            tvStatus=itemView.findViewById(R.id.tv_transaction_status);
            if (onClickListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClick(getAdapterPosition());
                    }
                });
            }
        }
        public void bind(Transaction transaction){
            String rentalPrice=CurrencyFormater.toRupiah(transaction.getCar().getRentalPrice())+" /hari";
            String date=DateFormater.setDate(transaction.getStartDate())+" s/d "+DateFormater.setDate(transaction.getEndDate());
            tvName.setText(transaction.getCar().getName());
            tvRentalPrice.setText(rentalPrice);
            tvStatus.setText(transaction.getStatusName());
            tvDate.setText(date);
            Glide.with(context).load(Constant.URL.carImage(transaction.getCar().getPicture())).into(imgCar);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
