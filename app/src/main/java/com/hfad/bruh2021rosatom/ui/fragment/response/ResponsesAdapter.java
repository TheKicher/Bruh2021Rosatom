package com.hfad.bruh2021rosatom.ui.fragment.response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelResponseJob;


public class ResponsesAdapter extends RecyclerView.Adapter<ResponsesAdapter.ResponseViewHolder> {

    private Listener listener;

    private List<ModelResponseJob.JobResponse> items;

    public ResponsesAdapter(List<ModelResponseJob.JobResponse> items) {
        this.items = items;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setItems(List<ModelResponseJob.JobResponse> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResponseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_response, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ResponseViewHolder extends RecyclerView.ViewHolder {

        private final ImageView dot;
        private final TextView date;
        private final TextView title;
        private final TextView status;

        public ResponseViewHolder(@NonNull View itemView) {
            super(itemView);

            dot = itemView.findViewById(R.id.status_dot);
            status = itemView.findViewById(R.id.status);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);

            itemView.setOnClickListener(view -> {
                        if (listener != null)
                            listener.onResponseClick(items.get(getAdapterPosition()));
                    }
            );
        }

        public void bind(ModelResponseJob.JobResponse item) {
            status.setText(item.getStatus());
            title.setText(item.getJob().getPositionName() + " / " + item.getJob().getOrganization().getName());
            switch (item.getStatus()) {
                case "??????????????":
                    dot.setImageResource(R.drawable.green_dot);
                    break;
                case "????????????????":
                    dot.setImageResource(R.drawable.blue_dot);
                    break;
                case "??????????????????":
                    dot.setImageResource(R.drawable.red_dot);
                    break;
            }
        }
    }

    interface Listener {
        void onResponseClick(ModelResponseJob.JobResponse model);
    }

}
