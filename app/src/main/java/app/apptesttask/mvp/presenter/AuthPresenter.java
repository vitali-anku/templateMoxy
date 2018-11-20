package app.apptesttask.mvp.presenter;

import android.text.TextUtils;
import android.util.Base64;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;
import app.apptesttask.common.Utils;

import app.apptesttask.R;
import app.apptesttask.app.GithubService;
import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.models.Model;
import app.apptesttask.mvp.view.AuthActivityView;
import rx.Subscription;

@InjectViewState
public class AuthPresenter extends BasePresenter<AuthActivityView> {

    @Inject
    Model model;

    @Inject
    GithubService mGithubService;

    public AuthPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

    public void signIn(String email, String password){
        Integer emailError = null;
        Integer passwordError = null;

        getViewState().hideFormError();

        if(TextUtils.isEmpty(email)){
            emailError = R.string.error_field_required;
        }

        if(TextUtils.isEmpty(password)){
            passwordError = R.string.error_invalid_password;
        }

        if(emailError!=null||passwordError!=null){
            getViewState().showFormError(emailError, passwordError);
            return;
        }

        getViewState().startAuth();

        String credentials = String.format("%s:%s", email, password);

        final String token = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

        Subscription subscription = mGithubService.signIn(token)
                .doOnNext(user->model.saveTokenInPrefs(token))
                .compose(Utils.applySchedulers())
                .subscribe(user->{
                    getViewState().finishAuth();
                    getViewState().successAuth();
                }, exception ->{
                    getViewState().finishAuth();
                    getViewState().failedSignIn(exception.getMessage());
                });
        unsubscribeOnDestroy(subscription);
    }

    public void onErrorCancel(){
        getViewState().hideError();
    }

}
