package com.example.moviecatalog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviecatalog.Model.ResultsItem;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ResultsItem> modelClassArrayList;

    public Adapter(Context context, ArrayList<ResultsItem> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("Judul",modelClassArrayList.get(position).getTitle());
                intent.putExtra("Gambar","https://image.tmdb.org/t/p/original/"+modelClassArrayList
                        .get(position).getPosterPath());
                intent.putExtra("Deskripsi",modelClassArrayList.get(position).getOverview());
                intent.putExtra("Rating",String.valueOf(modelClassArrayList.get(position).getVoteAverage()));
                context.startActivity(intent);
            }
        });


        holder.mrelease.setText("Release Date : "+modelClassArrayList.get(position).getReleaseDate());
        holder.mjudul.setText(modelClassArrayList.get(position).getTitle());
        holder.mdeskripsi.setText(modelClassArrayList.get(position).getOverview());
        holder.mrating.setText("Rating : "+String.valueOf(modelClassArrayList.get(position).getVoteAverage()));
        Glide.with(context).load("https://image.tmdb.org/t/p/original/"+modelClassArrayList.get(position).getPosterPath()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mjudul,mdeskripsi,mrating,mrelease;
        CardView cardView;
        ImageView imageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mjudul=itemView.findViewById(R.id.JudulFilm);
            mdeskripsi=itemView.findViewById(R.id.DeskripsiFilm);
            mrating=itemView.findViewById(R.id.Rating);
            mrelease=itemView.findViewById(R.id.Release);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}