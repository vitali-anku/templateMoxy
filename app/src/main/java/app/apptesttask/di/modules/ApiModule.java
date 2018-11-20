package app.apptesttask.di.modules;

import javax.inject.Singleton;

import app.apptesttask.app.GithubApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class})
public class ApiModule {
    @Provides
    @Singleton
    public GithubApi provideGithubApi(Retrofit retrofit){
        return retrofit.create(GithubApi.class);
    }
}
