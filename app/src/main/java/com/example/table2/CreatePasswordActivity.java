package com.example.table2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

      editText1=(EditText)findViewById(R.id.userName);
      editText2=(EditText)findViewById(R.id.password);
      button_enter=(Button)findViewById(R.id.loginBtn);

      button_enter.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String text1=editText1.getText().toString();
              String text2=editText2.getText().toString();

              if (text1.equals("")||text2.equals("")){
                  Toast.makeText(CreatePasswordActivity.this,"No password entered",Toast.LENGTH_LONG);

              }else{if (text2.equals(text1)){
                  SharedPreferences settings=getSharedPreferences("PREFS",0);
                  SharedPreferences.Editor editor= settings.edit();
                  editor.putString("password",text1);
                  editor.apply();

                  Intent intentOne=new Intent(getApplicationContext(),MainActivity.class);
                  startActivity(intentOne);
                  finish();


              }else {
                  Toast.makeText(CreatePasswordActivity.this,"password doesnt match",Toast.LENGTH_LONG);
              }
              }
          }
      });
    }
}
