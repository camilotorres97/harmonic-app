package co.com.harmonic.domain.usecase.impl;

import co.com.harmonic.domain.model.User;
import co.com.harmonic.domain.usecase.interfaces.UserUseCase;
import co.com.harmonic.helpers.Callback;

/**
 * Created by juank on 15/12/2017.
 */

public class UserUseCaseImpl implements UserUseCase {
    @Override
    public void login(String email, String password, boolean remember, Callback<User> callback) {

    }

    @Override
    public void signUp(String fullName, String email, String password, Callback<User> callback) {

    }
}
