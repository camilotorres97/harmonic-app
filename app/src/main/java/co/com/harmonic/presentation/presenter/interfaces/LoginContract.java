package co.com.harmonic.presentation.presenter.interfaces;

/**
 * Created by Rodolhan on 15/12/2017.
 */

public interface LoginContract {

    interface View {
        void goToSignUpFragment();

        void goToMainActivity();

        void showMessageError(Exception error);

        void showProgress();

        void hideProgress();

        void showRememberedUser(String email);
    }

    interface UserActionsListener {
        void onLogin(String email, String password, boolean remember);

        void configure();
    }

}
