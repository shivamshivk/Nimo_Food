package e.wolfsoft1.iyedelivery.wallet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import e.wolfsoft1.iyedelivery.R;

/**
 * Created by Rp on 8/30/2016.
 */
public class Fragment_First extends Fragment {

    private View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);



        return view;

    }
    }
