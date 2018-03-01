package com.example.mrdeveloper.superhero.ui.main.presenter;

import android.content.Context;

import com.example.mrdeveloper.superhero.ui.base.presenter.Presenter;
import com.example.mrdeveloper.superhero.ui.main.view.adapters.HeroRvAdapter;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

public interface MainPresenter extends Presenter {

    void setup();

    void getHeroes(Context context, HeroRvAdapter adapter);
}
