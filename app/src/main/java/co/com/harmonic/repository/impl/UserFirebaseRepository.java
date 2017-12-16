package co.com.harmonic.repository.impl;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import co.com.harmonic.domain.model.User;
import co.com.harmonic.helpers.Callback;
import co.com.harmonic.repository.interfaces.UserRepository;

/**
 * Created by juank on 15/12/2017.
 */

public class UserFirebaseRepository implements UserRepository{

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    public UserFirebaseRepository() {
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");
    }

    @Override
    public void login(String email, String password, Callback<User> callback) {

    }

    @Override
    public void signUp(final User user, final Callback<User> callback) {

        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful() && task.getResult() != null){
                            FirebaseUser firebaseUser = task.getResult().getUser();
                            user.setId(firebaseUser.getUid());
                            user.setPassword(null);

                            databaseReference.child(user.getId()).setValue(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                callback.success(user);
                                            }else{
                                                callback.error(task.getException());
                                            }
                                        }
                                    });
                        }
                    }
                });
    }
}
