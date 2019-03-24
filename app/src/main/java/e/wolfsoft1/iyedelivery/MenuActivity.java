package e.wolfsoft1.iyedelivery;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;

import e.wolfsoft1.Adapters.MenuAdapter2;
import e.wolfsoft1.Adapters.TabAdapter;
import e.wolfsoft1.ModelClasses.MenuModel2;

public class MenuActivity extends AppCompatActivity {


    private ArrayList<MenuModel2> homeListModelClassArrayList1;
    private RecyclerView menuRecycler;
    private MenuAdapter2 bAdapter;

    String foodType[] = {"Popular", "Soup", "Starter", "MainCourse", "Dessert", "Bevrages", "Salads"};
    String foodName[] = {"Daal Makhni", "Daal Makhni", "Daal Makhni", "Daal Makhni", "Daal Makhni"};
    String foodType1[] = {"North indian, Punjabi ,chinessem Sea Food,Thai, Italian", "North indian, Punjabi ,chinessem Sea Food,Thai, Italian", "North indian, Punjabi ,chinessem Sea Food,Thai, Italian", "North indian, Punjabi ,chinessem Sea Food,Thai, Italian", "North indian, Punjabi ,chinessem Sea Food,Thai, Italian"};
    String rupees[] = {"Rs 300", "Rs 300", "Rs 300", "Rs 300", "Rs 300"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TabLayout tabLayout = findViewById(R.id.tab);
        final ViewPager viewPager = findViewById(R.id.vp);

        tabLayout.setTabMode(tabLayout.MODE_SCROLLABLE);
        tabLayout.addTab(tabLayout.newTab().setText("Popular"));
        tabLayout.addTab(tabLayout.newTab().setText("Soup"));
        tabLayout.addTab(tabLayout.newTab().setText("Starter"));
        tabLayout.addTab(tabLayout.newTab().setText("Main Course"));
        tabLayout.addTab(tabLayout.newTab().setText("Dessert"));
        tabLayout.addTab(tabLayout.newTab().setText("Bevrages"));

        tabLayout.setTabGravity(TabLayout.MODE_FIXED);
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Black.ttf");
//
//
//
//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
//            //noinspection ConstantConditions
//            TextView tv=(TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
//            tv.setTypeface(font);
//            tabLayout.getTabAt(i).setCustomView(tv);
//
//        }


       /* menuRecycler = (RecyclerView) findViewById(R.id.menuRecycler);
        homeListModelClassArrayList1 = new ArrayList<>();

        for (int i = 0; i < foodName.length; i++) {
            MenuModel2 beanClassForRecyclerView_contacts = new MenuModel2(foodName[i], foodType1[i], rupees[i]);
            homeListModelClassArrayList1.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new MenuAdapter2(MenuActivity.this, homeListModelClassArrayList1);

        RecyclerView.LayoutManager bLayoutManager = new LinearLayoutManager(MenuActivity.this);
        menuRecycler.setLayoutManager(bLayoutManager);
        menuRecycler.setItemAnimator(new DefaultItemAnimator());
        menuRecycler.setAdapter(bAdapter);*/
    }
}
