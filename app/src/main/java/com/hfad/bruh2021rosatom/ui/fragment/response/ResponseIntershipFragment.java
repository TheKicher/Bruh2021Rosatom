package com.hfad.bruh2021rosatom.ui.fragment.response;

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

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelResponseInternship;
import com.hfad.bruh2021rosatom.ui.app.App;
import com.hfad.bruh2021rosatom.ui.fragment.main.ScrollableFragment;


public class ResponseIntershipFragment extends Fragment implements ScrollableFragment {

    private RecyclerView recyclerView;
    private CardView loadingCardView;

    private ResponseIntershipAdapter internshipAdapter;

    private List<ModelResponseInternship.InternshipResponse> internships;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        loadingCardView = view.findViewById(R.id.progressbar_container);

        internshipAdapter = new ResponseIntershipAdapter(Collections.emptyList());
        internshipAdapter.setListener(model -> {

        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(internshipAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        App.api.getResponseInternship().enqueue(new Callback<ModelResponseInternship>() {
                @Override
                public void onResponse(Call<ModelResponseInternship> call, Response<ModelResponseInternship> response) {
                    loadingCardView.setVisibility(View.GONE);
                    internships = response.body().getInternshipResponses();
                    internshipAdapter.setItems(internships);
                }

                @Override
                public void onFailure(Call<ModelResponseInternship> call, Throwable t) {
                    loadingCardView.setVisibility(View.GONE);
                }
            });

        return view;
    }

    @Override
    public void scrollTop() {
        recyclerView.smoothScrollBy(0, 0);
    }

}
