package e.wolfsoft1.iyedelivery;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import e.wolfsoft1.Fragments.Home_Fragment;
import e.wolfsoft1.Fragments.Orders_Fragment;
import e.wolfsoft1.Fragments.Support_Fragment;
import e.wolfsoft1.Fragments.Wallet_Fragment;
import e.wolfsoft1.ViewPager.CustomViewPager;


public class Main_Handler_Activity extends AppCompatActivity implements Home_Fragment.OnFragmentInteractionListener,Orders_Fragment.OnFragmentInteractionListener,Wallet_Fragment.OnFragmentInteractionListener,Support_Fragment.OnFragmentInteractionListener {


    private static final String TAG = Main_Handler_Activity.class.getSimpleName();
    private Toolbar toolbar;
    CustomViewPager viewpager;
    MenuItem prevMenuItem;
    private ProgressDialog mProgressDialog;
    private BottomNavigationView bottomNavigationView;
    private PagerAdapter adapter;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        viewpager = (CustomViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        removeShiftMode(bottomNavigationView);

        viewpager.disableScroll(true);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                viewpager.setCurrentItem(0);
                                break;

                            case R.id.navigation_orders:
                                viewpager.setCurrentItem(1);
                                break;

                            case R.id.navigation_wallet:
                                viewpager.setCurrentItem(2);
                                break;

                            case R.id.navigation_support:
                                viewpager.setCurrentItem(3);
                                break;

                        }
                        return false;
                    }


                });


        //Add fragments
        adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home_Fragment());
        adapter.addFragment(new Orders_Fragment());
        adapter.addFragment(new Wallet_Fragment());
        adapter.addFragment(new Support_Fragment());

        viewpager.setOffscreenPageLimit(4);

        //Setting adapter
        viewpager.setAdapter(adapter);

        setUpNavDrawer();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    class PagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragments = new ArrayList<>();

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment) {
            mFragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

    }



    void setUpNavDrawer(){
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

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
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @SuppressLint("RestrictedApi")
    public static void removeShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }

        } catch (NoSuchFieldException e) {
            Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
        }
    }





}
