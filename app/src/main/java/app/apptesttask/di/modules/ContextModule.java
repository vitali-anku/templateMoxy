package app.apptesttask.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context appContext;

    public ContextModule(Context mContext) {
        this.appContext = mContext;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return appContext;
    }
}
