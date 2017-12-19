package co.com.harmonic.presentation.presenter;

import java.util.List;

import co.com.harmonic.domain.model.Instrument;
import co.com.harmonic.domain.usecase.impl.InstrumentUseCaseImpl;
import co.com.harmonic.domain.usecase.interfaces.InstrumentUseCase;
import co.com.harmonic.helpers.Callback;
import co.com.harmonic.presentation.presenter.interfaces.GeneralContract;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class GeneralPresenter implements GeneralContract.UserActionsListener {
    private GeneralContract.View view;
    private InstrumentUseCase instrumentUseCase;

    public GeneralPresenter(GeneralContract.View view) {
        this.view = view;
        instrumentUseCase = new InstrumentUseCaseImpl();
    }

    @Override
    public void getAllInstruments(final Callback<List<Instrument>> listCallback) {
        instrumentUseCase.getAllInstruments(new Callback<List<Instrument>>() {
            @Override
            public void success(List<Instrument> result) {
                listCallback.success(result);
            }

            @Override
            public void error(Exception error) {

            }
        });
    }
}
