package com.example.food_bill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo_retrofit.R;

import java.util.ArrayList;

public class food_bill extends AppCompatActivity {

    EditText edid,edqty,edprice;
    TextView texttotal;
    RecyclerView recyclerView;
    Button btsave,btshowfood;
    food_Adapter adapter;

    ArrayList<food_data> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_bill);

        edid=findViewById(R.id.editText);
        edqty=findViewById(R.id.editText2);
        edprice=findViewById(R.id.editText3);
        texttotal=findViewById(R.id.textView12);
        btshowfood=findViewById(R.id.btshowfood);
        recyclerView=findViewById(R.id.recyclerView);


        btshowfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(food_bill.this,showfood_data.class);
                startActivity(intent);
            }
        });

        arrayList=new ArrayList<>();

        btsave=findViewById(R.id.btsave);
        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=edid.getText().toString();
                String price=edprice.getText().toString();
                String qty=edqty.getText().toString();
                String total=texttotal.getText().toString();

                Log.e("TAG", "onClick:=======>> "+id );
                Log.e("TAG", "onClick:=======>> "+price );
                Log.e("TAG", "onClick:=======>> "+qty );
                Log.e("TAG", "onClick:=======>> "+total );

                if (id.equals("") && price.equals("") && qty.equals("")&&total.equals("")){
                    Toast.makeText(food_bill.this, "Please Enter All data", Toast.LENGTH_SHORT).show();

                }else {

                    food_data data=new food_data(id,qty,price,total);
                    arrayList.add(data);

                    Log.e("TAG", "onClick::::::>> "+ arrayList );

                   adapter=  new food_Adapter(arrayList,getApplicationContext());

                   RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(food_bill.this);
                   recyclerView.setLayoutManager(layoutManager);
                   recyclerView.setItemAnimator(new DefaultItemAnimator());
                   recyclerView.setAdapter(adapter);
                }
            }
        });

        edqty.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                texttotal.setText(addNumbers());
            }

            public void afterTextChanged(Editable s) {
            }
        });

        edprice.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                texttotal.setText(addNumbers());

            }

            public void afterTextChanged(Editable s) {

            }
        });
    }

    private String addNumbers() {
        int number1;
        int number2;
        if(edqty.getText().toString() != "" && edqty.getText().length() > 0) {
            number1 = Integer.parseInt(edqty.getText().toString());
        } else {
            number1 = 0;
        }
        if(edprice.getText().toString() != "" && edprice.getText().length() > 0) {
            number2 = Integer.parseInt(edprice.getText().toString());
        } else {
            number2 = 0;
        }

        return Integer.toString(number1 * number2);
    }
}