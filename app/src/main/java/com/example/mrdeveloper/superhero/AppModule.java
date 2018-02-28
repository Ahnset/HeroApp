package com.example.mrdeveloper.superhero;

import com.example.mrdeveloper.superhero.inject.PerActivity;
import com.example.mrdeveloper.superhero.ui.main.MainActivity;
import com.example.mrdeveloper.superhero.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

@Module(includes = AndroidSupportInjectionModule.class)
abstract class AppModule {

    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();
}
