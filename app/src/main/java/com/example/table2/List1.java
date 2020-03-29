package com.example.table2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class List1 extends AppCompatActivity implements View.OnClickListener {

    Button plus;
    Button minus;
    TextView productValue;
    TextView productPrice;
    TextView productCategori;
    public int count2;
    TextView productValue1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);
        final TextView priceCategori = findViewById(R.id.priceCategori);
        final TextView productValue = findViewById(R.id.productValue1);
        final TextView productPrice = findViewById(R.id.priceProduct);
        productValue1 = findViewById(R.id.productValue1);

//        SharedPreferences SharedPreff=getSharedPreferences("Group1",Context.MODE_PRIVATE);
//        String value=SharedPreff.getString("noName","");
//        priceCategori.setText(value);
//


//        SharedPreferences SharedPref2=getSharedPreferences("Group2",Context.MODE_PRIVATE);
//        String value0=SharedPref2.getString("noVal1","");
//        productValue1.setText(value0);
//        String value2 = SharedPreff2.getString("noVal2", "");
//        productValue1.setText(value2);
//        String value3 = SharedPreff2.getString("noVal3", "");
//        productValue3.setText(value3);




        Button btnPlus1 = findViewById(R.id.plus1);
        Button btnPlus2 = findViewById(R.id.plus2);
        Button btnPlus3 = findViewById(R.id.plus3);
        Button btnPlus4 = findViewById(R.id.plus4);
        Button btnPlus5 = findViewById(R.id.plus5);
        Button btnMin1 = findViewById(R.id.min1);
        Button btnMin2 = findViewById(R.id.min2);
        Button btnMin3 = findViewById(R.id.min3);
        Button btnMin4 = findViewById(R.id.min4);
        Button btnMin5 = findViewById(R.id.min5);

        btnPlus1.setOnClickListener(this);
        btnPlus2.setOnClickListener(this);
        btnPlus3.setOnClickListener(this);
        btnPlus4.setOnClickListener(this);
        btnPlus5.setOnClickListener(this);
        btnMin1.setOnClickListener(this);
        btnMin2.setOnClickListener(this);
        btnMin3.setOnClickListener(this);
        btnMin4.setOnClickListener(this);
        btnMin5.setOnClickListener(this);

