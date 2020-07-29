package com.e.mirror.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.e.mirror.ChangePassword;
import com.e.mirror.Contactus;
import com.e.mirror.EditProfile;
import com.e.mirror.Favourite;
import com.e.mirror.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    BottomNavigationView bottom_navigation;

    RelativeLayout toolbar_1, toolbar_2;
    TextView title, profile_edit;
    ImageView back;

    LinearLayout contact_us, favourite, change_password;

    String spinner_Language_data[] = {"English", "Arabic"};

    Spinner spinner_Language;

    public Profile() {
    }


    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
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
        View itemview = inflater.inflate(R.layout.fragment_profile, container, false);

        toolbar_1 = getActivity().findViewById(R.id.toolbar_1);
        toolbar_2 = getActivity().findViewById(R.id.toolbar_2);
        toolbar_1.setVisibility(View.GONE);
        toolbar_2.setVisibility(View.VISIBLE);

        back = getActivity().findViewById(R.id.back);
        toolbar_2.setBackgroundColor((Color.parseColor("#00308B")));

        back.setImageResource(R.drawable.ic_back_arrow_white);
        title = getActivity().findViewById(R.id.toolbar_title_fragment);
        title.setText("Profile");
        title.setTextColor((Color.parseColor("#ffffff")));


        init(itemview);
        return itemview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bottom_navigation = getActivity().findViewById(R.id.bottom_navigation);
        bottom_navigation.getMenu().findItem(R.id.profile).setChecked(true);

    }

    public void init(View itemview2) {
        profile_edit = itemview2.findViewById(R.id.profile_edit);
        profile_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), EditProfile.class));
            }
        });

        contact_us = itemview2.findViewById(R.id.contact_us);
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), Contactus.class));
            }
        });

        favourite = itemview2.findViewById(R.id.favourite);
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), Favourite.class));
            }
        });

        change_password = itemview2.findViewById(R.id.change_password);
        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), ChangePassword.class));
            }
        });


        spinner_Language = itemview2.findViewById(R.id.spinner_Language);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, spinner_Language_data);
        spinner_Language.setAdapter(adapter);


//        back.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                onResume();
//                }
//        });
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