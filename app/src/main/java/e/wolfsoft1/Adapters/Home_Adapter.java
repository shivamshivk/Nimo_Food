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
import e.wolfsoft1.ModelClasses.Home;
import e.wolfsoft1.ModelClasses.Main_Order;
import e.wolfsoft1.iyedelivery.R;

/**
 * Created by wolfsoft1 on 27/2/18.
 */

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.MyViewHolder>{

    Context context;
    private List<Home> homeList;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tile_title;
        ImageView img1;
        ImageView img2;
        TextView offer_txt_1;
        TextView offer_txt_2;

        public MyViewHolder(View view) {
            super(view);

            tile_title = view.findViewById(R.id.tile_heading);
            img1 = view.findViewById(R.id.img1);
            img2 = view.findViewById(R.id.img2);
            offer_txt_1 = view.findViewById(R.id.tile_txt_1);
            offer_txt_2 = view.findViewById(R.id.tile_txt_2);

        }

    }

    public Home_Adapter(Context mainActivityContacts, List<Home> offerList) {
        this.homeList = offerList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_layout_design, parent, false);


        return new MyViewHolder(itemView);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Home home = homeList.get(position);
        holder.tile_title.setText(home.getTile_title());
        holder.offer_txt_1.setText(home.getTile_1_text());
        holder.offer_txt_2.setText(home.getTile_2_text());
        holder.img1.setImageResource(home.getImg_1());
        holder.img2.setImageResource(home.getImg_2());
    }

    @Override
    public int getItemCount() {
        return homeList.size();

    }

}
