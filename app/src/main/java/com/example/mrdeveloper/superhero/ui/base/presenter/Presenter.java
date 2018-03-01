package com.example.mrdeveloper.superhero.ui.base.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

public interface Presenter {

    void onStart(@Nullable Bundle savedInstanceState);

    void onResume();

    void onPause();

    void onSaveInstanceState(Bundle outState);

    void onEnd();
}
