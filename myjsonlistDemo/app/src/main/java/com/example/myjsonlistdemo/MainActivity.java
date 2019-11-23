package com.example.myjsonlistdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<JsonModel.ResultData> addMyList = new ArrayList<>();
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = findViewById(R.id.main_list);

        adapter = new JsonAdapter(getApplicationContext(), addMyList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);

        new GetContacts().execute();

    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Data is Downloading", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler httpHandler = new HttpHandler();
            String url = "https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJyUOKgvBO4DsRYelJPVly_SU&key=AIzaSyBvVkvSSftJdfmzPfIFIcY4JNx2UW7hj4g";
            String jsonstr = httpHandler.makeServiceCall(url);

            if (jsonstr != null) {

                try {

                    JSONObject jsonObject = new JSONObject(jsonstr);
                    JSONObject result = jsonObject.getJSONObject("result");
                    JSONArray address = result.getJSONArray("address_components");

                    for (int i = 0; i < address.length(); i++) {

                        JSONObject c = address.getJSONObject(i);

                        JsonModel.ResultData jsonModel = new JsonModel.ResultData();

                        jsonModel.setLong_name(c.getString("long_name"));
                        jsonModel.setShort_name(c.getString("short_name"));

                        JSONObject location = result.getJSONObject("geometry");
                        JSONObject l = location.getJSONObject("location");

                        jsonModel.setLat(l.getString("lat"));
                        jsonModel.setLng(l.getString("lng"));

                       JSONArray types = c.getJSONArray("types");

                        if (types.toString().length() != 0) {

                            ArrayList<String> typeList = new ArrayList<String>();
                            for (int j = 0; j < types.length(); j++) {
                                typeList.add((String) types.get(j));
                            }
                            jsonModel.setTypes(typeList);
                        }

                     jsonModel.setIcon(result.getString("icon"));
                        jsonModel.setVicinity(result.getString("vicinity"));

                        addMyList.add(jsonModel);

                    }

                } catch (final JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            JsonAdapter adapter = new JsonAdapter(MainActivity.this, addMyList);
            mList.setAdapter(adapter);
        }

    }
}



