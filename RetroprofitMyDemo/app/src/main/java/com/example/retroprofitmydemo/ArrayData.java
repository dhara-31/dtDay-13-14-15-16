package com.example.retroprofitmydemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retroprofitmydemo.retrofit.model.TinyDB;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import model.OdrderDetail;

public class ArrayData extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;
    EditText editId, qty, price;
    Button show, btnTotalPrice, btnSpDetail;
    TextView showqp;
    Context context;

    private TinyDB tinyDB;

    private List<OdrderDetail> odrderDetailList = new ArrayList<>();
    private OdrderDetail OdrderDetail = new OdrderDetail();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_dta);
        activity = ArrayData.this;
        tinyDB = new TinyDB(activity);
        initView();
    }

    private void initView() {

        editId = (EditText) findViewById(R.id.editId);
        show = (Button) findViewById(R.id.viewIdData);
        btnTotalPrice = (Button) findViewById(R.id.btn_total_price);
        qty = (EditText) findViewById(R.id.qty);
        price = (EditText) findViewById(R.id.price);
        showqp = (TextView) findViewById(R.id.showqp);
        btnSpDetail = findViewById(R.id.btn_sp_detail);

        btnSpDetail.setOnClickListener(this);

        btnTotalPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        qty.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showqp.setText(addNumbers());

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showqp.setText(addNumbers());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private String addNumbers() {

        int number1;
        int number2;
        if (qty.getText().toString() != "" && qty.getText().length() > 0) {
            number1 = Integer.parseInt(qty.getText().toString());
        }
        else {
            number1 = 0;
        }


        if (price.getText().toString() != "" && price.getText().length() > 0) {
            number2 = Integer.parseInt(price.getText().toString());
        }
        else {
            number2 = 0;
        }


        return Integer.toString(number1 * number2);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_sp_detail:

                odrderDetailList = tinyDB.getOrderList("order_detail");
                OdrderDetail.setQuantity(qty.getText().toString());
                OdrderDetail.setPrice(price.getText().toString());
                OdrderDetail.setFoodId(editId.getText().toString());
                OdrderDetail.setTotal(showqp.getText().toString());
                odrderDetailList.add(OdrderDetail);
                tinyDB.putorderList("order_detail", odrderDetailList);

                Intent i = new Intent(this, Array_recycle.class);
                startActivity(i);
        }
    }
}