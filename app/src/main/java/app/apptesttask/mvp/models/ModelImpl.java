package app.apptesttask.mvp.models;


import android.support.annotation.NonNull;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.common.AuthUtils;

public class ModelImpl implements Model {

    public ModelImpl() {
        MyApplication.getAppComponent().inject(this);
    }

    @Override
    public void saveTokenInPrefs(@NonNull String token) {
        AuthUtils.setToken(token);
    }

    @Override
    public String getTokenFromPrefs() {
        return AuthUtils.getToken();
    }
}
