package co.com.harmonic.presentation.presenter;

import java.util.List;

import co.com.harmonic.domain.model.Instructor;
import co.com.harmonic.domain.model.Instrument;
import co.com.harmonic.domain.usecase.impl.InstructorUseCaseImpl;
import co.com.harmonic.domain.usecase.impl.InstrumentUseCaseImpl;
import co.com.harmonic.domain.usecase.interfaces.InstructorUseCase;
import co.com.harmonic.domain.usecase.interfaces.InstrumentUseCase;
import co.com.harmonic.helpers.Callback;
import co.com.harmonic.presentation.presenter.interfaces.GeneralContract;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class GeneralPresenter implements GeneralContract.UserActionsListener {
    private GeneralContract.View view;
    private InstrumentUseCase instrumentUseCase;
    private InstructorUseCase instructorUseCase;

    public GeneralPresenter(GeneralContract.View view) {
        this.view = view;
        instrumentUseCase = new InstrumentUseCaseImpl();
        instructorUseCase = new InstructorUseCaseImpl();
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

    @Override
    public void getAllInstructors(final Callback<List<Instructor>> listCallback) {
        instructorUseCase.getAllInstructors(new Callback<List<Instructor>>() {
            @Override
            public void success(List<Instructor> result) {
                listCallback.success(result);
            }

            @Override
            public void error(Exception error) {

            }
        });
    }
}
