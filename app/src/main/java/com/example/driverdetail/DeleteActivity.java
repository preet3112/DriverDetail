package com.example.driverdetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {

    EditText textID;
    Button btnDelete;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        textID=findViewById(R.id.txt_driverID);
        btnDelete=findViewById(R.id.btn_delete);
        mydb=new DatabaseHelper(this);
        deleteDetails();

    }

    private void deleteDetails() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textID.getText().toString().equals("")) {
                    Toast.makeText(DeleteActivity.this, "Please Enter Driver ID", Toast.LENGTH_SHORT).show();
                } else {
                    Integer dataDeleted = mydb.deleteData(textID.getText().toString());
                    if (dataDeleted > 0) {
                        Toast.makeText(DeleteActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        Intent main = new Intent(DeleteActivity.this, MainActivity.class);
                        startActivity(main);
                    } else {
                        Toast.makeText(DeleteActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
