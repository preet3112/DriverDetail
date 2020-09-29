package com.example.driverdetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAddD= findViewById(R.id.btn_addD);
        Button btnUpdateD= findViewById(R.id.btn_updateD);
        Button btnDeleteD= findViewById(R.id.btn_deleteD);
        Button btnSelectD= findViewById(R.id.btn_selectD);
        //Add Data
        btnAddD.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent addI= new Intent(MainActivity.this,AddActivity.class);
                startActivity(addI);
            }
        });

        btnUpdateD.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent updateI= new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(updateI);
            }
        });

        btnDeleteD.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent deleteI= new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(deleteI);
            }
        });

        btnSelectD.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent selectI= new Intent(MainActivity.this,SelectActivity.class);
                startActivity(selectI);
            }
        });



    }
}