package app.apptesttask.application;

import android.app.Application;

import app.apptesttask.di.AppComponent;
import app.apptesttask.di.DaggerAppComponent;
import app.apptesttask.di.modules.ContextModule;

public class MyApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildAppComponent();
    }

    private void buildAppComponent(){
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }
}
