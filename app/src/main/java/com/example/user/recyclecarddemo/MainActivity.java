package com.example.user.recyclecarddemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.user.recyclecarddemo.Entity.User_entity;
import com.example.user.recyclecarddemo.adapter.RecycleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleAdapter.onItemClick {
    private RecyclerView recyclerView;
    private ArrayList<User_entity> users;
    private ArrayList<Bitmap> image;
    private  RecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        users = new ArrayList<>();
        image = new ArrayList<Bitmap>();
        users.add(new User_entity("Cse"));
        image.add(BitmapFactory.decodeResource(getResources(), R.drawable.cse));
        users.add(new User_entity("EEE"));
        image.add(BitmapFactory.decodeResource(getResources(), R.drawable.eee));
        users.add(new User_entity("BBA"));
        image.add(BitmapFactory.decodeResource(getResources(), R.drawable.bba));
        users.add(new User_entity("ETE"));
        image.add(BitmapFactory.decodeResource(getResources(), R.drawable.ete));
        users.add(new User_entity("English"));
        image.add(BitmapFactory.decodeResource(getResources(), R.drawable.english));
        users.add(new User_entity("Bangla"));
        image.add(BitmapFactory.decodeResource(getResources(), R.drawable.bangla));
        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new RecycleAdapter(users,image);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClick(this);
    }

    @Override
    public void itemClickListener(int position) {
        User_entity entity = adapter.getUserEntity(position);
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("Entity",entity);
        startActivity(intent);

    }
}
