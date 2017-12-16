package co.com.harmonic.domain.usecase.impl;

import co.com.harmonic.domain.model.User;
import co.com.harmonic.domain.usecase.UserUseCase;
import co.com.harmonic.helpers.Callback;
import co.com.harmonic.repository.UserRepository;
import co.com.harmonic.repository.impl.UserFirebaseRepository;

/**
 * Created by Rodolhan on 15/12/2017.
 */

public class UserUseCaseImpl implements UserUseCase {
    private UserRepository userRepository;

    public UserUseCaseImpl() {
        this.userRepository = new UserFirebaseRepository();
    }

    @Override
    public void login(final String email, String password, final Callback<User> callback) {
        userRepository.login(email, password, new Callback<User>() {
            @Override
            public void success(User user) {
                try {
                    callback.success(user);
                } catch (Exception e) {
                    callback.error(e);
                }
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }
}
