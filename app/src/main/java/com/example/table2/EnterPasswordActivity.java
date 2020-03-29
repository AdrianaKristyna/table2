package com.example.table2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        SharedPreferences settings = getSharedPreferences("PREFS",0);
        password=settings.getString("password","");

        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.loginBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = editText.getText().toString();

                if (text.equals(password)){

                    Intent intentOne=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intentOne);
                    finish();
                }else{
                    Toast.makeText(EnterPasswordActivity.this,"wrong password",Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
