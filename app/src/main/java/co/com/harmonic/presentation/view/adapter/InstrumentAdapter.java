package co.com.harmonic.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.harmonic.R;
import co.com.harmonic.domain.model.Instrument;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class InstrumentAdapter extends RecyclerView.Adapter<InstrumentAdapter.InstrumentViewHolder> {
    private List<Instrument> dataSet;

    public InstrumentAdapter(List<Instrument> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public InstrumentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_instrument_item, parent, false);
        return new InstrumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InstrumentViewHolder holder, int position) {
        Instrument instrument = dataSet.get(position);
        Glide.with(holder.itemView)
                .load(instrument.getImage())
                .into(holder.ivPhoto);
        holder.tvInstrument.setText(instrument.getInstrumento());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class InstrumentViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivPhoto;
        public TextView tvInstrument;

        public InstrumentViewHolder(View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.ivPhoto_Instrument);
            tvInstrument = itemView.findViewById(R.id.tvInstrument);
        }
    }
}
