package e.wolfsoft1.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import e.wolfsoft1.ModelClasses.FoodModel;
import e.wolfsoft1.ModelClasses.RestaurantModel;
import e.wolfsoft1.iyedelivery.R;

/**
 * Created by wolfsoft1 on 28/2/18.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {
    Context context;


    private List<RestaurantModel> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView foodImage;
        TextView ratings,restaurantName,restaurantCusine,deliveryTime,amount,paymentMode;

        public MyViewHolder(View view) {
            super(view);

            foodImage = (ImageView) view.findViewById(R.id.foodImage);
            ratings=(TextView) view.findViewById(R.id.ratings);
            restaurantName=(TextView) view.findViewById(R.id.restaurantName);
            restaurantCusine=(TextView) view.findViewById(R.id.restaurantCuisine);
            deliveryTime=(TextView) view.findViewById(R.id.deliveryTime);
            amount=(TextView) view.findViewById(R.id.amount);
            paymentMode=(TextView) view.findViewById(R.id.paymentMode);




        }

    }


    public RestaurantAdapter(Context mainActivityContacts, List<RestaurantModel> offerList) {
        this.OfferList = offerList;
        this.context = mainActivityContacts;
    }

    @Override
    public RestaurantAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_recycler, parent, false);


        return new RestaurantAdapter.MyViewHolder(itemView);


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final RestaurantAdapter.MyViewHolder holder, int position) {
        RestaurantModel lists = OfferList.get(position);
        holder.foodImage.setImageResource(lists.getFoodImage());
        holder.ratings.setText(lists.getRatings());
        holder.restaurantName.setText(lists.getRestaurantName());
        holder.restaurantCusine.setText(lists.getRestaurantCuisine());
        holder.amount.setText(lists.getAmount());
        holder.paymentMode.setText(lists.getPaymentMode());
        holder.deliveryTime.setText(lists.getDliveryTime());



    }

    @Override
    public int getItemCount() {
        return OfferList.size();

    }
}
