package co.com.harmonic.presentation.presenter.interfaces;

import java.util.List;

import co.com.harmonic.domain.model.Instructor;
import co.com.harmonic.domain.model.Instrument;
import co.com.harmonic.helpers.Callback;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public interface AboutContract {
    interface View {
        void goToAbouthFragment(List<Instrument> result);

        void goToDetailFragment();
    }

    interface UserActionsListener {
        void getAllInstructors(String id, Callback<List<Instructor>> listCallback);
    }
}
