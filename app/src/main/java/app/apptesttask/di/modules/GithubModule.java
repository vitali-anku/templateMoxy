package app.apptesttask.di.modules;

import app.apptesttask.app.GithubApi;
import app.apptesttask.app.GithubService;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})
public class GithubModule {

    @Provides
    GithubService provideGithubService(GithubApi authApi){
        return new GithubService(authApi);
    }
}
