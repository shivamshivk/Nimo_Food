package e.wolfsoft1.iyedelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import e.wolfsoft1.Adapters.MyOrderAdapter;
import e.wolfsoft1.ModelClasses.MyOrderModel;

public class ConfirmOrderActivity extends AppCompatActivity {
    private ArrayList<MyOrderModel> homeListModelClassArrayList1;
    private RecyclerView menuRecycler;
    private MyOrderAdapter bAdapter;

    String foodName[]={"Daal Makhni","Daal Makhni"};
    String quantity[]={"Quantity 1","Quantity 1"};
    String rupees[]={"Rs 300","Rs 300"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        menuRecycler = (RecyclerView)findViewById(R.id.menuRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ConfirmOrderActivity.this);
        menuRecycler.setLayoutManager(layoutManager);
        menuRecycler.setItemAnimator(new DefaultItemAnimator());

        homeListModelClassArrayList1 = new ArrayList<>();

        for (int i = 0; i < foodName.length; i++) {
            MyOrderModel beanClassForRecyclerView_contacts = new MyOrderModel(foodName[i],quantity[i],rupees[i]);
            homeListModelClassArrayList1.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new MyOrderAdapter(ConfirmOrderActivity.this,homeListModelClassArrayList1);
        menuRecycler.setAdapter(bAdapter);
    }
}
