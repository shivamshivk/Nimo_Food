package e.wolfsoft1.iyedelivery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import e.wolfsoft1.Adapters.MenuAdapter1;
import e.wolfsoft1.Adapters.MenuAdapter2;
import e.wolfsoft1.ModelClasses.MenuModel1;
import e.wolfsoft1.ModelClasses.MenuModel2;

public class PopularFragment  extends Fragment {
    private ArrayList<MenuModel2> homeListModelClassArrayList1;
    private RecyclerView menuRecycler;
    private MenuAdapter2 bAdapter;

    String foodName[]={"Daal Makhni","Daal Makhni","Daal Makhni","Daal Makhni","Daal Makhni"};
    String foodType1[]={"North indian, Punjabi ,chinessem Sea Food,Thai, Italian","North indian, Punjabi ,chinessem Sea Food,Thai, Italian","North indian, Punjabi ,chinessem Sea Food,Thai, Italian","North indian, Punjabi ,chinessem Sea Food,Thai, Italian","North indian, Punjabi ,chinessem Sea Food,Thai, Italian"};
    String rupees[]={"Rs 300","Rs 300","Rs 300","Rs 300","Rs 300"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_popular, container, false);

        menuRecycler = view.findViewById(R.id.menuRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        menuRecycler.setLayoutManager(layoutManager);
        menuRecycler.setItemAnimator(new DefaultItemAnimator());

        homeListModelClassArrayList1 = new ArrayList<>();

        for (int i = 0; i < foodName.length; i++) {
            MenuModel2 beanClassForRecyclerView_contacts = new MenuModel2(foodName[i],foodType1[i],rupees[i]);
            homeListModelClassArrayList1.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new MenuAdapter2(getContext(),homeListModelClassArrayList1);
        menuRecycler.setAdapter(bAdapter);

        return view;

    }

}

