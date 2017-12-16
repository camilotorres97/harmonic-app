package co.com.harmonic.repository.impl;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.com.harmonic.domain.model.User;
import co.com.harmonic.helpers.Callback;
import co.com.harmonic.repository.UserRepository;


/**
 * Created by Rodolhan on 15/12/2017.
 */

public class UserFirebaseRepository implements UserRepository {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public UserFirebaseRepository() {
        this.mAuth = FirebaseAuth.getInstance();
        this.mDatabase = FirebaseDatabase.getInstance()
                .getReference("users");
    }

    @Override
    public void login(String email, String password, final Callback<User> callback) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful() && task.getResult() != null) {
                            FirebaseUser firebaseUser = task.getResult().getUser();
                            mDatabase.child(firebaseUser.getUid())
                                    .addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            User user = dataSnapshot.getValue(User.class);
                                            callback.success(user);
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                            callback.error(databaseError.toException());
                                        }
                                    });
                        } else {
                            callback.error(task.getException());
                        }
                    }
                });
    }

}
