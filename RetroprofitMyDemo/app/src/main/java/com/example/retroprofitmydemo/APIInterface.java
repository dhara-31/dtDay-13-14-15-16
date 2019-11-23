package com.example.retroprofitmydemo;

import com.example.retroprofitmydemo.retrofit.model.AllRestaurant;
import com.example.retroprofitmydemo.retrofit.model.ArrayModel;
import com.example.retroprofitmydemo.retrofit.model.LoginModel;
import com.example.retroprofitmydemo.retrofit.model.SlpitRestaurantModel;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @FormUrlEncoded
    @POST("user_login")
    Call<LoginModel> userlogin(@Field("email") String email, @Field("password") String password);

    @GET("user_order_detail/38")
    Call<AllRestaurant> restaurant();

    @FormUrlEncoded
    @POST("all_restaurant")
    Call<SlpitRestaurantModel> all_rest_data(@Field("latitude") String latitude,
                                             @Field("longitude") String longitude,
                                             @Field("user_id") String user_id,
                                             @Field("kitchen[]") ArrayList<Integer> kitchen);

    @FormUrlEncoded
    @POST("order_detail")
    Call<ArrayModel> food_bill_data(@Field("restaurant_id") String rest_id,
                                    @Field("user_id") String user_id,
                                    @Field("contact_no") String contact,
                                    @Field("address") String address,
                                    @Field("status") String status,
                                    @Field("start_time") String start_time,
                                    @Field("end_time") String end_time,
                                    @FieldMap Map<String, String> ids,
                                    @Field("comment") String comment);


}
