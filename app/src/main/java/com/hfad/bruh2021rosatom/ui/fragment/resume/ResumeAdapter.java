package com.hfad.bruh2021rosatom.ui.fragment.resume;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelResume;

public class ResumeAdapter extends RecyclerView.Adapter<ResumeAdapter.ExperienceViewHolder> {

    private List<ModelResume.UserProfile.JobExperiense> items;

    public ResumeAdapter(List<ModelResume.UserProfile.JobExperiense> items) {
        this.items = items;
    }

    public void setItems(List<ModelResume.UserProfile.JobExperiense> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExperienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExperienceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_experience, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExperienceViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ExperienceViewHolder extends RecyclerView.ViewHolder {

        private final TextView company;
        private final TextView position;
        private final TextView period;

        public ExperienceViewHolder(@NonNull View itemView) {
            super(itemView);

            company = itemView.findViewById(R.id.company);
            position = itemView.findViewById(R.id.position);
            period = itemView.findViewById(R.id.period);
        }

        public void bind(ModelResume.UserProfile.JobExperiense item) {
            company.setText(item.getCompanyName());
            position.setText(item.getPosition());
            period.setText(item.getJobTimePeriod());
        }
    }

}
