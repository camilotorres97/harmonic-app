package co.com.harmonic.presentation.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.com.harmonic.R;

public class AboutFragment extends Fragment {
    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment getInstance() {
        return new AboutFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }
}
