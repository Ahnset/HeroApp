package com.example.mrdeveloper.superhero.ui.base.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mrdeveloper.superhero.data.DataManager;
import com.example.mrdeveloper.superhero.ui.base.view.MvpView;

import javax.inject.Inject;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

public class BasePresenter<T extends MvpView> implements Presenter {

    @Inject
    protected DataManager dataManager;

    protected T view;

    public BasePresenter(T view) {
        this.view = view;
    }

    @Override
    public void onStart(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onEnd() {

    }
}
