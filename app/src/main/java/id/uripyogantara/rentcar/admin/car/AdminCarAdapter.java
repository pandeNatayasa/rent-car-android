package id.uripyogantara.rentcar.admin.car;

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
import id.uripyogantara.rentcar.model.Car;
import id.uripyogantara.rentcar.utils.Constant;
import id.uripyogantara.rentcar.utils.CurrencyFormater;

public class AdminCarAdapter extends RecyclerView.Adapter<AdminCarAdapter.ViewHolder> {
    private Context context;
    private OnClickListener onClickListener;
    private List<Car> cars;
    public AdminCarAdapter(Context context, List<Car> cars) {
        this.context = context;
        this.cars=cars;
    }

    public interface OnClickListener{
        void onClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_car,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Car car=cars.get(i);
        viewHolder.bind(car);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgCar;
        TextView tvName, tvRentalPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCar=itemView.findViewById(R.id.img_car);
            tvName=itemView.findViewById(R.id.tv_car_name);
            tvRentalPrice=itemView.findViewById(R.id.tv_car_rental_price);
            if (onClickListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClick(getAdapterPosition());
                    }
                });
            }
        }

        public void bind(Car car){
            String rentalPrice=CurrencyFormater.toRupiah(car.getRentalPrice())+" /hari";
            tvName.setText(car.getName());
            tvRentalPrice.setText(rentalPrice);
            Glide.with(context).load(Constant.URL.carImage(car.getPicture())).into(imgCar);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
