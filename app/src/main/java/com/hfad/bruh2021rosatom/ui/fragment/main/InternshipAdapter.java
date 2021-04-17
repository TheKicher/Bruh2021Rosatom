package com.hfad.bruh2021rosatom.ui.fragment.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelInternshipment;


public class InternshipAdapter extends RecyclerView.Adapter<InternshipAdapter.InternshipViewHolder> {

    private Listener listener;

    private List<ModelInternshipment> items;

    public InternshipAdapter(List<ModelInternshipment> items) {
        this.items = items;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setItems(List<ModelInternshipment> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InternshipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InternshipViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_internshipment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InternshipViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class InternshipViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;
        private final TextView city;
        private final TextView company;
        private final TextView date;
        //private final TextView vacancyClick;

        public InternshipViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            city = itemView.findViewById(R.id.city);
            company = itemView.findViewById(R.id.company);
            date = itemView.findViewById(R.id.date);
            //vacancyClick = itemView.findViewById(R.id.vacancy_click);

            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onInternshipmentClick(items.get(getAdapterPosition()));
                }
            });
        }

        public void bind(ModelInternshipment item) {
            title.setText(item.getName());
            description.setText(item.getDescription());
            city.setText(item.getOrganization().getCity());
            company.setText(item.getOrganization().getName());
            date.setText("17.04.2021");
            /*vacancyClick.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onInternshipmentResponse(item);
                }
            });*/

        }
    }

    interface Listener {
        void onInternshipmentClick(ModelInternshipment model);

        void onInternshipmentResponse(ModelInternshipment model);
    }

}
