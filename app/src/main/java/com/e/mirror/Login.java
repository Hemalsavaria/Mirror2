package com.e.mirror;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.e.mirror.Model.Result;
import com.e.mirror.Model.SharedPref;
import com.e.mirror.Retrofit.APIService;
import com.e.mirror.Retrofit.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    Button login_button, login_guest_button;
    LinearLayout go_to_signup;
    TextView login_forgot_password;


    EditText login_email, login_password;
    String TAG = "login..";
    SharedPref sharedPref = new SharedPref();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
        init();

        check_login();
    }

    public void go_to_signup(View v) {
        startActivity(new Intent(Login.this, Signup.class));
    }

    public void init() {

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);

        login_forgot_password = findViewById(R.id.login_forgot_password);
        login_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ForgotPassword.class));
            }
        });

        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Homepage.class));
            }
        });

        login_guest_button = findViewById(R.id.login_guest_button);
        login_guest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Homepage.class));
            }
        });
    }

    public void LoginMethod() {


        String email_data = login_email.getText().toString();
        String password_data = login_password.getText().toString();


        Log.d(TAG, "email_data.." + email_data);
        Log.d(TAG, "password_data.." + password_data);


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<Result> call = service.userLogin(email_data, password_data, "123456");

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();

                if (response.body() != null) {

                    if (response.body().getSuccess()) {


                        SharedPref.setLoggedIn(getApplicationContext(), true);

                        if (response.body().getData() != null) {


//                            Log.d(TAG, "restaurant_user_name_response.." + restaurant_user_name_response);

                            startActivity(new Intent(Login.this, Homepage.class));
                            finish();

                        } else {


                            Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                        }


                    } else {
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(Login.this, "Something went wrong please try again", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

    public void check_login() {
        if (sharedPref.getLoggedStatus(Login.this) == true) {

            boolean check = sharedPref.getLoggedStatus(Login.this);

            Log.d(TAG, "check_login.is.." + check);

            startActivity(new Intent(Login.this, Homepage.class));
            finish();
//            Toast.makeText(this, SaveSharedPreference.getLoggedStatus(Login.this)+"", Toast.LENGTH_LONG).show();

        } else {


        }
    }
}
