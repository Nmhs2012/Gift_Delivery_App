package com.example.tutorial01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String countries[] = new String[]{"Sri Lanka", "India", "England", "USA", "Australia", "Canada", "Japan", "China", "Maldives"};

        ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, countries);

        listView = findViewById(R.id.list_view);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = String.valueOf(parent.getItemAtPosition(position));

                Toast toast = Toast.makeText(MainActivity3.this, country, Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }


}