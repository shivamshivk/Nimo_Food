package e.wolfsoft1.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import e.wolfsoft1.Adapters.OrderAdapter1;
import e.wolfsoft1.Adapters.OrderAdapter2;
import e.wolfsoft1.ModelClasses.Food;
import e.wolfsoft1.ModelClasses.Main_Order;
import e.wolfsoft1.iyedelivery.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Orders_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Orders_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Orders_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView order_list_view;
    private View rootView;
    private List<Main_Order> main_orders=new ArrayList<>();

    public Orders_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Orders_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Orders_Fragment newInstance(String param1, String param2) {
        Orders_Fragment fragment = new Orders_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_orders_, container, false);

        order_list_view = rootView.findViewById(R.id.order_list_view);

        List<Food> foods1 = new ArrayList<>();
        foods1.add(new Food("Panner Butter Masala","150","1"));
        List<Food> foods2 = new ArrayList<>();
        foods2.add(new Food("Palak Paneer","140","1"));
        List<Food> foods3 = new ArrayList<>();
        foods3.add(new Food("Paneer Masala","120","1"));
        List<Food> foods4 = new ArrayList<>();
        foods4.add(new Food("Panner Chilly","180","1"));

        main_orders.add(new Main_Order(R.drawable.food1,"150","Ordered On 12th Jan'19",foods1,true));
        main_orders.add(new Main_Order(R.drawable.food2,"140","Ordered On 15th Jan'19",foods2,true));
        main_orders.add(new Main_Order(R.drawable.food3,"120","Ordered On 26th Jan'19",foods3,true));
        main_orders.add(new Main_Order(R.drawable.food4,"180","Ordered On 08th Feb'19",foods4,true));

        OrderAdapter1 orderAdapter1 = new OrderAdapter1(getActivity(),main_orders);

        RecyclerView.LayoutManager bLayoutManager = new LinearLayoutManager(getContext());
        order_list_view.setLayoutManager(bLayoutManager);
        order_list_view.setItemAnimator(new DefaultItemAnimator());
        order_list_view.setAdapter(orderAdapter1);

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
