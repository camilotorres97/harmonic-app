package co.com.harmonic.presentation.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.com.harmonic.R;
import co.com.harmonic.domain.model.Instructor;
import co.com.harmonic.domain.model.Instrument;
import co.com.harmonic.helpers.Callback;
import co.com.harmonic.presentation.presenter.GeneralPresenter;
import co.com.harmonic.presentation.presenter.interfaces.GeneralContract;
import co.com.harmonic.presentation.view.activity.MainActivity;
import co.com.harmonic.presentation.view.adapter.InstructorAdapter;
import co.com.harmonic.presentation.view.adapter.InstrumentAdapter;
import co.com.harmonic.presentation.view.adapter.ViewPagerAdapter;

public class GeneralFragment extends Fragment implements GeneralContract.View {
    private RecyclerView rvInstrumenstList;
    private RecyclerView rvInstructorsList;
    private ViewPager viewPager;
    private GeneralContract.UserActionsListener mActionListener;
    private InstrumentAdapter instrumentAdapter = new InstrumentAdapter(new ArrayList<Instrument>());
    private InstructorAdapter instructorAdapter = new InstructorAdapter(new ArrayList<Instructor>(), false);

    public GeneralFragment() {        // Required empty public constructor
    }

    public static GeneralFragment getInstance() {
        return new GeneralFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_general, container, false);
        mActionListener = new GeneralPresenter(this);
        viewPager = view.findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);
        //RecyclerView Instrumentos
        rvInstrumenstList = view.findViewById(R.id.rvInstrumenstList);
        mActionListener.getAllInstruments(new Callback<List<Instrument>>() {
            @Override
            public void success(List<Instrument> result) {
                getAllInstruments(result);
            }

            @Override
            public void error(Exception error) {

            }
        });
        //RecyclerView Instrumentos
        rvInstructorsList = view.findViewById(R.id.rvInstructorsList);
        mActionListener.getAllInstructors(new Callback<List<Instructor>>() {
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
        instructorAdapter = new InstructorAdapter(result, false);
        instructorAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_help) {
                goToDetailFragment(view_help);
            }
        });
        rvInstructorsList.setAdapter(instructorAdapter);
        rvInstructorsList.getAdapter().notifyDataSetChanged();
    }

    private void getAllInstruments(final List<Instrument> result) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvInstrumenstList.setLayoutManager(layoutManager);
        instrumentAdapter = new InstrumentAdapter(result);
        instrumentAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_help) {
                goToAbouthFragment(result, view_help);
            }
        });
        rvInstrumenstList.setAdapter(instrumentAdapter);
        rvInstrumenstList.getAdapter().notifyDataSetChanged();
    }


    @Override
    public void goToAbouthFragment(List<Instrument> result, View view_help) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.replaceFragment(AboutFragment.getInstance(result, view_help), true);
    }

    @Override
    public void goToDetailFragment(View view_help) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.replaceFragment(DetailFragment.getInstance(view_help), true);
    }

}
