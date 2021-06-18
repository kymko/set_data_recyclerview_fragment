package com.example.fragmenthomework;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondFragment extends Fragment implements IOnBackPressed{
    TextView txtHeader;
    TextView txtDesc;
    ImageView imageView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mHeader;
    private String mDescription;
    private int mImage;


    public SecondFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String header,String description,int img) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, header);
        args.putString(ARG_PARAM2, description);
        args.putInt(ARG_PARAM3, img);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHeader = getArguments().getString(ARG_PARAM1);;
            mDescription = getArguments().getString(ARG_PARAM2);
            mImage = getArguments().getInt(ARG_PARAM3);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

       txtHeader = view.findViewById(R.id.txt1_header);
       txtDesc = view.findViewById(R.id.txt2_desc);
       imageView = view.findViewById(R.id.img1_second);
       txtHeader.setText(mHeader);
       txtDesc.setText(mDescription);
       imageView.setImageResource(mImage);


        return view;
    }

    @Override
    public boolean onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
        return true;
    }
}