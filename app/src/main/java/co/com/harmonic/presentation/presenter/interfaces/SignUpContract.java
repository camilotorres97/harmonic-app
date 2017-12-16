package co.com.harmonic.presentation.presenter.interfaces;

import co.com.harmonic.domain.model.User;
import co.com.harmonic.helpers.Callback;

/**
 * Created by Rodolhan on 15/12/2017..
 */

public interface SignUpContract {

    interface View {
        void goToLoginFragment();

        void goToMainActivity();

        void showMessageError(Exception error);
    }

    interface UserActionsListener {

        void onSignUp(String rol, String fullName, String email, String password);
    }

}
