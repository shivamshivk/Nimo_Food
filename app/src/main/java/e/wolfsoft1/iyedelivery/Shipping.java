package e.wolfsoft1.iyedelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import e.wolfsoft1.Adapters.MenuAdapter1;
import e.wolfsoft1.Adapters.ShippingAdapter;
import e.wolfsoft1.ModelClasses.MenuModel1;
import e.wolfsoft1.ModelClasses.ShippingModel;

public class Shipping extends AppCompatActivity {

    private ArrayList<ShippingModel> homeListModelClassArrayList;
    private RecyclerView shippingRecycler;
    private ShippingAdapter mAdapter;

    String address[]={"Home","Office"};
    String addressName[]={"54/E Radhakrishna Soc. Opposite RK Bunglows, Near Punch pulla, Vadodara, 390011","S02, India bulls mega mall, near dinesh mill, JetalpurRoad, Vadodara, 390020"};
    Integer radioButton[]={R.drawable.ic_radio_button_grey,R.drawable.ic_radio_button_grey};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);

        shippingRecycler = (RecyclerView)findViewById(R.id.shippingRecycler);
        homeListModelClassArrayList = new ArrayList<>();

        for (int i = 0; i < address.length; i++) {
            ShippingModel beanClassForRecyclerView_contacts = new ShippingModel(address[i],addressName[i],radioButton[i]);
            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
        }
        mAdapter = new ShippingAdapter(Shipping.this,homeListModelClassArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Shipping.this);
        shippingRecycler.setLayoutManager(mLayoutManager);
        shippingRecycler.setItemAnimator(new DefaultItemAnimator());
        shippingRecycler.setAdapter(mAdapter);
    }
}
