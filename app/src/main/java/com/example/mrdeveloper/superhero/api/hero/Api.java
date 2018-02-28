package com.example.mrdeveloper.superhero.api.hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

public interface Api {
//    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
