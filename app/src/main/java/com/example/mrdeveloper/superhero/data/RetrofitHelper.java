package com.example.mrdeveloper.superhero.data;

import android.content.Context;
import android.widget.Toast;

import com.example.mrdeveloper.superhero.api.hero.Api;
import com.example.mrdeveloper.superhero.api.hero.Hero;
import com.example.mrdeveloper.superhero.inject.PerActivity;
import com.example.mrdeveloper.superhero.ui.main.view.adapters.HeroRvAdapter;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Mr. Developer on 3/1/2018.
 */

@PerActivity
public class RetrofitHelper {

    protected Retrofit retrofit;

    protected Call<List<Hero>> call;

    @Inject
    public RetrofitHelper(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public void getHeroes(final Context context, final HeroRvAdapter adapter) {

        Api api = retrofit.create(Api.class);
        call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                adapter.updateList(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(context, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
