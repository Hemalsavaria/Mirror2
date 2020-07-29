package com.e.mirror;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Booking_details extends AppCompatActivity {

    Intent intent;
    String value;
    Button add_review, cancel_booking;
    TextView completed, pending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.toolbar_color));
        }

        intent = getIntent();
        value = intent.getStringExtra("value");

        Log.d("booking..", "value.." + value);

        init();
    }

    public void init() {

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        add_review = findViewById(R.id.add_review);
        add_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_review_dialog();
            }
        });

        cancel_booking = findViewById(R.id.cancel_booking);
        cancel_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel_booking();
            }
        });

        completed = findViewById(R.id.completed);
        pending = findViewById(R.id.pending);

        if (value.equals("1")) {

            completed.setVisibility(View.VISIBLE);
            add_review.setVisibility(View.VISIBLE);
            cancel_booking.setVisibility(View.GONE);
            pending.setVisibility(View.GONE);

        } else if (value.equals("2")) {
            completed.setVisibility(View.GONE);
            pending.setVisibility(View.VISIBLE);
            cancel_booking.setVisibility(View.VISIBLE);
            add_review.setVisibility(View.GONE);
        }
    }

    public void add_review_dialog() {
        final Dialog dialog = new Dialog(Booking_details.this, R.style.MyAlertDialogStyle);
        dialog.setContentView(R.layout.dialog_addreview);


        Button cancel = dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        Button done = dialog.findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void cancel_booking() {
        final Dialog dialog = new Dialog(Booking_details.this, R.style.MyAlertDialogStyle);
        dialog.setContentView(R.layout.dialog_cancel_booking);


        Button cancel = dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        Button done = dialog.findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
