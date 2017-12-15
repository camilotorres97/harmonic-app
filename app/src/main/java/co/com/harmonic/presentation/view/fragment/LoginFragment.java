package co.com.harmonic.presentation.view.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.com.harmonic.R;


public class LoginFragment extends Fragment implements View.OnClickListener {
    private Button btnSignIn;
    private Button btnSignUp;
    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btnSignIn = view.findViewById(R.id.btnSignIn);
        btnSignUp = view.findViewById(R.id.btnSignUp);
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignIn:
                Snackbar.make(getView(), "1", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.btnSignUp:
                Snackbar.make(getView(), "2", Snackbar.LENGTH_LONG).show();
                break;
        }
    }
}