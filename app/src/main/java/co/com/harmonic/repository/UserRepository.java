package co.com.harmonic.repository;


import co.com.harmonic.domain.model.User;
import co.com.harmonic.helpers.Callback;

/**
 * Created by Rodolhan on 15/12/2017.
 */

public interface UserRepository {

    void login(String email, String password, Callback<User> callback);


}
