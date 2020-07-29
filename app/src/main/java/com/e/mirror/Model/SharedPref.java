package com.e.mirror.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class SharedPref {

    public String user_name_key = "user_name_key";
    public String user_email_key = "user_email_key";
    public String user_phone_key = "user_phone_key";
    public String user_id_key = "user_id_key";
    public String latitude_key = "latitude_key";
    public String longitude_key = "longitude_key";
    public String gender_key = "gender_key";
    public String security_token_key = "security_token_key";
    public String user_role_key = "user_role_key";
    public String photo_key = "photo_key";
    public String is_active_key = "is_active_key";
    public String created_date_key = "created_date_key";
    public String updated_by_key = "updated_by_key";
    public String updated_date_key = "updated_date_key";
    public String forgot_date_key = "forgot_date_key";
    public String access_token_key = "access_token_key";


    public String PREFS_NAME = "PayNXS_resturant";
    public static final String LOGGED_IN_PREF = "PayNXS_resturant_login_status";

    ArrayList<String> arealist = new ArrayList<>();
    ArrayList<String> arealist_id = new ArrayList<>();

    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    public void set_profile(Context context, String user_name_key,
                            String user_email_key, String user_phone_key, String user_id_key,
                            String latitude_key, String longitude_key,
                            String gender_key, String security_token_key, String user_role_key,
                            String photo_key, String is_active_key, String created_date_key,
                            String updated_by_key, String updated_date_key, String forgot_date_key,
                            String access_token_key) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(user_name_key, user_name_key);
        editor.putString(user_email_key, user_email_key);
        editor.putString(user_phone_key, user_phone_key);
        editor.putString(user_id_key, user_id_key);
        editor.putString(latitude_key, latitude_key);
        editor.putString(longitude_key, longitude_key);
        editor.putString(gender_key, gender_key);
        editor.putString(security_token_key, security_token_key);
        editor.putString(user_role_key, user_role_key);
        editor.putString(photo_key, photo_key);
        editor.putString(is_active_key, is_active_key);
        editor.putString(created_date_key, created_date_key);
        editor.putString(updated_by_key, updated_by_key);
        editor.putString(updated_date_key, updated_date_key);
        editor.putString(forgot_date_key, forgot_date_key);
        editor.putString(access_token_key, access_token_key);


        editor.apply();

    }


    public String getuser_name_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(user_name_key, "");
    }

    public String getuser_phone_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(user_phone_key, "");
    }

    public String getuser_email_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(user_email_key, "");
    }

    public String getuser_id_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(user_id_key, "");
    }


    public String getlatitude_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(latitude_key, "");
    }

    public String getlongitude_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(longitude_key, "");
    }

    public String getsecurity_token_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(security_token_key, "");
    }

    public String getUser_role_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(user_role_key, "");
    }

    public String getPhoto_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(photo_key, "");
    }

    public String getIs_active_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(is_active_key, "");
    }

    public String getCreated_date_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(created_date_key, "");
    }

    public String getUpdated_date_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(updated_date_key, "");
    }

    public String getForgot_date_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(forgot_date_key, "");
    }

    public String getUpdated_by_key(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(updated_by_key, "");
    }


    public void setArea(Context context, ArrayList<String> dataa) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(dataa);
        editor.putStringSet("arealist_key", set);
        editor.apply();
    }

    public void setAreaid(Context context, ArrayList<String> dataa) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(dataa);
        editor.putStringSet("arealist_id_key", set);
        editor.apply();
    }

    public ArrayList<String> getArea(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        Set<String> set = sharedPref.getStringSet("arealist_key", null);
        arealist.addAll(set);

        return arealist;
    }

    public ArrayList<String> getArea_id(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        Set<String> set = sharedPref.getStringSet("arealist_id_key", null);
        arealist_id.addAll(set);

        return arealist_id;
    }


    public static void setLoggedIn(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.apply();

        Log.d("check_login..", "is.." + LOGGED_IN_PREF);
//        return loggedIn;
    }


    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false);
    }

    public void clear(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear().commit();

    }
}
