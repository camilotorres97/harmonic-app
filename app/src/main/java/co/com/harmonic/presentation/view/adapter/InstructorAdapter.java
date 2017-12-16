package co.com.harmonic.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.com.harmonic.R;
import co.com.harmonic.domain.model.Instructor;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class InstructorAdapter extends RecyclerView.Adapter<InstructorAdapter.InstructorViewHolder> {
    private List<Instructor> dataSet;

    public InstructorAdapter(List<Instructor> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public InstructorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_instructor_item, parent, false);
        return new InstructorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InstructorViewHolder holder, int position) {
        Instructor instructor = dataSet.get(position);
        Glide.with(holder.itemView)
                .load(instructor.getImage())
                .into(holder.ivPhoto_Instructor);
        holder.tvText_Instructor.setText(instructor.getNombre());
        holder.tvText_Instructor1.setText(instructor.getApodo());
        holder.tvText_Instructor2.setText(instructor.getRol());
        holder.stars.setRating(instructor.getRating());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class InstructorViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivPhoto_Instructor;
        public TextView tvText_Instructor;
        public TextView tvText_Instructor1;
        public TextView tvText_Instructor2;
        public RatingBar stars;

        public InstructorViewHolder(View itemView) {
            super(itemView);
            ivPhoto_Instructor = itemView.findViewById(R.id.ivPhoto_Instructor);
            tvText_Instructor = itemView.findViewById(R.id.tvText_Instructor);
            tvText_Instructor1 = itemView.findViewById(R.id.tvText_Instructor1);
            tvText_Instructor2 = itemView.findViewById(R.id.tvText_Instructor2);
            stars = itemView.findViewById(R.id.stars);
        }
    }
}
