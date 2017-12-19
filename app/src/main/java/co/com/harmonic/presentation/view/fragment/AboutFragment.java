package co.com.harmonic.presentation.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import co.com.harmonic.R;
import co.com.harmonic.domain.model.Instructor;
import co.com.harmonic.domain.model.Instrument;
import co.com.harmonic.helpers.Callback;
import co.com.harmonic.presentation.presenter.AboutPresenter;
import co.com.harmonic.presentation.presenter.interfaces.AboutContract;
import co.com.harmonic.presentation.view.activity.MainActivity;
import co.com.harmonic.presentation.view.adapter.InstructorAdapter;
import co.com.harmonic.presentation.view.adapter.InstrumentAdapter;

public class AboutFragment extends Fragment implements AboutContract.View {
    static List<Instrument> instrumentListt;
    static private ImageView imageView;
    private AboutContract.UserActionsListener mActionListener;
    private RecyclerView rvInstrumenstList;
    private RecyclerView rvInstructorsList;
    private InstrumentAdapter instrumentAdapter = new InstrumentAdapter(new ArrayList<Instrument>());
    private InstructorAdapter instructorAdapter = new InstructorAdapter(new ArrayList<Instructor>());
    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment getInstance(List<Instrument> list) {
        instrumentListt = list;
        return new AboutFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        mActionListener = new AboutPresenter(this);
        //Seteo ImageView
        imageView = view.findViewById(R.id.iv_Instrumento);
        Glide.with(view).load(R.drawable.guitar).into(imageView);

        //RecyclerView Instrumentos
        rvInstrumenstList = view.findViewById(R.id.rvInstrumenstList);
        getAllInstruments();
        //RecyclerView Instructos
        rvInstructorsList = view.findViewById(R.id.rvInstructorsList);
        mActionListener.getAllInstructors("armonica", new Callback<List<Instructor>>() {
            @Override
            public void success(List<Instructor> result) {
                getAllInstructors(result);
            }

            @Override
            public void error(Exception error) {

            }
        });
        return view;
    }

    private void getAllInstructors(List<Instructor> result) {
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rvInstructorsList.setLayoutManager(layoutManager1);
        instructorAdapter = new InstructorAdapter(result);
        instructorAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View instructorAdapter) {
                goToDetailFragment();
            }
        });
        rvInstructorsList.setAdapter(instructorAdapter);
        rvInstructorsList.getAdapter().notifyDataSetChanged();
    }

    private void getAllInstruments() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvInstrumenstList.setLayoutManager(layoutManager);
        instrumentAdapter = new InstrumentAdapter(instrumentListt);
        instrumentAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                goToAbouthFragment(instrumentListt);
            }
        });
        rvInstrumenstList.setAdapter(instrumentAdapter);
        rvInstrumenstList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void goToAbouthFragment(List<Instrument> result) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.replaceFragment(AboutFragment.getInstance(result), true);
    }

    @Override
    public void goToDetailFragment() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.replaceFragment(DetailFragment.getInstance(), true);
    }

}
