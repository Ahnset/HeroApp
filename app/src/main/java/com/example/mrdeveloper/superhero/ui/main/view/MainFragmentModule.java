package com.example.mrdeveloper.superhero.ui.main.view;

import android.support.v4.app.Fragment;

import com.example.mrdeveloper.superhero.inject.PerFragment;
import com.example.mrdeveloper.superhero.ui.base.view.BaseFragmentModule;
import com.example.mrdeveloper.superhero.ui.main.presenter.MainPresenterModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

@Module(includes = {BaseFragmentModule.class, MainPresenterModule.class})
public abstract class MainFragmentModule {

//    @Binds
//    @Named(BaseFragmentModule.FRAGMENT)
//    @PerFragment
//    abstract Fragment fragment(MainFragment mainFragment);

    @Binds
    @PerFragment
    abstract MainView mainView(MainFragment mainFragment);

}
