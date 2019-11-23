package com.example.retroprofitmydemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retroprofitmydemo.retrofit.model.ArrayModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArrayAll extends AppCompatActivity {

    TextView txtrest_id, txtuser_id, txtcontact, txtaddress, txtstatus, txtstart_time, txtend_time;
    APIInterface apIinterface;
    HashMap<String, String> t = new HashMap<String, String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_all_data);
        txtrest_id = findViewById(R.id.txtrest_id);
        txtuser_id = findViewById(R.id.txtuser_id);
        txtcontact = findViewById(R.id.txtcontact);
        txtaddress = findViewById(R.id.txtaddress);
        txtstatus = findViewById(R.id.txtstatus);
        txtstart_time = findViewById(R.id.txtstart_time);
        txtend_time = findViewById(R.id.txtend_time);

        apIinterface = APIClient.getClient().create(APIInterface.class);

        t.put("order[0][food_id]", "10");
        t.put("order[0][quantity]", "5");
        t.put("order[0][original_price]", "60");
        t.put("order[0][total_price]", "300");

        Call<ArrayModel> call;
        call = apIinterface.food_bill_data("7", "1", "1234567890", "Surat,India", "Order", "08:00 PM", "09:00 PM", t
                , "nice");

        call.enqueue(new Callback<ArrayModel>() {

            @Override
            public void onResponse(Call<ArrayModel> call, Response<ArrayModel> response) {
                Log.e("TAG", "onResponse:====>>>>>>>>>>>> " + response);

                ArrayModel food_resource = response.body();
                ArrayModel.Data data = food_resource.getData();
                txtrest_id.setText(data.getRestaurantId());
                Log.e("TAG", "onResponse::::::===> " + data.getRestaurantId());
                txtuser_id.setText(data.getUserId());
                Log.e("TAG", "onResponse::::::=====> " + data.getUserId());
                txtcontact.setText(data.getContactNo());
                txtaddress.setText(data.getAddress());
                txtstatus.setText(data.getStatus());
                txtstart_time.setText(data.getStartTime());
                txtend_time.setText(data.getEndTime());
            }

            @Override
            public void onFailure(Call<ArrayModel> call, Throwable t) {

            }
        });


    }
}
