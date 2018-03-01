package com.example.mrdeveloper.superhero.ui.main.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrdeveloper.superhero.R;
import com.example.mrdeveloper.superhero.api.hero.Api;
import com.example.mrdeveloper.superhero.api.hero.Hero;
import com.example.mrdeveloper.superhero.ui.base.view.BaseFragment;
import com.example.mrdeveloper.superhero.ui.base.view.BaseViewFragment;
import com.example.mrdeveloper.superhero.ui.main.presenter.MainPresenter;
import com.example.mrdeveloper.superhero.ui.main.view.adapters.HeroRvAdapter;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainFragment extends BaseViewFragment<MainPresenter> implements MainView {

    @Inject
    HeroRvAdapter adapter;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.setup();
        presenter.getHeroes(activityContext, adapter);
    }

    @Override
    public void setupRecyclerView() {
        layoutManager = new LinearLayoutManager(activityContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
