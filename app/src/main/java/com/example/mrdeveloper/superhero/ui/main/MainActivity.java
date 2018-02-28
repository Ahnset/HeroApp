package com.example.mrdeveloper.superhero.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mrdeveloper.superhero.R;
import com.example.mrdeveloper.superhero.ui.base.BaseActivity;
import com.example.mrdeveloper.superhero.ui.main.view.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            addFragment(R.id.fragment_container, new MainFragment());
        }
    }
}
