package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface SplashView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void openAuthActivity();

    @StateStrategyType(SkipStrategy.class)
    void skipAuthActivity();

    void openActivity(Class<?> aClass);
}
