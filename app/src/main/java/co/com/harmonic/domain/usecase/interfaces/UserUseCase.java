package co.com.harmonic.domain.usecase.interfaces;

import co.com.harmonic.domain.model.User;
import co.com.harmonic.helpers.Callback;

/**
 * Created by juank on 15/12/2017.
 */

public interface UserUseCase {
    void login(String email, String password, boolean remember, Callback<User> callback);

    void signUp(String fullName, String email, String password, Callback<User> callback);
}
