package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class EditContact extends AppCompatActivity {
    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    DbQuery dbQueries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        dbQueries = new DbQuery(getApplicationContext());
        //Binding...
        firstName = findViewById(R.id.editfirstname);
        secondName = findViewById(R.id.editsecondname);
        phoneNumber = findViewById(R.id.editphonenumber);
        emailAddress = findViewById(R.id.editemailaddress);
        homeAddress = findViewById(R.id.edithomeaddress);
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        HashMap<String,String> singleContact = dbQueries.getSingleContact(id);
        Log.d("TAG","Updation");

        firstName.setText(singleContact.get("firstName"));
        secondName.setText(singleContact.get("secondName"));
        phoneNumber.setText(singleContact.get("phoneNumber"));
        emailAddress.setText(singleContact.get("emailAddress"));
        homeAddress.setText(singleContact.get("homeAddress"));
        dbQueries = new DbQuery(getApplicationContext());
    }
    public void UpdateRecord(View view) {
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        HashMap<String,String> updateContact = new HashMap<String, String>();
        updateContact.put("firstName",firstName.getText().toString());
        updateContact.put("secondName",secondName.getText().toString());
        updateContact.put("phoneNumber",phoneNumber.getText().toString());
        updateContact.put("emailAddress",emailAddress.getText().toString());
        updateContact.put("homeAddress",homeAddress.getText().toString());
        dbQueries.updateContact(updateContact,id);
        Log.d("TAG","Data Updated Successfully with ID="+id);
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void DeleteRecord(View view) {
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        dbQueries.deleteContact(id);
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
        Log.d("Chacha","Deleted with id = " +id);
    }

}