package app.apptesttask.ui.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import app.apptesttask.R;
import app.apptesttask.mvp.presenter.AuthPresenter;
import app.apptesttask.mvp.view.AuthActivityView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends MvpAppCompatActivity implements AuthActivityView {

    @InjectPresenter
    AuthPresenter mAuthPresenter;

    AlertDialog mErrorDialog;

    @BindView(R.id.email)
    EditText mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.email_sign_in_button)
    Button mSignInButton;
    @BindView(R.id.login_form)
    View mLoginFormView;
    @BindView(R.id.login_progress)
    View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        ButterKnife.bind(this);

        mPasswordView.setOnEditorActionListener((textView, id, keyEvent) ->
                (id == EditorInfo.IME_NULL));

        mSignInButton.setOnClickListener(view -> attemptLogin());
    }

    private void attemptLogin(){
        mAuthPresenter.signIn(mEmailView.getText().toString(), mPasswordView.getText().toString());
    }

    @Override
    public void startAuth() {
        toggleProgressVisibility(true);
    }

    @Override
    public void finishAuth() {
        toggleProgressVisibility(false);
    }

    private void toggleProgressVisibility(final boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    @Override
    public void failedSignIn(String message) {
        mErrorDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(message)
                .setOnCancelListener(dialog -> mAuthPresenter.onErrorCancel())
                .show();
    }

    @Override
    public void hideError() {
        if(mErrorDialog!=null && mErrorDialog.isShowing()){
            mErrorDialog.cancel();
        }
    }

    @Override
    public void hideFormError() {
        mEmailView.setError(null);
        mPasswordView.setError(null);
    }

    @Override
    public void showFormError(Integer emailError, Integer passwordError) {
        mEmailView.setError(emailError == null ? null : getString(emailError));
        mPasswordView.setError(passwordError == null ? null : getString(passwordError));
    }

    @Override
    public void successAuth() {
        final Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }
}
