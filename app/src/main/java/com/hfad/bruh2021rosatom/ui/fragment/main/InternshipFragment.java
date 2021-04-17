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
import com.hfad.bruh2021rosatom.model.ModelInternshipment;
import com.hfad.bruh2021rosatom.ui.activity.MainActivity;
import com.hfad.bruh2021rosatom.ui.app.App;
import com.hfad.bruh2021rosatom.ui.fragment.detail.InternshipmentDetailFragment;


public class InternshipFragment extends Fragment implements ScrollableFragment, SearchableFragment {

    private RecyclerView recyclerView;
    private CardView loadingCardView;

    private InternshipAdapter internshipAdapter;

    private List<ModelInternshipment> internships;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        loadingCardView = view.findViewById(R.id.progressbar_container);

        internshipAdapter = new InternshipAdapter(Collections.emptyList());
        internshipAdapter.setListener(new InternshipAdapter.Listener() {

            @Override
            public void onInternshipmentResponse(ModelInternshipment model) {

            }

            @Override
            public void onInternshipmentClick(ModelInternshipment model) {
                ((MainActivity) getActivity()).setFragment(InternshipmentDetailFragment.newInstance(model), true);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(internshipAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        if (internships == null) {
            App.api.getInternshipments().enqueue(new Callback<List<ModelInternshipment>>() {
                @Override
                public void onResponse(Call<List<ModelInternshipment>> call, Response<List<ModelInternshipment>> response) {
                    loadingCardView.setVisibility(View.GONE);
                    internships = response.body();
                    internshipAdapter.setItems(internships);
                }

                @Override
                public void onFailure(Call<List<ModelInternshipment>> call, Throwable t) {
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
        ArrayList<ModelInternshipment> list = new ArrayList<>();
        for (ModelInternshipment internship : internships) {
            if (internship.getName().toLowerCase().contains(query.toLowerCase()))
                list.add(internship);
        }
        internshipAdapter.setItems(list);

    }
}
