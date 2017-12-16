package co.com.harmonic.presentation.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import org.w3c.dom.Text;

import co.com.harmonic.R;
import co.com.harmonic.presentation.presenter.SignUpPresenter;
import co.com.harmonic.presentation.presenter.interfaces.SignUpContract;


public class SignUpFragment extends Fragment implements SignUpContract.View, View.OnClickListener{

    private SignUpContract.UserActionsListener userActionsListener;
    private RadioButton rb_estudiante;
    private RadioButton rb_instructor;
    private TextInputLayout til_FullName;
    private TextInputLayout til_Correo;
    private TextInputLayout til_Password;
    private Button btn_registrar;
    private Button btn_cancelar;


    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment getInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        userActionsListener = new SignUpPresenter(this);

        rb_estudiante = view.findViewById(R.id.rb_estudiante);
        rb_estudiante = view.findViewById(R.id.rb_instructor);
        til_FullName = view.findViewById(R.id.til_FullName);
        til_Correo = view.findViewById(R.id.til_correo);
        til_Password = view.findViewById(R.id.til_password);
        btn_registrar = view.findViewById(R.id.btn_registrar);
        btn_cancelar = view.findViewById(R.id.btn_cancelar);

        rb_estudiante.setOnClickListener(this);
        rb_instructor.setOnClickListener(this);
        btn_registrar.setOnClickListener(this);
        btn_cancelar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_registrar:
                onSignUp();
                break;
            case R.id.btn_cancelar:
                //TODO funcionalidad
                break;
            case R.id.rb_estudiante:
                //TODO funcionalidad
                break;
            case R.id.rb_instructor:
                //TODO funcionalidad
                break;

        }
    }

    private void onSignUp() {
    }

    @Override
    public void goToLoginFragment() {

    }

    @Override
    public void goToMainActivity() {

    }

    @Override
    public void showMessageError(Exception error) {

    }
}
