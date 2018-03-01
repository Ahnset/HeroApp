package com.example.mrdeveloper.superhero.ui.main.presenter;

import com.example.mrdeveloper.superhero.inject.PerFragment;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

@Module
public abstract class MainPresenterModule {

    @Binds
    @PerFragment
    abstract MainPresenter mainPresenter(MainPresenterImpl mainPresenter);
}
