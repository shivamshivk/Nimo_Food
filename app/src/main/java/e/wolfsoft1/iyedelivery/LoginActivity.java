package e.wolfsoft1.iyedelivery;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import e.wolfsoft1.Adapters.ProfilePagerAdapter_walkthrough_01;
import me.relex.circleindicator.CircleIndicator;

public class LoginActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ProfilePagerAdapter_walkthrough_01 profilePagerAdapterWalkthrough01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         viewPager = (ViewPager) findViewById(R.id.viewPager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        profilePagerAdapterWalkthrough01 = new ProfilePagerAdapter_walkthrough_01(getSupportFragmentManager());

        viewPager.setAdapter(profilePagerAdapterWalkthrough01);

        indicator.setViewPager(viewPager);

        profilePagerAdapterWalkthrough01.registerDataSetObserver(indicator.getDataSetObserver());


    }
}
