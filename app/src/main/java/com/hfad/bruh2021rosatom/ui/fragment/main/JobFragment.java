package com.hfad.bruh2021rosatom.ui.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelJob;
import com.hfad.bruh2021rosatom.ui.activity.MainActivity;
import com.hfad.bruh2021rosatom.ui.app.App;
import com.hfad.bruh2021rosatom.ui.fragment.detail.JobDetailFragment;
import com.hfad.bruh2021rosatom.ui.fragment.response.CreateResponseFragment;


public class JobFragment extends Fragment implements ScrollableFragment, SearchableFragment {

    private RecyclerView recyclerView;
    private CardView loadingCardView;

    private JobAdapter jobAdapter;

    private List<ModelJob> jobs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        loadingCardView = view.findViewById(R.id.progressbar_container);

        jobAdapter = new JobAdapter(Collections.emptyList());
        jobAdapter.setListener(new JobAdapter.Listener() {
            @Override
            public void onJobClick(ModelJob model) {
                ((MainActivity) getActivity()).setFragment(JobDetailFragment.newInstance(model), true);
            }

            @Override
            public void onJobResponse(ModelJob model) {
                ((MainActivity) getActivity()).setFragment(CreateResponseFragment.newInstance(model), true);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(jobAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        if (jobs == null) {
            App.api.getJobs().enqueue(new Callback<List<ModelJob>>() {
                @Override
                public void onResponse(Call<List<ModelJob>> call, Response<List<ModelJob>> response) {
                    loadingCardView.setVisibility(View.GONE);
                    jobs = response.body();
                    jobAdapter.setItems(jobs);
                }

                @Override
                public void onFailure(Call<List<ModelJob>> call, Throwable t) {
                    loadingCardView.setVisibility(View.GONE);
                }
            });
        }else{
            loadingCardView.setVisibility(View.GONE);
        }

        return view;
    }


    @Override
    public void scrollTop() {
        recyclerView.smoothScrollBy(0, 0);
    }

    @Override
    public void setQuery(String query) {
        ArrayList<ModelJob> list = new ArrayList<>();
        for (ModelJob job : jobs) {
            if (job.getPositionName().toLowerCase().contains(query.toLowerCase()))
                list.add(job);
        }
        jobAdapter.setItems(list);

    }
}
