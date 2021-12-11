package com.example.moviecatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    TextView judul,deskripsi;
    ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String Judul = intent.getStringExtra("Judul");
        String Deskripsi = intent.getStringExtra("Deskripsi");
        String Gambar = intent.getStringExtra("Gambar");
        String Rating = intent.getStringExtra("Rating");

        judul = findViewById(R.id.detail_judul);
        deskripsi = findViewById(R.id.detail_text);
        gambar = findViewById(R.id.detail_gambar);

        judul.setText(Judul);
        deskripsi.setText(Deskripsi);
        Glide.with(this).load(Gambar).into(gambar);

    }
}