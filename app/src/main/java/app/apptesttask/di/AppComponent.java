package app.apptesttask.di;

import android.content.Context;

import javax.inject.Singleton;

import app.apptesttask.di.modules.ContextModule;
import app.apptesttask.di.modules.GithubModule;
import app.apptesttask.di.modules.ModelModule;
import app.apptesttask.mvp.models.ModelImpl;
import app.apptesttask.mvp.presenter.AuthPresenter;
import app.apptesttask.mvp.presenter.MainActivityPresenter;
import app.apptesttask.mvp.presenter.SplashPresenter;
import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, ModelModule.class, GithubModule.class})
public interface AppComponent {
    Context getContext();

    void inject(SplashPresenter splashPresenter);
    void inject(AuthPresenter authPresenter);

    void inject(ModelImpl model);

    void inject(MainActivityPresenter mainActivityPresenter);
}
