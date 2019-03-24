package e.wolfsoft1.iyedelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import e.wolfsoft1.Adapters.CartAdapter;
import e.wolfsoft1.Adapters.MenuAdapter1;
import e.wolfsoft1.ModelClasses.CartModel;
import e.wolfsoft1.ModelClasses.MenuModel1;

public class CartActivity extends AppCompatActivity {

    private ArrayList<CartModel> homeListModelClassArrayList;
    private RecyclerView cartRecycler;
    private CartAdapter mAdapter;

    String foodName[]={"Daal Makhni","Paneer Tikka Masala"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartRecycler = (RecyclerView)findViewById(R.id.cartRecycler);
        homeListModelClassArrayList = new ArrayList<>();

        for (int i = 0; i < foodName.length; i++) {
            CartModel beanClassForRecyclerView_contacts = new CartModel(foodName[i]);
            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
        }
        mAdapter = new CartAdapter(CartActivity.this,homeListModelClassArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(CartActivity.this);
        cartRecycler.setLayoutManager(mLayoutManager);
        cartRecycler.setItemAnimator(new DefaultItemAnimator());
        cartRecycler.setAdapter(mAdapter);


    }
}
