package com.example.retroprofitmydemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplitRestaurant extends AppCompatActivity {

    EditText edtext;
    Button btok;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.split_rest);
        edtext = findViewById(R.id.editText);
        btok = findViewById(R.id.submitButton);

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edtext.getText().toString();

                if (!value.isEmpty()) {
                    Intent intent = new Intent(SplitRestaurant.this, SplitRestAll.class);

                    intent.putExtra("value", value);

                    startActivity(intent);
                    Toast.makeText(SplitRestaurant.this, "Data ", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SplitRestaurant.this, "Please Enter Data", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
