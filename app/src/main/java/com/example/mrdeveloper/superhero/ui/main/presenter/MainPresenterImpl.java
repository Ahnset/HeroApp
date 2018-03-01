package com.example.mrdeveloper.superhero.ui.main.presenter;

import android.content.Context;

import com.example.mrdeveloper.superhero.inject.PerFragment;
import com.example.mrdeveloper.superhero.ui.base.presenter.BasePresenter;
import com.example.mrdeveloper.superhero.ui.main.view.MainView;
import com.example.mrdeveloper.superhero.ui.main.view.adapters.HeroRvAdapter;

import javax.inject.Inject;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

@PerFragment
public class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter {

    @Inject
    public MainPresenterImpl(MainView view) {
        super(view);
    }

    @Override
    public void setup() {
        view.setupRecyclerView();
    }

    @Override
    public void getHeroes(Context context, HeroRvAdapter adapter) {
        dataManager.getHeroes(context, adapter);
    }
}
