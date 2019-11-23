package com.example.Search_Restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.demo_retrofit.APICilent;
import com.example.demo_retrofit.APIinterface;
import com.example.demo_retrofit.Model.All_Rest_Resource;
import com.example.demo_retrofit.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class restaurant_all_data extends AppCompatActivity {

    RecyclerView recyclerView;
    List<All_Rest_Resource.Datum> data;
    All_rest_adapter adapter;
    APIinterface apIinterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_all_data);

        recyclerView = findViewById(R.id.recyclerView);

        String value = getIntent().getStringExtra("value");
        Log.e("TAG", "onCreate: " + value);


        if (value.contains(",")) {
            String[] tem_val = value.split(",");
            Log.e("TAG", "onCreate:>>>>>> " + tem_val);
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < tem_val.length; i++) {

                list.add(Integer.parseInt(tem_val[i]));
                Log.e("TAG", "onCreat>>>> " + Integer.parseInt(tem_val[i]));
            }

            apIinterface = APICilent.getClient().create(APIinterface.class);
            Call<All_Rest_Resource> call = apIinterface.all_rest_data("21.2563", "72.5639", "12", list);
            call.enqueue(new Callback<All_Rest_Resource>() {
                @Override
                public void onResponse(Call<All_Rest_Resource> call, Response<All_Rest_Resource> response) {

                    if (response.isSuccessful()) {

                        data = new ArrayList<>();
                        Log.e("TAG", "on Response::::::>>>" + data);
                        data = response.body().getData();
                        Log.e("TAG", "all_dtaa&&&&&...." + data);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(restaurant_all_data.this);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setLayoutManager(layoutManager);
                        adapter = new All_rest_adapter(data, restaurant_all_data.this);
                        recyclerView.setAdapter(adapter);

                    } else {
                        Toast.makeText(restaurant_all_data.this, "Data is Faund", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<All_Rest_Resource> call, Throwable t) {

                    Log.e("TAG::::>>>>", "onFailure:::" + t.getLocalizedMessage());
                }
            });

        } else {
            Toast.makeText(this, "invalid Data", Toast.LENGTH_SHORT).show();

        }

    }
}