package com.example.mrdeveloper.superhero.data;

import android.content.Context;

import com.example.mrdeveloper.superhero.inject.PerActivity;
import com.example.mrdeveloper.superhero.ui.main.view.adapters.HeroRvAdapter;

import javax.inject.Inject;

/**
 * Created by Mr. Developer on 3/1/2018.
 */

@PerActivity
public class DataManager {

    protected RetrofitHelper retrofitHelper;

    @Inject
    public DataManager(RetrofitHelper retrofitHelper) {
        this.retrofitHelper = retrofitHelper;
    }

    public void getHeroes(Context context, HeroRvAdapter adapter) {
        retrofitHelper.getHeroes(context, adapter);
    }
}
