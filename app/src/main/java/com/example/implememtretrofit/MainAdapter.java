package com.example.implememtretrofit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>
{
    //Initialize variable
    private ArrayList<MainData> dataArrayList;
    private Activity activity;

    //Create constructer
    public MainAdapter(Activity activity, ArrayList<MainData> dataArrayList)
    {
        this.activity = activity;
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //Initialize view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        //Initialize main data
        MainData data = dataArrayList.get(position);

        //Set image on image view
        Glide.with(activity).load(data.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);

        // Set name on textview
        holder.textView.setText(data.getName());

    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        //Initialize variable
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            //Assign variable
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
