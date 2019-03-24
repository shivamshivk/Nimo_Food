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
import e.wolfsoft1.ModelClasses.MenuModel1;
import e.wolfsoft1.iyedelivery.R;

public class MenuAdapter1 extends RecyclerView.Adapter<MenuAdapter1.MyViewHolder>{

    Context context;


    private List<MenuModel1> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {



        TextView foodType;

        public MyViewHolder(View view) {
            super(view);

            foodType=(TextView)view.findViewById(R.id.foodType);


            }

    }


    public MenuAdapter1(Context mainActivityContacts, List<MenuModel1> offerList) {
        this.OfferList = offerList;
        this.context = mainActivityContacts;
    }

    @Override
    public MenuAdapter1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category, parent, false);


        return new MenuAdapter1.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MenuModel1 lists = OfferList.get(position);

        holder.foodType.setText(lists.getFoodType());

    }



    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}
