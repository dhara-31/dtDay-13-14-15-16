package com.example.demo_retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Search_Restaurant.all_restaurant;
import com.example.food_bill.food_bill;

public class restaurant extends AppCompatActivity {

    Button restaurant,btsearch,btfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        restaurant=findViewById(R.id.restaurant);

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(restaurant.this,retaurant_data.class);
                startActivity(intent);
            }
        });

        btsearch=findViewById(R.id.Btsearch);

        btsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent=new Intent(restaurant.this, all_restaurant.class);
                    startActivity(intent);
            }
        });

        btfood=findViewById(R.id.Btfood);

        btfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(restaurant.this, food_bill.class);
                startActivity(intent);

            }
        });
    }
}