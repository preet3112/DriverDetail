package com.example.driverdetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText textName,textID,textContact,textAddress;
    Button btnAdd;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        databaseHelper=new DatabaseHelper(this);
        textName=findViewById(R.id.text_Name);
         textID=findViewById(R.id.text_ID);
         textContact=findViewById(R.id.text_Contact);
          textAddress=findViewById(R.id.text_address);
        btnAdd=findViewById(R.id.btn_add);
        AddData();
    }
    public void AddData()

    {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textName.getText().toString().equals("") || textID.getText().toString().equals("") || textContact.getText().toString().equals("") || textAddress.getText().toString().equals("")) {
                    Toast.makeText(AddActivity.this, "All Feilds Are Mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isdataInserted = databaseHelper.insertData(textID.getText().toString(),
                            textName.getText().toString(),
                            textContact.getText().toString(),
                            textAddress.getText().toString());
                    if (isdataInserted == true) {
                        Toast.makeText(AddActivity.this, "Data Added Sucessfully", Toast.LENGTH_SHORT).show();
                        Intent main = new Intent(AddActivity.this, MainActivity.class);
                        startActivity(main);
                    } else {
                        Toast.makeText(AddActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

}
