package com.example.food;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.demo_retrofit.R;
import com.example.demo_retrofit.Model.rest_resource;

import java.util.ArrayList;


public class Food_detail extends AppCompatActivity {

    RecyclerView food_view;
    ArrayList<rest_resource.FoodDetail> food_data;
    food_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        food_view=findViewById(R.id.recyclerview1);


        food_view.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        food_view.setLayoutManager(layoutManager);
        food_data= (ArrayList<rest_resource.FoodDetail>) getIntent().getExtras().getSerializable("data");
        adapter=new food_adapter(food_data, getApplicationContext());
        food_view.setAdapter(adapter);
    }

}