package com.e.mirror.Model;

import com.google.gson.annotations.SerializedName;

public class Profile_data {

    @SerializedName("user_name")
    private String user_name;


    @SerializedName("user_id")
    private String user_id;


    @SerializedName("email")
    private String email;


    @SerializedName("contact_no")
    private String contact_no;


    @SerializedName("user_role")
    private String user_role;


    @SerializedName("lat")
    private String lat;

    @SerializedName("created_date")
    private String created_date;

    @SerializedName("lon")
    private String lon;

    @SerializedName("gender")
    private String gender;


    @SerializedName("photo")
    private String photo;


    @SerializedName("is_active")
    private String is_active;


    @SerializedName("updated_by")
    private String updated_by;

    @SerializedName("updated_date")
    private String updated_date;

    @SerializedName("forgot_date")
    private String forgot_date;

    @SerializedName("access_token")
    private String access_token;

    @SerializedName("security_token")
    private String security_token;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getForgot_date() {
        return forgot_date;
    }

    public void setForgot_date(String forgot_date) {
        this.forgot_date = forgot_date;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getSecurity_token() {
        return security_token;
    }

    public void setSecurity_token(String security_token) {
        this.security_token = security_token;
    }
}
