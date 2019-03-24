package e.wolfsoft1.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import e.wolfsoft1.iyedelivery.PopularFragment;

/**
 * Created by A on 16-03-2018.
 */

public class TabAdapter extends FragmentStatePagerAdapter {
    int mnumoftabs;

    public TabAdapter(FragmentManager fm, int numoftabs) {
        super(fm);
        this.mnumoftabs = numoftabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PopularFragment tab1 = new PopularFragment();
                return tab1;
            case 1:
                PopularFragment tab2 = new PopularFragment();
                return tab2;

            case 2:
                PopularFragment tab3 = new PopularFragment();
                return tab3;
            case 3:
                PopularFragment tab4 = new PopularFragment();
                return tab4;

            case 4:
                PopularFragment tab5 = new PopularFragment();
                return tab5;
            case 5:
                PopularFragment tab6 = new PopularFragment();
                return tab6;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mnumoftabs;
    }
}
