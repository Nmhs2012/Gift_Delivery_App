package com.example.tutorial01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity4 extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        String days[] = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.textView4, days);

        listView = findViewById(R.id.Listview2);
        listView.setAdapter(adapter);

        


    }
}