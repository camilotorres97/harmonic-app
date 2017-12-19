package co.com.harmonic.presentation.presenter;

import java.util.List;

import co.com.harmonic.domain.model.Instructor;
import co.com.harmonic.domain.usecase.impl.InstructorUseCaseImpl;
import co.com.harmonic.domain.usecase.interfaces.InstructorUseCase;
import co.com.harmonic.helpers.Callback;
import co.com.harmonic.presentation.presenter.interfaces.AboutContract;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class AboutPresenter implements AboutContract.UserActionsListener {
    private AboutContract.View view;
    private InstructorUseCase instructorUseCase;

    public AboutPresenter(AboutContract.View view) {
        this.view = view;
        this.instructorUseCase = new InstructorUseCaseImpl();
    }

    @Override
    public void getAllInstructors(String id, final Callback<List<Instructor>> listCallback) {
        instructorUseCase.getAllInstructorsAbout(id, new Callback<List<Instructor>>() {
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
