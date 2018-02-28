package com.example.mrdeveloper.superhero.ui.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.mrdeveloper.superhero.inject.PerActivity;
import com.example.mrdeveloper.superhero.inject.PerFragment;
import com.example.mrdeveloper.superhero.ui.base.BaseActivityModule;
import com.example.mrdeveloper.superhero.ui.main.view.MainFragment;
import com.example.mrdeveloper.superhero.ui.main.view.MainFragmentModule;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    static final String BASE_URL = "https://simplifiedcoding.net/demos/";

    @PerFragment
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment mainFragmentInjector();

    @Binds
    @PerActivity
    abstract AppCompatActivity activity(MainActivity mainActivity);


    @Provides
    @PerActivity
    static Cache provideHttpCache(Context application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @PerActivity
    static Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @PerActivity
    static OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @PerActivity
    static Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();
    }
}
