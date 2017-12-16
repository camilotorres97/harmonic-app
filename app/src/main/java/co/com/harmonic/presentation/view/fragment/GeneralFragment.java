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
import co.com.harmonic.presentation.view.adapter.InstructorAdapter;
import co.com.harmonic.presentation.view.adapter.InstrumentAdpater;

public class GeneralFragment extends Fragment {
    private RecyclerView rvInstrumenstList;
    private RecyclerView rvInstructorsList;
    private ImageView imageView3;
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
        imageView3 = view.findViewById(R.id.imageView3);
        //RecyclerView Instrumentos
        rvInstrumenstList = view.findViewById(R.id.rvInstrumenstList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvInstrumenstList.setLayoutManager(layoutManager);
        InstrumentAdpater adapter = new InstrumentAdpater(instrumento());
        rvInstrumenstList.setAdapter(adapter);
        //RecyclerView Instrumentos
        rvInstructorsList = view.findViewById(R.id.rvInstructorsList);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvInstructorsList.setLayoutManager(layoutManager1);
        InstructorAdapter adapter1 = new InstructorAdapter(instructor());
        rvInstructorsList.setAdapter(adapter1);
        refreshLists();
        Glide.with(view).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-8lhm4g7qqZFkemR3itAD36i0GwWh1O-wLJucESw08igCko9-SA")
                .into(imageView3);
        return view;
    }

    private List<Instructor> instructor() {
        List<Instructor> list = new ArrayList<>();
        list.add(new Instructor("Pocholo"
                , ""
                , "Jorge Corrales"
                , ""
                , 3
                , "Pianista"
                , "data:image/jpeg;base64,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"));

        return list;
    }


    public void refreshLists() {
        rvInstrumenstList.getAdapter().notifyDataSetChanged();
        rvInstructorsList.getAdapter().notifyDataSetChanged();
    }

    private List<Instrument> instrumento() {
        List<Instrument> list = new ArrayList<>();

        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        list.add(new Instrument("https://es.yamaha.com/es/files/BB8CF2BADB954E0C97C33E0832E90DEC_12073_2719x3128_991a6a0ef69e918f02da681f52288c31.jpg"
                , "Piano"));
        return list;
    }


}
