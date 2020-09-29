package com.example.driverdetail;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity  extends AppCompatActivity {


    EditText textUPName,textUPID,textUPContact,textUPAddress;
    Button btnUpdate,btnSearch;
    DatabaseHelper databaseHelper;
    LinearLayout linearLayout1,linearLayout2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        databaseHelper=new DatabaseHelper(this);
        textUPName=findViewById(R.id.text_UPname);
        textUPID=findViewById(R.id.text_UPId);
        textUPContact=findViewById(R.id.text_upContact);
        textUPAddress=findViewById(R.id.text_upaddress);
        btnUpdate=findViewById(R.id.btn_update);
        btnSearch=findViewById(R.id.btn_search);


        updatEData();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor =databaseHelper.viewData();

                if(cursor.getCount() == 0){
                    Toast.makeText(UpdateActivity.this, "No data to show", Toast.LENGTH_SHORT).show();
                }
                else {
                    StringBuffer buffer=new StringBuffer();
                    while (cursor.moveToNext()){
                        buffer.append("ID :" +cursor.getString(0)+"\n");
                        buffer.append("Name :" +cursor.getString(1)+"\n");
                        buffer.append("Contact :" +cursor.getString(2)+"\n");
                        buffer.append("Address :" +cursor.getString(3)+"\n");
                        if(textUPID.getText().toString().equals(cursor.getString(0))){
                            textUPName.setText(cursor.getString(1));
                            textUPContact.setText(cursor.getString(2));
                            textUPAddress.setText(cursor.getString(3));
                        }

                    }


                }

            }
        });
    }

    private void updatEData() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textUPName.getText().toString().equals("") || textUPID.getText().toString().equals("") || textUPContact.getText().toString().equals("") || textUPAddress.getText().toString().equals("")) {
                    Toast.makeText(UpdateActivity.this, "All Feilds Are Mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isdataUpdated = databaseHelper.updateData(textUPID.getText().toString(),
                            textUPName.getText().toString(),
                            textUPContact.getText().toString(),
                            textUPAddress.getText().toString());
                    if (isdataUpdated == true) {
                        Toast.makeText(UpdateActivity.this, "Data Updated Sucessfully", Toast.LENGTH_SHORT).show();
                        Intent main = new Intent(UpdateActivity.this, MainActivity.class);
                        startActivity(main);
                    } else {
                        Toast.makeText(UpdateActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
    private void vieWData() {

    }
}
