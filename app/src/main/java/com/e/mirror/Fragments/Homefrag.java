package com.e.mirror.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.e.mirror.R;
import com.e.mirror.Saloon_details;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homefrag extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    BottomNavigationView bottom_navigation;
    TextView male, female, title;
    boolean login_name = false;

    RelativeLayout toolbar_1, toolbar_2;

    CardView salon;

    public Homefrag() {

    }

    public static Homefrag newInstance(String param1, String param2) {
        Homefrag fragment = new Homefrag();
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
        View itemview = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar_1 = getActivity().findViewById(R.id.toolbar_1);
        toolbar_2 = getActivity().findViewById(R.id.toolbar_2);
        title = getActivity().findViewById(R.id.toolbar_title_fragment);
        title.setText("Home");

        toolbar_1.setVisibility(View.VISIBLE);
        toolbar_2.setVisibility(View.VISIBLE);

        male = itemview.findViewById(R.id.male);
        female = itemview.findViewById(R.id.female);
        female.setBackgroundResource(R.drawable.roundwhite_lightblue_10);
        female.setTextColor(getResources().getColor(R.color.white));

        male.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                login_name = true;

                Log.d("Main2...", "log_in_name..2" + login_name);

                male.setBackgroundResource(R.drawable.roundwhite_10);


                male.setTextColor(getResources().getColor(R.color.black));

                female.setBackgroundColor(android.R.color.transparent);

                female.setTextColor(getResources().getColor(R.color.white));


            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                login_name = false;

                Log.d("Main2...", "log_in_name..2" + login_name);


                female.setBackgroundResource(R.drawable.roundwhite_10);

                female.setTextColor(getResources().getColor(R.color.black));

                male.setBackgroundColor(android.R.color.transparent);

                male.setTextColor(getResources().getColor(R.color.white));


            }
        });

        init(itemview);
        return itemview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bottom_navigation = getActivity().findViewById(R.id.bottom_navigation);
        bottom_navigation.getMenu().findItem(R.id.home).setChecked(true);

    }

    public void init(View itemview2) {
        salon = itemview2.findViewById(R.id.salon);
        salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), Saloon_details.class));
            }
        });


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

                    Intent a = new Intent(Intent.ACTION_MAIN);
                    a.addCategory(Intent.CATEGORY_HOME);
                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(a);
                    return true;
                }
                return false;
            }
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }

}