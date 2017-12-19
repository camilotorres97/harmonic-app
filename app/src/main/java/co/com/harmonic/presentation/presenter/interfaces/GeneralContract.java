package co.com.harmonic.presentation.presenter.interfaces;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public interface GeneralContract {
    interface View {
        void goToAbouthFragment();

        void goToDetailFragment();
    }

    interface UserActionsListener {
    }
}
