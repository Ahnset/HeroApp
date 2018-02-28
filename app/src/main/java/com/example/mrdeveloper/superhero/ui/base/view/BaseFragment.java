package com.example.mrdeveloper.superhero.ui.base.view;

import android.content.Context;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

public abstract class BaseFragment extends Fragment implements HasSupportFragmentInjector {

    @Inject
    protected Context activityContext;

    @Inject
    DispatchingAndroidInjector<Fragment> supportFragmentInjector;


    public BaseFragment() {
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }
}