//        priceCategori.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//                SharedPreferences SharedPref=getSharedPreferences("Group1",Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor=SharedPref.edit();
//                editor.putString("noName",priceCategori.getText().toString());
//                editor.apply();
//                Toast.makeText(List1.this,"saved",Toast.LENGTH_LONG).show();
//
//            }
//        });
    }

    @Override
    public void onClick(View v) {


        final TextView productValue2 = findViewById(R.id.productValue2);
        final TextView productValue3 = findViewById(R.id.productValue3);
        final TextView productValue4 = findViewById(R.id.productValue4);
        final TextView productValue5 = findViewById(R.id.productValue5);
        final TextView priceProduct1 = findViewById(R.id.priceProduct);
        final TextView priceProduct2 = findViewById(R.id.priceProduct2);
        final TextView priceProduct3 = findViewById(R.id.priceProduct3);
        final TextView priceProduct4 = findViewById(R.id.priceProduct4);
        final TextView priceProduct5 = findViewById(R.id.priceProduct5);



        SharedPreferences SharedPref2=getSharedPreferences("Group2",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=SharedPref2.edit();
        editor.putString("NoVal1",productValue1.getText().toString());
//        editor.putString("NoVal2",productValue2.getText().toString());
//        editor.putString("NoVal3",productValue3.getText().toString());
        editor.apply();
        String values=SharedPref2.getString("noVal1","");
//        productValue1.setText(values);
        Toast.makeText(List1.this,values,Toast.LENGTH_LONG).show();


        switch (v.getId()) {


            case R.id.plus1:

                plusMethod(priceProduct1.getText().toString());
                count2 = Integer.parseInt(productValue1.getText().toString());
                productValue1.setText(String.valueOf(count2 + 1));
                break;
            case R.id.plus2:
                plusMethod(priceProduct2.getText().toString());
                count2 = Integer.parseInt(productValue2.getText().toString());
                productValue2.setText(String.valueOf(count2 + 1));
                break;
            case R.id.plus3:
                plusMethod(priceProduct3.getText().toString());
                count2 = Integer.parseInt(productValue3.getText().toString());
                productValue3.setText(String.valueOf(count2 + 1));
                break;
            case R.id.plus4:
                plusMethod(priceProduct4.getText().toString());
                count2 = Integer.parseInt(productValue4.getText().toString());
                productValue4.setText(String.valueOf(count2 + 1));
                break;
            case R.id.plus5:
                plusMethod(priceProduct5.getText().toString());
                count2 = Integer.parseInt(productValue5.getText().toString());
                productValue5.setText(String.valueOf(count2 + 1));
                break;
        }

        switch (v.getId()) {

            case R.id.min1:
                count2 = Integer.parseInt(productValue1.getText().toString());
                if(count2 != 0){
                productValue1.setText(String.valueOf(count2 - 1));
                minMethod(priceProduct1.getText().toString());}
                break;
            case R.id.min2:
                count2 = Integer.parseInt(productValue2.getText().toString());
                if(count2 != 0){
                    productValue2.setText(String.valueOf(count2 - 1));
                    minMethod(priceProduct2.getText().toString());}
                break;
            case R.id.min3:
                count2 = Integer.parseInt(productValue3.getText().toString());
                if(count2 != 0){
                    productValue3.setText(String.valueOf(count2 - 1));
                    minMethod(priceProduct3.getText().toString());}
                break;
            case R.id.min4:
                count2 = Integer.parseInt(productValue4.getText().toString());
                if(count2 != 0){
                    productValue4.setText(String.valueOf(count2 - 1));
                    minMethod(priceProduct4.getText().toString());}
                break;
            case R.id.min5:
                count2 = Integer.parseInt(productValue5.getText().toString());
                if(count2 != 0){
                    productValue5.setText(String.valueOf(count2 - 1));
                    minMethod(priceProduct5.getText().toString());}
                break;
        }
    }

    public void plusMethod(String price) {

        final TextView priceCategori = findViewById(R.id.priceCategori);
        final TextView productPrice = findViewById(R.id.priceProduct);

        if (priceCategori.equals("0")) {
            priceCategori.setText(productPrice.getText().toString());
        } else {
            int valueCategori = Integer.parseInt(priceCategori.getText().toString());
            int valuePrice = Integer.parseInt(price);
            int categoriFinal = valueCategori + valuePrice;
            priceCategori.setText(String.valueOf(categoriFinal));
            Toast.makeText(List1.this, String.valueOf("hotovo"), Toast.LENGTH_LONG).show();

        }
    }

    public void minMethod(String price) {
        final TextView priceCategori = findViewById(R.id.priceCategori);
        final TextView productPrice = findViewById(R.id.priceProduct);

        if (priceCategori.equals("0")) {

        } else if (Integer.parseInt(priceCategori.getText().toString()) < Integer.parseInt(productPrice.getText().toString())) {
            priceCategori.setText("0");
        } else {
            int valueCategori = Integer.parseInt(priceCategori.getText().toString());
            int valuePrice = Integer.parseInt(price);
            int categoriFinal = valueCategori - valuePrice;
            priceCategori.setText(String.valueOf(categoriFinal));
            Toast.makeText(List1.this, String.valueOf("hotovo"), Toast.LENGTH_LONG).show();

        }

    }


}



    /*
       plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (priceCategori.equals("0")) {
                    priceCategori.setText(productPrice.getText().toString());
                } else {
                    int valueCategori = Integer.parseInt(priceCategori.getText().toString());
                    int valuePrice = Integer.parseInt(productPrice.getText().toString());
                    int categoriFinal = valueCategori + valuePrice;
                    priceCategori.setText(String.valueOf(categoriFinal));
                    Toast.makeText(List1.this, String.valueOf("hotovo"), Toast.LENGTH_LONG).show();
                    int count2=Integer.parseInt(productValue.getText().toString());
                    count2=count2+1;
                    productValue.setText(String.valueOf(count2));
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (priceCategori.equals("0")) {

                } else if (Integer.parseInt(priceCategori.getText().toString()) < Integer.parseInt(productPrice.getText().toString())) {
                    priceCategori.setText("0");
                } else {
                    int valueCategori = Integer.parseInt(priceCategori.getText().toString());
                    int valuePrice = Integer.parseInt(productPrice.getText().toString());
                    int categoriFinal = valueCategori - valuePrice;
                    priceCategori.setText(String.valueOf(categoriFinal));
                    int count2=Integer.parseInt(productValue.getText().toString());
                    count2=count2-1;
                    productValue.setText(String.valueOf(count2));
                    Toast.makeText(List1.this, String.valueOf("hotovo"), Toast.LENGTH_LONG).show();

                }

            }
        });*/



