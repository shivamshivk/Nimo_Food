package e.wolfsoft1.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import e.wolfsoft1.Adapters.Home_Adapter;
import e.wolfsoft1.ModelClasses.Home;
import e.wolfsoft1.iyedelivery.HomeActivity;
import e.wolfsoft1.iyedelivery.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Home_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Home_Fragment() {
        // Required empty public constructor
    }

    private LinearLayout nimo_food;
    private LinearLayout nimo_flight;
    private LinearLayout nimo_cab;
    private LinearLayout nimo_wallet;
    private RecyclerView recyclerView;
    private View rootView;
    private ViewPager viewPager;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_Fragment newInstance(String param1, String param2) {
        Home_Fragment fragment = new Home_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private List<Home> homeList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home_, container, false);

        viewPager = getActivity().findViewById(R.id.viewpager);

        recyclerView = rootView.findViewById(R.id.home_r_view);
        homeList.add(new Home(R.drawable.food1,R.drawable.food2,"10 % Offer on Italian Food. Order Food and get it . Special**","10 % Offer on Chinese Food. Order Food asap","Food Offers"));
        homeList.add(new Home(R.drawable.food1,R.drawable.food2,"10 % Offer on Italian Food. Order Food and get it . Special**","10 % Offer on Chinese Food. Order Food asap","Food Offers"));
        homeList.add(new Home(R.drawable.food1,R.drawable.food2,"10 % Offer on Italian Food. Order Food and get it . Special**","10 % Offer on Chinese Food. Order Food asap","Food Offers"));

        Home_Adapter home_adapter = new Home_Adapter(getActivity(),homeList);
        RecyclerView.LayoutManager bLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(bLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(home_adapter);

        recyclerView.setNestedScrollingEnabled(false);

        nimo_food = rootView.findViewById(R.id.food_nimo);
        nimo_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),HomeActivity.class));
            }
        });

        nimo_cab = rootView.findViewById(R.id.cab_nimo);
        nimo_cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Work In Progress..", Toast.LENGTH_SHORT).show();
            }
        });

        nimo_flight = rootView.findViewById(R.id.flight_nimo);
        nimo_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Work In Progress..", Toast.LENGTH_SHORT).show();
            }
        });

        nimo_wallet = rootView.findViewById(R.id.wallet_nimo);
        nimo_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
