package com.example.table2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.buttonList1);
        Button button2 = findViewById(R.id.buttonList2);
        Button button3 = findViewById(R.id.buttonList3);
        Button button4 = findViewById(R.id.buttonList4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button1Intent = new Intent(MainActivity.this, List1.class);
                startActivity(button1Intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button2Intent = new Intent(getApplicationContext(), List2.class);
                startActivity(button2Intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button3Intent = new Intent(MainActivity.this, List3.class);
                startActivity(button3Intent);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button4Intent = new Intent(MainActivity.this, List4.class);
                startActivity(button4Intent);
            }
        });
    }


}