package app.apptesttask.mvp.common;

import android.content.Context;
import android.content.SharedPreferences;

import app.apptesttask.application.MyApplication;

public class PrefUtils {
    private static final String PREF_NAME = "github";

    public static SharedPreferences getPrefs() {
        return MyApplication.getAppComponent().getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor() {
        return getPrefs().edit();
    }
}
