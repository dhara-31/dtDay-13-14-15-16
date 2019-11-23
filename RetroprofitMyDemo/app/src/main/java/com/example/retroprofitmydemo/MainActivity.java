package com.example.retroprofitmydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retroprofitmydemo.retrofit.model.LoginModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {

    EditText edEmail, edPass;
    Button login;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edEmail = findViewById(R.id.email);
        edPass = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);

        apiInterface = APIClient.getClient().create(APIInterface.class);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = edEmail.getEditableText().toString().trim();

                final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


                if (isValidPassword(edPass.getText().toString()) && edPass.getText().toString().length() > 8 && email.matches(emailPattern) && email.length() > 0) {
                    Toast.makeText(getApplicationContext(), "valid email address and password", Toast.LENGTH_SHORT).show();
                } else {
                    if (!isValidPassword(edPass.getText().toString()) || edPass.getText().toString().length() < 8) {
                        edPass.setError("Invalid");
                    }
                    if (!email.matches(emailPattern) || email.length() < 0) {
                        edEmail.setError("Invalid");
                    }

                }


                Call<LoginModel> call = apiInterface.userlogin(edEmail.getText().toString(), edPass.getText().toString());

                call.enqueue(new Callback<LoginModel>() {


                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                        if (response.isSuccessful()) {

                            if (response.body().getResponseMessage().matches("success")) {

                                Log.e("TAG===>", "onResponse.....: "+response.body());

                                // Log.e("TAG===>", "onResponse.....: "+response.body().getData().getEmail());

                                Intent intent = new Intent(MainActivity.this, LayoutSet.class);
                                startActivity(intent);

                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {

                    }
                });
            }
        });
    }

    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();


    }

}
