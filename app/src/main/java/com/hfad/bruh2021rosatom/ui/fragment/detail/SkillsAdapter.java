package com.hfad.bruh2021rosatom.ui.fragment.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.List;

import com.hfad.bruh2021rosatom.R;


public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder> {

    private final List<String> items;

    public SkillsAdapter(List<String> skills) {
        this.items = skills;
    }

    @NonNull
    @Override
    public SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SkillsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skill, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class SkillsViewHolder extends RecyclerView.ViewHolder {

        private final Chip chip;

        public SkillsViewHolder(@NonNull View itemView) {
            super(itemView);
            chip = itemView.findViewById(R.id.chip);
        }

        public void bind(String skill) {
            chip.setText(skill);
        }
    }
}

