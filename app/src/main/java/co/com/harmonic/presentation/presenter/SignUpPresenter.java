package co.com.harmonic.presentation.presenter;

import co.com.harmonic.presentation.presenter.interfaces.SignUpContract;


/**
 * Created by Rodolhan on 15/12/2017.
 */

public class SignUpPresenter implements SignUpContract.UserActionsListener {

    private SignUpContract.View view;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void onSignUp(String fullName, String email, String password) {

    }
}
