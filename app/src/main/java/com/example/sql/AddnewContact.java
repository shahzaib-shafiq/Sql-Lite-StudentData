package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class AddnewContact extends AppCompatActivity {
    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    DbQuery dbQueries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        firstName = findViewById(R.id.edtfirstname);
        secondName = findViewById(R.id.edtsecondname);
        phoneNumber = findViewById(R.id.edtphonenumber);
        emailAddress = findViewById(R.id.edtemail);
        homeAddress = findViewById(R.id.edthomeaddress);
        dbQueries = new DbQuery(getApplicationContext());
    }
    public void SaveContact(View view) {
        HashMap<String,String> contact = new HashMap<String,String>();
        contact.put("firstName",firstName.getText().toString());
        contact.put("secondName",secondName.getText().toString());
        contact.put("phoneNumber",phoneNumber.getText().toString());
        contact.put("emailAddress",emailAddress.getText().toString());
        contact.put("homeAddress",homeAddress.getText().toString());
        dbQueries.AddContact(contact);
        Log.d("TAG","Contact added successfully");

    }
}