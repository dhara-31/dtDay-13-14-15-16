package com.example.Search_Restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo_retrofit.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class all_restaurant extends AppCompatActivity {

    EditText edtext;
    Button btok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_restaurant);

        edtext=findViewById(R.id.eddata);
        btok=findViewById(R.id.btok);

        Selection.setSelection(edtext.getText(), edtext.getText().length());

        edtext.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(final Editable s) {
                edtext.removeTextChangedListener(this);
                if (s.length()==1) {
                    s.append(',');

                }
                /*try {
                    //Log.d("Percentage", "input: " + s);
                    if(Integer.parseInt(s.toString()) == 2)
                        s.replace(0, s.length(), "2,");
                }
                catch(NumberFormatException nfe){

                }*/

               // edtext.removeTextChangedListener(this);

               /* try {
                    String originalString = s.toString();

                    Long longval;
                    if (originalString.contains(",")) {
                        originalString = originalString.replaceAll(",", "");
                    }
                    longval = Long.parseLong(originalString);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                    formatter.applyPattern("#,#");
                    String formattedString = formatter.format(longval);

                    //setting text after format to EditText
                    edtext.setText(formattedString);
                    edtext.setSelection(edtext.getText().length());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                edtext.addTextChangedListener(this);
*/
                }

        });



            btok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String value=edtext.getText().toString();

                    if (!value.isEmpty())
                    {
                        Intent intent=new Intent(all_restaurant.this,restaurant_all_data.class);
                        intent.putExtra("value",value);

                        startActivity(intent);
                        Toast.makeText(all_restaurant.this, "Data ", Toast.LENGTH_SHORT).show();

                }
                 else {
                    Toast.makeText(all_restaurant.this, "Please Enter Data", Toast.LENGTH_SHORT).show();
                }

                }
            });

    }
}