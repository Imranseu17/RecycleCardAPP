package com.example.user.recyclecarddemo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.recyclecarddemo.Entity.User_entity;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    User_entity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = (ImageView)findViewById(R.id.imageview);
        textView = (TextView)findViewById(R.id.textView);
        entity = (User_entity)getIntent().getSerializableExtra("Entity");
        imageView.setImageResource(entity.getImage());
        textView.setText(entity.getPersonName());






    }
}
