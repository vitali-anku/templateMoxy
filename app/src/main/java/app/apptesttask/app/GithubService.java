package app.apptesttask.app;

import app.apptesttask.mvp.models.user.User;
import rx.Observable;

public class GithubService {
    private GithubApi mGithubApi;

    public GithubService(GithubApi mGithubApi) {
        this.mGithubApi = mGithubApi;
    }

    public Observable<User> signIn(String token){
        return mGithubApi.signIn(token);
    }
}
