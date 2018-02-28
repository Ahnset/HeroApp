package com.example.mrdeveloper.superhero;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

@Singleton
@Component(modules = AppModule.class)
interface AppComponent {
    void inject(App app);
}
