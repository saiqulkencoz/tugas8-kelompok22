package com.example.moviecatalog.Api;

import com.example.moviecatalog.Model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("discover/movie")
    Call<Movie> getMovies(

        @Query("api_key") String api_key,
        @Query("language") String languange,
        @Query("sort_by") String Sort,
        @Query("page") int page

    );
}
