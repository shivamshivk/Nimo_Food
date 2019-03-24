package e.wolfsoft1.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import e.wolfsoft1.ModelClasses.CartModel;
import e.wolfsoft1.ModelClasses.MenuModel1;
import e.wolfsoft1.iyedelivery.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{

    Context context;


    private List<CartModel> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {



        TextView foodName;

        public MyViewHolder(View view) {
            super(view);

            foodName=(TextView)view.findViewById(R.id.foodName);


        }

    }


    public CartAdapter(Context mainActivityContacts, List<CartModel> offerList) {
        this.OfferList = offerList;
        this.context = mainActivityContacts;
    }

    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_recycler, parent, false);


        return new CartAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(CartAdapter.MyViewHolder holder, int position) {
        CartModel lists = OfferList.get(position);

        holder.foodName.setText(lists.getFoodName());

    }



    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}

