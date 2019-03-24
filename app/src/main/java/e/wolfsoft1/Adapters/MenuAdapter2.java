package e.wolfsoft1.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import e.wolfsoft1.ModelClasses.MenuModel1;
import e.wolfsoft1.ModelClasses.MenuModel2;
import e.wolfsoft1.iyedelivery.R;

public class MenuAdapter2 extends RecyclerView.Adapter<MenuAdapter2.MyViewHolder>{

    Context context;


    private List<MenuModel2> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {



        TextView foodType;

        public MyViewHolder(View view) {
            super(view);

            foodType=(TextView)view.findViewById(R.id.foodType);


        }

    }


    public MenuAdapter2(Context mainActivityContacts, List<MenuModel2> offerList) {
        this.OfferList = offerList;
        this.context = mainActivityContacts;
    }

    @Override
    public MenuAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dish_recycle, parent, false);


        return new MenuAdapter2.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MenuModel2 lists = OfferList.get(position);
        holder.foodType.setText(lists.getFoodType());
    }





    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}
