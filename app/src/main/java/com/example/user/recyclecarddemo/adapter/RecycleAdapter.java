package com.example.user.recyclecarddemo.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.recyclecarddemo.Entity.User_entity;
import com.example.user.recyclecarddemo.MainActivity;
import com.example.user.recyclecarddemo.R;

import java.util.ArrayList;

import static android.R.attr.data;

/**
 * Created by User on 7/18/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder> {
    private ArrayList<User_entity> user_Entities;
    private User_entity user_entity;
    private ArrayList<Bitmap> data;
    private  onItemClick monItemClick;
    public RecycleAdapter(ArrayList<User_entity> user_Entities,ArrayList<Bitmap> data)
    {
        this.user_Entities = user_Entities;
        this.data = data;

    }
    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecycleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycle,parent,false));
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        Bitmap bitmap= data.get(position);
        user_entity = user_Entities.get(position);
        holder.textView.setText(user_entity.getPersonName());
        holder.imageView.setImageBitmap(bitmap);


    }

    @Override
    public int getItemCount() {
        return user_Entities.size();
    }
    public  User_entity  getUserEntity(int position)
    {
        return user_Entities.get(position);
    }



    class RecycleViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView imageView;
        TextView textView;
        public RecycleViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
            textView = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(monItemClick != null)
            {
                monItemClick.itemClickListener(getAdapterPosition());
            }
        }
    }
    public interface onItemClick
    {
        void itemClickListener(int position);
    }
    public void setOnItemClick(onItemClick onItemClick)
    {
        monItemClick = onItemClick;
    }
}
