package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.view.MainActivityView;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {
    public MainActivityPresenter() {
        MyApplication.getAppComponent().inject(this);
    }
}
