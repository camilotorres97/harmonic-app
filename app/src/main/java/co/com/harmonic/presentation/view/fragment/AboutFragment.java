package co.com.harmonic.presentation.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    static private List<Instrument> instrumentList;
    static private View view_help;
    static private ImageView imageView;
    private AboutContract.UserActionsListener mActionListener;
    private RecyclerView rvInstrumenstList;
    private RecyclerView rvInstructorsList;
    private InstrumentAdapter instrumentAdapter = new InstrumentAdapter(new ArrayList<Instrument>());
    private InstructorAdapter instructorAdapter = new InstructorAdapter(new ArrayList<Instructor>(), true);
    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment getInstance(List<Instrument> list, View help) {
        view_help = help;
        instrumentList = list;
        return new AboutFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        mActionListener = new AboutPresenter(this);
        //Seteo ImageView
        imageView = view.findViewById(R.id.iv_Instrumento);
        ImageView image_help = view_help.findViewById(R.id.ivPhoto_Instrument);
        Glide.with(view).load(image_help.getDrawable()).into(imageView);
        //RecyclerView Instrumentos
        rvInstrumenstList = view.findViewById(R.id.rvInstrumenstList);
        getAllInstruments();
        //RecyclerView Instructos
        TextView id = view_help.findViewById(R.id.tvInstrument);
        rvInstructorsList = view.findViewById(R.id.rvInstructorsList);
        mActionListener.getAllInstructors(id.getText().toString().toLowerCase(), new Callback<List<Instructor>>() {
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
        instructorAdapter = new InstructorAdapter(result, true);
        instructorAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_help) {
                goToDetailFragment(view_help);
            }
        });
        rvInstructorsList.setAdapter(instructorAdapter);
        rvInstructorsList.getAdapter().notifyDataSetChanged();
    }

    private void getAllInstruments() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvInstrumenstList.setLayoutManager(layoutManager);
        instrumentAdapter = new InstrumentAdapter(instrumentList);
        instrumentAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_help) {
                goToAboutFragment(instrumentList, view_help);
            }
        });
        rvInstrumenstList.setAdapter(instrumentAdapter);
        rvInstrumenstList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void goToAboutFragment(List<Instrument> result, View view_help) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.replaceFragment(AboutFragment.getInstance(result, view_help), true);
    }

    @Override
    public void goToDetailFragment(View view_help) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.replaceFragment(DetailFragment.getInstance(view_help), true);
    }

}
