package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import app.apptesttask.mvp.common.AuthUtils;
import app.apptesttask.mvp.view.SignOutView;

@InjectViewState
public class SignOutPresenter extends MvpPresenter<SignOutView> {
    public void signOut(){
        AuthUtils.setToken("");

        getViewState().signOut();
    }
}
