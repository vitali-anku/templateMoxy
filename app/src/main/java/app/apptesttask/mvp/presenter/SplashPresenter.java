package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.common.AuthUtils;
import app.apptesttask.mvp.models.Model;
import app.apptesttask.mvp.view.SplashView;

@InjectViewState
public class SplashPresenter extends BasePresenter<SplashView> {

    @Inject
    Model mModel;

    public SplashPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        if(mModel.getTokenFromPrefs().equals("")){
            getViewState().openAuthActivity();
        }
        else {
            getViewState().skipAuthActivity();
        }
    }
}
