package com.example.tutorial01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView txt;
    Button btn2, btn3;
    EditText editTxt1, editTxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.textView3);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");

        txt.setText(name);
    }

    public void OnClickBtn1(View view){
        editTxt1 = findViewById(R.id.editTxt1);
        editTxt2 = findViewById(R.id.editTxt2);

        String name = editTxt1.getText().toString();
        int age = Integer.parseInt(editTxt2.getText().toString());

        SharedPreferences shPre = getSharedPreferences("Details", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shPre.edit();
        editor.putString("name", name);
        editor.putInt("age", age);
        editor.commit();

        Toast toast = Toast.makeText(this, "Data Saved.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void OnClickBtn2(View view){
        SharedPreferences shPre = getSharedPreferences("Details", Context.MODE_PRIVATE);
        String name = shPre.getString("name", "no name");
        int age = shPre.getInt("age", 0);

        Toast toast = Toast.makeText(this, "Name: " + name +". Age: " + age, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickBtn3(View view){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}