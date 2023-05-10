package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    DbQuery dbQueries;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbQueries = new DbQuery(getApplicationContext());
        listView = findViewById(R.id.lstmaincontactlist);

    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<HashMap<String,String>> contactList = dbQueries.getAllContacts();
        SimpleAdapter adapter = new SimpleAdapter(this,contactList,R.layout.sqlnewlayout, new String[]{"firstName","secondName","phoneNumber"},
                new int[]{R.id.txtfirstname,R.id.txtsecondname,R.id.txtphonenumber});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Position="+(position+1),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,EditContact.class);
                intent.putExtra("id",String.valueOf(position+1));
                startActivity(intent);
            }
        });

    }
    public void AddContact(View view) {
        Intent intent = new Intent(this, AddnewContact.class);
        startActivity(intent);
    }

}