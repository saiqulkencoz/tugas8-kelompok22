package com.example.moviecatalog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecatalog.Api.ApiUtilities;
import com.example.moviecatalog.Model.Movie;
import com.example.moviecatalog.Model.ResultsItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    String api_key = "f4a25dcd8fb80306caef28a057fe36c7";
    ArrayList<ResultsItem> resultsItems;
    Adapter adapter;
    private RecyclerView recyclerViewhome;
    TextView a;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.homefragment,null);

        recyclerViewhome=v.findViewById(R.id.recyclerhome);
        resultsItems = new ArrayList<>();
        recyclerViewhome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),resultsItems);
        recyclerViewhome.setAdapter(adapter);

        findMovies();

        return v;
    }

    private void findMovies() {
        ApiUtilities.getApiInterface().getMovies(api_key,"en-US","popularity.desc",1).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful())
                {
                    resultsItems.addAll(response.body().getResults());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                a.findViewById(R.id.test);
                a.setText(t.getMessage());
            }
        });
    }
}
