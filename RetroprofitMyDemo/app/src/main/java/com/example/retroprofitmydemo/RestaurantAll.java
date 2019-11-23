package com.example.retroprofitmydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retroprofitmydemo.retrofit.model.AllRestaurant;

import java.util.ArrayList;

import adapter.ResurantAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantAll extends Activity {
    RecyclerView recyclerView;
    APIInterface apiInterface;

    ArrayList<AllRestaurant.Datum> data;
    ResurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_all);
        recyclerView = (RecyclerView) findViewById(R.id.listresurant);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<AllRestaurant> call = apiInterface.restaurant();

        call.enqueue(new Callback<AllRestaurant>() {


            @Override
            public void onResponse(Call<AllRestaurant> call, Response<AllRestaurant> response) {

                if (response.isSuccessful()) {

                    data = new ArrayList<AllRestaurant.Datum>();
                    data = response.body().getData();

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantAll.this);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new ResurantAdapter(data, RestaurantAll.this);
                    recyclerView.setAdapter(adapter);

                } else
                    {
                    Toast.makeText(RestaurantAll.this, "Not Data Found......", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllRestaurant> call, Throwable t) {

            }
        });
    }
}










