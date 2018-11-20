package app.apptesttask.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import app.apptesttask.R;
import app.apptesttask.mvp.presenter.SplashPresenter;
import app.apptesttask.mvp.view.SplashView;
import app.apptesttask.util.Constants;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {

    @InjectPresenter
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void openAuthActivity() {
        openActivity(SignInActivity.class);
    }

    @Override
    public void skipAuthActivity() {
        openActivity(MainActivity.class);
    }

    @Override
    public void openActivity(final Class<?> mClass) {
        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashActivity.this, mClass);
            startActivity(i);
            finish();
        }, Constants.delayMillis);
    }
}
