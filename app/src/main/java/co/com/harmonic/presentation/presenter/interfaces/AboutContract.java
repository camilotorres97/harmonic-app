package co.com.harmonic.presentation.presenter.interfaces;

import java.util.List;

import co.com.harmonic.domain.model.Instrument;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public interface AboutContract {
    interface View {
        void goToAbouthFragment(List<Instrument> result);

        void goToDetailFragment();
    }

    interface UserActionsListener {
    }
}
