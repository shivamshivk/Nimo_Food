package e.wolfsoft1.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import e.wolfsoft1.ModelClasses.Food;
import e.wolfsoft1.ModelClasses.FoodModel;
import e.wolfsoft1.ModelClasses.Main_Order;
import e.wolfsoft1.iyedelivery.R;

/**
 * Created by wolfsoft1 on 27/2/18.
 */

public class OrderAdapter1 extends RecyclerView.Adapter<OrderAdapter1.MyViewHolder>{

    Context context;
    private List<Main_Order> food_items;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView food_img;
        TextView food_price,food_date;
        RecyclerView food_r_view;


        public MyViewHolder(View view) {
            super(view);

            food_img = view.findViewById(R.id.img_food);
            food_price = view.findViewById(R.id.t_price);
            food_date = view.findViewById(R.id.date);
            food_r_view = view.findViewById(R.id.recycler_v);

        }

    }


    public OrderAdapter1(Context mainActivityContacts, List<Main_Order> offerList) {
        this.food_items = offerList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_order_list, parent, false);


        return new MyViewHolder(itemView);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Main_Order main_order = food_items.get(position);
        holder.food_date.setText(main_order.getFood_date());
        holder.food_price.setText(main_order.getFood_price());
        holder.food_img.setImageResource(main_order.getFood_img());
        OrderAdapter2 orderAdapter2 = new OrderAdapter2(context,main_order.getFood_items());
        RecyclerView.LayoutManager bLayoutManager = new LinearLayoutManager(context);
        holder.food_r_view.setLayoutManager(bLayoutManager);
        holder.food_r_view.setItemAnimator(new DefaultItemAnimator());
        holder.food_r_view.setAdapter(orderAdapter2);

    }

    @Override
    public int getItemCount() {
        return food_items.size();

    }

}
