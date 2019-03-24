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

import e.wolfsoft1.ModelClasses.Food;
import e.wolfsoft1.ModelClasses.FoodModel;
import e.wolfsoft1.iyedelivery.R;

/**
 * Created by wolfsoft1 on 27/2/18.
 */

public class OrderAdapter2 extends RecyclerView.Adapter<OrderAdapter2.MyViewHolder>{

    Context context;
    private List<Food> food_lists;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView food_item;

        public MyViewHolder(View view) {
            super(view);

            food_item = view.findViewById(R.id.food_item);
        }

    }


    public OrderAdapter2(Context mainActivityContacts, List<Food> offerList) {
        this.food_lists = offerList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_ui, parent, false);


        return new MyViewHolder(itemView);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Food food = food_lists.get(position);
        holder.food_item.setText(food.getFood_name()+" "+food.getPrice()+" x "+food.getQnt());

    }

    @Override
    public int getItemCount() {
        return food_lists.size();
    }

}
