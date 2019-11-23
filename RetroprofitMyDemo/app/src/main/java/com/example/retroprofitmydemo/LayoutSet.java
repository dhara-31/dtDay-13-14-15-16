package com.example.retroprofitmydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LayoutSet extends AppCompatActivity {


    Button res , findData , arrayData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lauout_button);
        res=(Button) findViewById(R.id.resallData);
        findData=(Button) findViewById(R.id.findData);
        arrayData=(Button) findViewById(R.id.arrray);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LayoutSet.this,RestaurantAll.class);
                startActivity(intent);

            }
        });

        findData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LayoutSet.this,SplitRestaurant.class);
                startActivity(intent);

            }
        });

        arrayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LayoutSet.this,ArrayData.class);
                startActivity(intent);

            }
        });


    }
}
