package com.e.mirror;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.e.mirror.Fragments.Calender;
import com.e.mirror.Fragments.Homefrag;
import com.e.mirror.Fragments.Notification;
import com.e.mirror.Fragments.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Homepage extends AppCompatActivity {
    TextView male, female;
    boolean login_name = false;
    BottomNavigationView bottomNavigation;
    RelativeLayout toolbar_1, toolbar_2;
    ImageView filter_home ,sorting_home;
    BottomSheetDialog mBottomSheetDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.toolbar_color));
        }
        init();


    }

    public void init() {
        toolbar_1 = findViewById(R.id.toolbar_1);
        toolbar_2 = findViewById(R.id.toolbar_2);
        filter_home = findViewById(R.id.filter_home);
        sorting_home = findViewById(R.id.sorting_home);

        toolbar_1.setVisibility(View.VISIBLE);
        toolbar_2.setVisibility(View.GONE);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(Homefrag.newInstance("", ""));

        login_name = false;

        filter_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_dialog();
            }
        });

        sorting_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomsheet();
            }
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.calender:
                            openFragment(Calender.newInstance("", ""));
                            return true;
                        case R.id.home:
                            openFragment(Homefrag.newInstance("", ""));
                            return true;
                        case R.id.notification:
                            openFragment(Notification.newInstance("", ""));
                            return true;
                        case R.id.profile:
                            openFragment(Profile.newInstance("", ""));
                            return true;

                        default:
                            openFragment(Homefrag.newInstance("", ""));

                    }
                    return false;
                }
            };


    @Override
    public void onResume() {
//        openFragment(Homefrag.newInstance("", ""));
        super.onResume();
    }

    public void filter_dialog() {
        final Dialog dialog = new Dialog(Homepage.this, R.style.MyAlertDialogStyle);
        dialog.setContentView(R.layout.dialog_filter);


        Button done = dialog.findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void bottomsheet() {

        mBottomSheetDialog = new BottomSheetDialog(Homepage.this);
        View sheetView = getLayoutInflater().inflate(R.layout.bottomsheet_sorting, null);
        mBottomSheetDialog.setContentView(sheetView);


        mBottomSheetDialog.show();
    }

}
