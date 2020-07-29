package com.e.mirror.Fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.e.mirror.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Notification extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    BottomNavigationView bottom_navigation;

    RelativeLayout toolbar_1, toolbar_2;
    TextView title;
    ImageView back;
    public Notification() {
    }



    public static Notification newInstance(String param1, String param2) {
        Notification fragment = new Notification();
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
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview = inflater.inflate(R.layout.fragment_notification, container, false);


        toolbar_1 = getActivity().findViewById(R.id.toolbar_1);
        toolbar_2 = getActivity().findViewById(R.id.toolbar_2);
        toolbar_1.setVisibility(View.GONE);
        toolbar_2.setVisibility(View.VISIBLE);

        back = getActivity().findViewById(R.id.back);
        toolbar_2.setBackgroundColor((Color.parseColor("#ffffff")));

        back.setImageResource(R.drawable.ic_back_arrow);
        title = getActivity().findViewById(R.id.toolbar_title_fragment);
        title.setText("Notification");
        title.setTextColor(Color.parseColor("#000000"));



//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                onResume();
//            }
//        });

        return  itemview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bottom_navigation = getActivity().findViewById(R.id.bottom_navigation);
        bottom_navigation.getMenu().findItem(R.id.notification).setChecked(true);

    }
    @Override
    public void onResume() {
        super.onResume();

        if (getView() == null) {
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    // handle back button's click listener
                    return true;
                }
                return false;
            }
        });
    }


}