package com.example.retroprofitmydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retroprofitmydemo.retrofit.model.SlpitRestaurantModel;

import java.util.ArrayList;
import java.util.List;

import adapter.SplitAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplitRestAll extends AppCompatActivity {

    RecyclerView recyclerView;
    List<SlpitRestaurantModel.Datum> data;
    SplitAdapter adapter;
    APIInterface apIinterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.split_rest_all);
        recyclerView = (RecyclerView) findViewById(R.id.split_recy);

        String value = getIntent().getStringExtra("value");
        // Log.e("TAG", "onCreate: " + value);

        if (value.contains(",")) {
            String[] tem_val = value.split(",");
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < tem_val.length; i++) {

                list.add(Integer.parseInt(tem_val[i]));
            }

            apIinterface = APIClient.getClient().create(APIInterface.class);
            Call<SlpitRestaurantModel> call = apIinterface.all_rest_data("21.2563", "72.5639", "12", list);

            call.enqueue(new Callback<SlpitRestaurantModel>() {
                @Override
                public void onResponse(Call<SlpitRestaurantModel> call, Response<SlpitRestaurantModel> response) {

                    if (response.isSuccessful()) {

                        data = new ArrayList<>();
                        data = response.body().getData();
                        // Log.e("TAG", "all_dtaa&&&&&...." + data);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SplitRestAll.this);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setLayoutManager(layoutManager);
                        adapter = new SplitAdapter(data, SplitRestAll.this);
                        recyclerView.setAdapter(adapter);

                    } else {
                        Toast.makeText(SplitRestAll.this, "Data is Faund", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SlpitRestaurantModel> call, Throwable t) {


                    // Log.e("TAG::::>>>>", "onFailure:::" + t.getLocalizedMessage());
                }
            });
        } else {
            Toast.makeText(this, "invalid Data", Toast.LENGTH_SHORT).show();

        }


    }
}






 /*  // use of sharedpreference array list put and get

               SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPrefs.edit();
                Gson gson = new Gson();

                String json = gson.toJson(qtyList);

                editor.putString("data", json);
                editor.commit();*/




    /*

    get shraedpr

    SharedPreferences sharedPrefs1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    Gson gson1 = new Gson();
    String json1 = sharedPrefs1.getString("data", "");
    Type type = new TypeToken<List<String>>() {}.getType();
    List<String> arrayList = gson1.fromJson(json1, type);

        Log.e("pooja", "onClick: size-->"+arrayList.size());

                for (int i = 0; i < arrayList.size(); i++) {
        Log.e("pooja", "onClick: i-->"+ arrayList.get(i));
        }*/


/*

                    // use of TiniDb class in one arrayList
                TinyDB t = new TinyDB(getApplicationContext());
                t.putListString("data",qtyList);
                ArrayList<String> a= t.getListString("data");*/



