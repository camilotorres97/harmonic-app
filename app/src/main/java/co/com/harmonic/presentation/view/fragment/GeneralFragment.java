package co.com.harmonic.presentation.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.com.harmonic.R;

public class GeneralFragment extends Fragment {
    public GeneralFragment() {
        // Required empty public constructor
    }

    public static GeneralFragment getInstance() {
        return new GeneralFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_general, container, false);
        return view;
    }
}
