package com.example.fragmenthomework;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentFirst extends Fragment implements myAdapter.ItemClickListener {

    ImageView imageView;
    TextView txtHeader;
    TextView txtDesc;
    ArrayList<dataModel> dataholder = new ArrayList<>();


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentFirst() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentFirst newInstance() {
        FragmentFirst fragment = new FragmentFirst();
        Bundle args = new Bundle();
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
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        imageView = view.findViewById(R.id.img1);
        txtHeader = view.findViewById(R.id.txt1);
        txtDesc = view.findViewById(R.id.txt2);
        initRcyclerView(view);
        buildListData();
        return view;
    }
    private void initRcyclerView(View view){
       RecyclerView recyclerView = view.findViewById(R.id.rec_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter adapter = new myAdapter(dataholder, (myAdapter.ItemClickListener) this);
        recyclerView.setAdapter(adapter);
    }

    private void buildListData(){
        dataModel ob1 = new dataModel(R.drawable.angular, "Angular", "Web Application");
        dataholder.add(ob1);

        dataModel ob2 = new dataModel(R.drawable.cp, "C Programming", "Embed Programming");
        dataholder.add(ob2);

        dataModel ob3 = new dataModel(R.drawable.cpp, "C++ Programming", "Embed Programming");
        dataholder.add(ob3);

        dataModel ob4 = new dataModel(R.drawable.dotnet, ".NET Programming", "Desktop and Web Programming");
        dataholder.add(ob4);

        dataModel ob5 = new dataModel(R.drawable.java, "Java Programming", "Desktop and Web Programming");
        dataholder.add(ob5);

        dataModel ob6 = new dataModel(R.drawable.magento, "Magento", "Web Application Framework");
        dataholder.add(ob6);

        dataModel ob7 = new dataModel(R.drawable.nodejs, "NodeJS", "Web Application Framework");
        dataholder.add(ob7);

        dataModel ob8 = new dataModel(R.drawable.python, "Python", "Desktop and Web Programming");
        dataholder.add(ob8);

        dataModel ob9 = new dataModel(R.drawable.shopify, "Shopify", "E-Commerce Framework");
        dataholder.add(ob9);

        dataModel ob10 = new dataModel(R.drawable.wordpress, "Wordpress", "WebApplication Framewrok");
        dataholder.add(ob10);
    }


    @Override
    public void onItemClick(dataModel dataModel) {
        Fragment fragment = SecondFragment.newInstance(dataModel.getHeader(),dataModel.getDesc(),dataModel.getImage());
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
       transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("first_fragment"));
      transaction.add(R.id.contayner,fragment);
      transaction.addToBackStack("second_fragment");
      transaction.isAddToBackStackAllowed();
        transaction.commit();
    }
}