package e.wolfsoft1.iyedelivery;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import java.util.ArrayList;
import e.wolfsoft1.Adapters.FoodAdapter;
import e.wolfsoft1.Adapters.RestaurantAdapter;
import e.wolfsoft1.ModelClasses.FoodModel;
import e.wolfsoft1.ModelClasses.RestaurantModel;


public class HomeActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    private DrawerLayout drawer;
    private Toolbar toolbar;

    private ArrayList<FoodModel> homeListModelClassArrayList;
    private RecyclerView recyclerView;
    private FoodAdapter mAdapter;

    private ArrayList<RestaurantModel> homeListModelClassArrayList2;
    private RecyclerView recyclerView1;
    private RestaurantAdapter rAdapter;

    Integer image[] = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4};
    String foodName[] = {"Fast Food", "Chineese", "Punjabi", "South Indian"};
    String totalRest[] = {"74 Restaurant", "34 Restaurant", "65 Restaurant", "37 Restaurant"};

    Integer foodImage[] = {R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food5};
    String ratings[] = {"4.5", "4.2", "4.3", "4.5"};
    String restaurantName[] = {"Angry Bird Restaurant", "Swagat Resaturant", "Enjoy Restaurant", "Hariyali Resaturant"};
    String restaurantCusines[] = {"Chineese,Punjabi,South Indian,Gujarati", "Chineese,Punjabi,South Indian,Gujarati", "Chineese,Punjabi,South Indian,Gujarati", "Chineese,Punjabi,South Indian,Gujarati"};
    String deliveryTime[] = {"20-30 min", "10-15 min", "40-45 min", "30-35 min"};
    String amount[] = {"300 Rs", "250 Rs", "280 Rs", "320 Rs"};
    String paymentMode[] = {"Online & COD", "Online & COD", "Online & COD", "Online & COD",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeActivity.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        homeListModelClassArrayList = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            FoodModel beanClassForRecyclerView_contacts = new FoodModel(image[i],foodName[i],totalRest[i]);
            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
        }
        mAdapter = new FoodAdapter(HomeActivity.this,homeListModelClassArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        recyclerView1 = (RecyclerView)findViewById(R.id.recyclerView1);
        homeListModelClassArrayList2 = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            RestaurantModel beanClassForRecyclerView_contacts = new RestaurantModel(ratings[i],restaurantName[i],restaurantCusines[i],deliveryTime[i],amount[i],paymentMode[i],foodImage[i]);

            homeListModelClassArrayList2.add(beanClassForRecyclerView_contacts);
        }
        rAdapter = new RestaurantAdapter(HomeActivity.this,homeListModelClassArrayList2);

        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(HomeActivity.this);
        recyclerView1.setLayoutManager(rLayoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(rAdapter);




        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setToolbar();


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);

        invalidateOptionsMenu();




    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(Gravity.LEFT); //OPEN Nav Drawer!
        }else {
            finish();
        }
    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle("");

        toolbar.findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("Click", "keryu");

                if (drawer.isDrawerOpen(navigationView)) {
                    drawer.closeDrawer(navigationView);
                } else {
                    drawer.openDrawer(navigationView);
                }
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

        }

}
