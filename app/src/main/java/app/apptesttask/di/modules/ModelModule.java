package app.apptesttask.di.modules;

import app.apptesttask.mvp.models.Model;
import app.apptesttask.mvp.models.ModelImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {

    @Provides
    Model provideDataRepository(){
        return new ModelImpl();
    }
}
