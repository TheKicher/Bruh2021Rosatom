package com.hfad.bruh2021rosatom.ui.fragment.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelJob;


public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private Listener listener;

    private List<ModelJob> items;

    public JobAdapter(List<ModelJob> items) {
        this.items = items;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setItems(List<ModelJob> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JobViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class JobViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;
        private final TextView price;
        private final ImageView dot;
        private final TextView city;
        private final TextView company;
        private final TextView date;
        private final TextView vacancyClick;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            dot = itemView.findViewById(R.id.dot);
            city = itemView.findViewById(R.id.city);
            company = itemView.findViewById(R.id.company);
            date = itemView.findViewById(R.id.date);
            vacancyClick = itemView.findViewById(R.id.vacancy_click);

            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onJobClick(items.get(getAdapterPosition()));
                }
            });
        }

        public void bind(ModelJob item) {
            title.setText(item.getPositionName());
            description.setText(item.getDescription());
            city.setText(item.getOrganization().getCity());
            company.setText(item.getOrganization().getName());
            date.setText("17.04.2021");
            if (item.getMinPayment() == 0 && item.getMaxPayment() == 0) {
                dot.setVisibility(View.GONE);
                price.setVisibility(View.GONE);
            } else if (item.getMaxPayment() == 0) {
                price.setText("от " + item.getMinPayment() + " ₽");
            } else if (item.getMinPayment() == 0) {
                price.setText("до " + item.getMaxPayment() + " ₽");
            } else {
                price.setText(item.getMinPayment() + " - " + item.getMaxPayment() + " ₽");
            }
            vacancyClick.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onJobResponse(item);
                }
            });

        }
    }

    interface Listener {
        void onJobClick(ModelJob model);

        void onJobResponse(ModelJob model);
    }

}
