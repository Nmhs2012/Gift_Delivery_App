package com.example.tutorial01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView txt;
    ImageButton image;

    private static final int Image = 10;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Toast toast = Toast.makeText(this, "Successful..", Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this, MainActivity2.class);
        String name = "Heshari...";

        intent.putExtra("NAME", name);
        startActivity(intent);
    }

    public void PickImage(View view){
        Intent intentPick = new Intent(Intent.ACTION_PICK);
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
        intentPick.setData(Uri.parse(path));
        intentPick.setType("image/*");

        Intent Chooser = Intent.createChooser(intentPick, "Select an image..");
        startActivityForResult(intentPick, Image);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        imageview = findViewById(R.id.imageView);

        if(resultCode == RESULT_OK && requestCode == Image){
            imageview.setImageURI(data.getData());
        }
    }
}