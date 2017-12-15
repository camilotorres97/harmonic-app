package co.com.harmonic.presentation.presenter;

import co.com.harmonic.presentation.presenter.interfaces.LoginContract;


/**
 * Created by Rodolhan on 15/12/2017.
 */

public class LoginPresenter implements LoginContract.UserActionsListener {

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onLogin(String email, String password, boolean remember) {

    }

    @Override
    public void configure() {

    }
}
