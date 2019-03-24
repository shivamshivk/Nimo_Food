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

import e.wolfsoft1.ModelClasses.RestaurantModel;
import e.wolfsoft1.ModelClasses.ShippingModel;
import e.wolfsoft1.iyedelivery.R;

public class ShippingAdapter extends RecyclerView.Adapter<ShippingAdapter.MyViewHolder> {
    Context context;
    int pos=-1;


    private List<ShippingModel> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView radioButton;
        TextView address,addressName;

        public MyViewHolder(View view) {
            super(view);

            radioButton = (ImageView) view.findViewById(R.id.radioButton);
            address=(TextView) view.findViewById(R.id.address);
            addressName=(TextView) view.findViewById(R.id.addressName);

            }

    }


    public ShippingAdapter(Context mainActivityContacts, List<ShippingModel> offerList) {
        this.OfferList = offerList;
        this.context = mainActivityContacts;
    }

    @Override
    public ShippingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shipping_recycler, parent, false);


        return new ShippingAdapter.MyViewHolder(itemView);


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final ShippingAdapter.MyViewHolder holder, final int position) {
        ShippingModel lists = OfferList.get(position);
        holder.radioButton.setImageResource(lists.getRadioButton());
        holder.address.setText(lists.getAddress());
        holder.addressName.setText(lists.getAddressName());

        if (pos==position){
            holder.radioButton.setImageResource(R.drawable.ic_radio_button_orange);
        }
        else {
            holder.radioButton.setImageResource(R.drawable.ic_radio_button_grey);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = position;

                notifyDataSetChanged();


              }

        });



    }

    @Override
    public int getItemCount() {
        return OfferList.size();

    }
}

