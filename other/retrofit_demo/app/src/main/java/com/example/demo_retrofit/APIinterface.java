package com.example.demo_retrofit;

import com.example.demo_retrofit.Model.All_Rest_Resource;
import com.example.demo_retrofit.Model.jsonResource;
import com.example.demo_retrofit.Model.rest_resource;
import com.example.food_bill.Food_resource;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIinterface
{

    @FormUrlEncoded
    @POST("user_login")
    Call<jsonResource> userlogin(@Field("email") String email, @Field("password") String password);


    @GET("user_order_detail/38")
    Call<rest_resource> restaurant();

    @FormUrlEncoded
    @POST("all_restaurant")
    Call<All_Rest_Resource> all_rest_data(@Field("latitude") String latitude,
                                          @Field("longitude") String longitude,
                                          @Field("user_id") String user_id,
                                          @Field("kitchen[]")ArrayList<Integer> kitchen);


    @FormUrlEncoded
    @POST("order_detail")
    Call<Food_resource> food_bill_data(@Field("restaurant_id")String rest_id,
                                       @Field("user_id")String user_id,
                                       @Field("contact_no") String contact,
                                       @Field("address")String address,
                                       @Field("status") String status,
                                       @Field("start_time") String start_time,
                                       @Field("end_time")String end_time,
                                       @Field("order[0][food_id]")String food_id,
                                       @Field("order[0][quantity]")String qt,
                                       @Field("order[0][original_price]")String price,
                                       @Field("order[0][total_price]")String total,
                                       @Field("order[1][food_id]")String foodid,
                                       @Field("order[1][quantity]")String qty,
                                       @Field("order[1][original_price]")String food_price,
                                       @Field("order[1][total_price]")String food_total,
                                       @Field("comment")String comment);
}