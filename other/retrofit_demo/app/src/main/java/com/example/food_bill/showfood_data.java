package com.example.food_bill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.demo_retrofit.APICilent;
import com.example.demo_retrofit.APIinterface;
import com.example.demo_retrofit.Model.rest_resource;
import com.example.demo_retrofit.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class showfood_data extends AppCompatActivity {

    TextView txtrest_id,txtuser_id,txtcontact,txtaddress,txtstatus,txtstart_time,txtend_time;
    RecyclerView recyclerView;
    APIinterface apIinterface;
    showfooddata_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showfood_data);

        txtrest_id=findViewById(R.id.txtrest_id);
        txtuser_id=findViewById(R.id.txtuser_id);
        txtcontact=findViewById(R.id.txtcontact);
        txtaddress=findViewById(R.id.txtaddress);
        txtstatus=findViewById(R.id.txtstatus);
        txtstart_time=findViewById(R.id.txtstart_time);
        txtend_time=findViewById(R.id.txtend_time);
        recyclerView=findViewById(R.id.recyclerView);

        apIinterface= APICilent.getClient().create(APIinterface.class);

        Call<Food_resource> call=apIinterface.food_bill_data( "7","1","1234567890","Surat, India","Order","08:00 PM","09:00 PM",
                "10","5","60","300","11","1","20","20","nice");
        call.enqueue(new Callback<Food_resource>() {
            @Override
            public void onResponse(Call<Food_resource> call, Response<Food_resource> response) {

                Log.e("TAG", "onResponse:====>>>>>>>>>>>> "+response );

                    Food_resource food_resource = response.body();
                    Food_resource.Data data = food_resource.getData();
                    txtrest_id.setText(data.getRestaurantId());
                    Log.e("TAG", "onResponse::::::===> " + data.getRestaurantId());
                    txtuser_id.setText(data.getUserId());
                    Log.e("TAG", "onResponse::::::=====> " + data.getUserId());
                    txtcontact.setText(data.getContactNo());
                    txtaddress.setText(data.getAddress());
                    txtstatus.setText(data.getStatus());
                    txtstart_time.setText(data.getStartTime());
                    txtend_time.setText(data.getEndTime());

                        /* adapter=  new showfooddata_adapter(arrayList,getApplicationContext());

                         */             /* order=new ArrayList<Food_resource.Order>();

                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(showfood_data.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapter);*/

                List<Food_resource.Order> foodorder = response.body().getData().getOrder();
                Log.e("TAG", "onResponse::::::::>>>> " + foodorder.size());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(showfood_data.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                adapter = new showfooddata_adapter(foodorder, showfood_data.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Food_resource> call, Throwable t) {

                Log.e("TAG", "onFailure: "+t.getLocalizedMessage() );

            }
        });
    }
}