package com.example.demo_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.widget.Toast;

import com.example.demo_retrofit.Model.rest_resource;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class retaurant_data extends AppCompatActivity {


    ArrayList<rest_resource.Datum> data;
    restaurant_adapter adapter;
    RecyclerView recyclerView;
    APIinterface apIinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retaurant_data);

        recyclerView = findViewById(R.id.recyclerview);
        apIinterface = APICilent.getClient().create(APIinterface.class);

             Call<rest_resource> call = apIinterface.restaurant();
             Log.e("TAG---->", "onCreate:::" + call);

        call.enqueue(new Callback<rest_resource>() {
            @Override
            public void onResponse(Call<rest_resource> call, Response<rest_resource> response) {

                Log.e("TAG====>", "onResponse:::" + response.message());

                if (response.isSuccessful()) {

                    data = new ArrayList<rest_resource.Datum>();
                    data=response.body().getData();
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(retaurant_data.this);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new restaurant_adapter(data, retaurant_data.this);
                    recyclerView.setAdapter(adapter);

                } else {
                    Toast.makeText(retaurant_data.this, "Not Data Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<rest_resource> call, Throwable t) {

                Log.e("TAG---->", "onFailure:::: " + t.getLocalizedMessage());
            }
        });
    }
}