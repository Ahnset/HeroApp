package com.example.mrdeveloper.superhero.ui.base.view;

import android.os.Bundle;

import com.example.mrdeveloper.superhero.ui.base.presenter.Presenter;

import javax.inject.Inject;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

public abstract class BaseViewFragment<T extends Presenter> extends BaseFragment implements MvpView {

    @Inject
    protected T presenter;

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        presenter.onStart(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onDestroyView() {
        presenter.onEnd();
        super.onDestroyView();
    }
}
