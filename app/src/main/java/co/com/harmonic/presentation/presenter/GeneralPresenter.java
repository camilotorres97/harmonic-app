package co.com.harmonic.presentation.presenter;

import co.com.harmonic.presentation.presenter.interfaces.GeneralContract;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class GeneralPresenter implements GeneralContract.UserActionsListener {
    private GeneralContract.View view;

    public GeneralPresenter(GeneralContract.View view) {
        this.view = view;
    }
}
