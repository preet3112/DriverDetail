package com.example.driverdetail;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    ArrayList<String> listItem;
    ArrayAdapter adapter;
    DatabaseHelper db;
    ListView driverList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverlist);
        db=new DatabaseHelper(this);
        listItem=new ArrayList<>();
        driverList=findViewById(R.id.list_view);
        vieWData();

    }

    private void vieWData() {
        Cursor cursor =db.viewData();

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        }
        else {
            StringBuffer buffer=new StringBuffer();
            while (cursor.moveToNext()){
                buffer.append("ID :" +cursor.getString(0)+"\n");
                buffer.append("Name :" +cursor.getString(1)+"\n");
                buffer.append("Contact :" +cursor.getString(2)+"\n");
                buffer.append("Address :" +cursor.getString(3)+"\n");

            }
            listItem.add(buffer.toString());

            adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listItem);
            driverList.setAdapter(adapter);
        }
    }
}
