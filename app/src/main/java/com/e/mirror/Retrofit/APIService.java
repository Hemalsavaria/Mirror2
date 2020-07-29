package com.e.mirror.Retrofit;

import com.e.mirror.Model.Result;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Belal on 14/04/17.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("email") String contact_number,
            @Field("password") String password,
            @Field("access_token") String access_token
    );


    @FormUrlEncoded
    @POST("forgotpassword")
    Call<Result> forgotpassword(
            @Field("email_id") String email
    );

    @FormUrlEncoded
    @POST("changepassword")
    Call<Result> changepassword(
            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("current_password") String current_password,
            @Field("new_password") String new_password
    );


    @FormUrlEncoded
    @POST("signup")
    Call<Result> userSignup(
            @Field("name") String first_name,
            @Field("phone") String contact_number,
            @Field("email") String email,
            @Field("password") String password,
            @Field("gender") String gender,
            @Field("access_token") String access_token
    );

    @FormUrlEncoded
    @POST("get_category")
    Call<Result> get_category(
            @Header("Authorization") String token,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("get_city")
    Call<Result> get_city(
            @Field("app_id") String app_id
    );

    @FormUrlEncoded
    @POST("get_ads")
    Call<Result> get_ads(
            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("cat_id") String cat_id,
            @Field("city_id") String city_id,
            @Field("view_type") String view_type
    );

    @FormUrlEncoded
    @POST("get_business_profile")
    Call<Result> get_business_profile(
            @Header("Authorization") String token,
            @Field("user_id") String user_id

    );

    @FormUrlEncoded
    @POST("edit_business_profile")
    Call<Result> edit_business_profile(

            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("business_name") String business_name,
            @Field("business_about") String business_about,
            @Field("business_contact") String business_contact,
            @Field("business_email") String business_email,
            @Field("business_website") String business_website,
            @Field("business_address") String business_address,
            @Field("city_id") String city_id,
            @Field("cat_id") String cat_id
//            @Field("business_profile_image") String business_profile_image
    );

    @POST("edit_business_profile")
    Call<Result> edit_business_profile_image(
            @Header("Authorization") String token,
            @Body RequestBody file);

    @FormUrlEncoded
    @POST("save_ads")
    Call<Result> save_ads(
            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("post_id") String post_id

    );
    @FormUrlEncoded
    @POST("delete_ads")
    Call<Result> delete_ads(
            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("post_id") String post_id

    );

    @POST("edit_profile")
    Call<Result> editprofile(
            @Header("Authorization") String token,
            @Body RequestBody file


    );

    @FormUrlEncoded
    @POST("add_new_ad")
    Call<Result> add_new_ad(

            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("ads_business_name") String ads_business_name,
            @Field("ads_title") String ads_title,
            @Field("ads_description") String ads_description,
            @Field("ads_contact_number") String ads_contact_number,
            @Field("ads_email") String ads_email,
            @Field("ads_website") String ads_website,
            @Field("ads_address") String ads_address,
            @Field("ads_current_offer") String ads_current_offer,
            @Field("count_image") String count_image,
            @Field("city_id") String city_id,
            @Field("cat_id") String cat_id
    );

    @POST("add_new_ad")
    Call<Result> add_new_ad_image(
            @Header("Authorization") String token,
            @Body RequestBody file);

    @FormUrlEncoded
    @POST("edit_ad")
    Call<Result> edit_ad(

            @Header("Authorization") String token,
            @Field("post_id") String post_id,
            @Field("user_id") String user_id,
            @Field("ads_business_name") String ads_business_name,
            @Field("ads_title") String ads_title,
            @Field("ads_description") String ads_description,
            @Field("ads_contact_number") String ads_contact_number,
            @Field("ads_email") String ads_email,
            @Field("ads_website") String ads_website,
            @Field("ads_address") String ads_address,
            @Field("ads_current_offer") String ads_current_offer,
            @Field("count_image") String count_image,
            @Field("city_id") String city_id,
            @Field("cat_id") String cat_id
    );

    @POST("edit_ad")
    Call<Result> edit_ad_image(
            @Header("Authorization") String token,
            @Body RequestBody file);



    @FormUrlEncoded
    @POST("delete_ad_image")
    Call<Result> delete_ad_image(
            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("ads_image_id") String ads_image_id

    );
    @FormUrlEncoded
    @POST("user_save_ads_list")
    Call<Result> user_save_ads_list(
            @Header("Authorization") String token,
            @Field("user_id") String user_id

    );

    @FormUrlEncoded
    @POST("remove_save_ads")
    Call<Result>  remove_save_ads(
            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("user_save_id") String user_save_id

    );


    @FormUrlEncoded
    @POST("get_business_profile_by_id")
    Call<Result>  get_business_profile_by_id(
            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("user_business_id") String user_business_id

    );

    @FormUrlEncoded
    @POST("add_feedback")
    Call<Result>  add_feedback(
            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("rating") String rating,
            @Field("comment") String comment

    );

    @FormUrlEncoded
    @POST("get_feedback_list")
    Call<Result>  get_feedback_list(
            @Header("Authorization") String token,
            @Field("user_id") String user_id

    );
    @FormUrlEncoded
    @POST("get_all_business_profile")
    Call<Result>  get_all_business_profile(
            @Header("Authorization") String token,
            @Field("user_id") String user_id

    );

    @FormUrlEncoded
    @POST("delete_user_feedback")
    Call<Result>  delete_user_feedback(
            @Header("Authorization") String token,
            @Field("user_id") String user_id,
            @Field("feedback_id") String feedback_id

    );

}
