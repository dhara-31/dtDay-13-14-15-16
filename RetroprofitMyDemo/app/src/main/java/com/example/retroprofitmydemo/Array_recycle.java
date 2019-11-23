package com.example.retroprofitmydemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retroprofitmydemo.retrofit.model.TinyDB;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import adapter.CustomAdapter;
import model.OdrderDetail;

public class Array_recycle extends AppCompatActivity {

    ListView r1;
    private TinyDB tinyDB;
    List<OdrderDetail> list = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_recycle);
        r1 = (ListView) findViewById(R.id.list);

        tinyDB = new TinyDB(getApplicationContext());
        list = tinyDB.getOrderList("order_detail");

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), list);
        r1.setAdapter(customAdapter);


    }
}




