package co.com.harmonic.presentation.presenter;

import co.com.harmonic.presentation.presenter.interfaces.AboutContract;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class AboutPresenter implements AboutContract.UserActionsListener {
    private AboutContract.View view;

    public AboutPresenter(AboutContract.View view) {
        this.view = view;
    }
}
