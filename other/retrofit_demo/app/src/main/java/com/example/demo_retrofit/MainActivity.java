package com.example.demo_retrofit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo_retrofit.Model.jsonResource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

EditText edEmail,edPass;
Button login;
APIinterface apIinterface;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail=findViewById(R.id.edEmail);
        edPass=findViewById(R.id.edPass);
        login=findViewById(R.id.Login);

        SharedPreferences sharedPreferences=getSharedPreferences("Data",MODE_PRIVATE);
        String email=sharedPreferences.getString("email","");
        String pass=sharedPreferences.getString("password", "");

        apIinterface=APICilent.getClient().create(APIinterface.class);

        if (!email.equals(""))

        {
            Log.e("TAG===", "onCreate:>>>> "+email );
            Log.e("TAG===", "onCreate:>>>> "+pass );
            startActivity(new Intent(MainActivity.this,restaurant.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<jsonResource> call=apIinterface.userlogin(edEmail.getText().toString(),edPass.getText().toString());

                call.enqueue(new Callback<jsonResource>() {
                    @Override
                    public void onResponse(Call<jsonResource> call, Response<jsonResource> response) {

                       Log.e("TAG=====>", "onResponse: " + response.message());

                        if (response.isSuccessful()){
                            Log.e("TAG=====>", "----------" + response.body().getResponseMessage());
                            if (response.body().getResponseMessage().matches("success")) {

                                Log.e("TAG=====>", "22222222" + response.message());

                                SharedPreferences.Editor editor=getSharedPreferences("Data",MODE_PRIVATE).edit();
                                editor.putString("email",edEmail.getText().toString());
                                editor.putString("password",edPass.getText().toString());
                                editor.apply();

                                Log.e("TAG=====>", "************************" + response.message());
                               /* Log.e("TAG===>", "onResponse: "+response.body().getData().getCountry());
                                Log.e("TAG===>", "onResponse: "+response.body().getData().getName());
                                Log.e("TAG===>", "onResponse: "+response.body().getData().getEmail());
                                Log.e("TAG===>", "onResponse: "+response.body().getData().getPassword());
                                Log.e("TAG===>", "onResponse: "+response.body().getData().getCity());*/

                                    String email=null;
                                    String uPassword=null;

                                Toast.makeText(MainActivity.this, "Data is show", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(MainActivity.this,restaurant.class);
                                startActivity(intent);

                            }
                            else {
                                Toast.makeText(MainActivity.this, "Invalid User", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Log.e("TAG", "invalid user: " );
                            Toast.makeText(MainActivity.this, "Enter your Email OR Password ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<jsonResource> call, Throwable t) {

                        Log.e("TAG---->", "onFailure: "+t.getLocalizedMessage());

                    }
                });
            }
        });
    }
}