package com.hfad.bruh2021rosatom.ui.fragment.resume;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelResume;
import com.hfad.bruh2021rosatom.ui.app.App;
import com.hfad.bruh2021rosatom.ui.fragment.base.BaseFragment;


public class ResumeFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private CardView loadingCardView;

    private TextView surname;
    private TextView number;
    private TextView email;
    private TextView telegram;
    private TextView description;

    private TextView institute;
    private TextView group;

    private ResumeAdapter resumeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resume, container, false);

        surname = view.findViewById(R.id.surname);
        number = view.findViewById(R.id.number);
        email = view.findViewById(R.id.email);
        telegram = view.findViewById(R.id.telegram);
        description = view.findViewById(R.id.description);
        institute = view.findViewById(R.id.institute);
        group = view.findViewById(R.id.group);

        recyclerView = view.findViewById(R.id.recycler_view);
        loadingCardView = view.findViewById(R.id.progressbar_container);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setNestedScrollingEnabled(false);

        resumeAdapter = new ResumeAdapter(Collections.EMPTY_LIST);
        recyclerView.setAdapter(resumeAdapter);


        App.api.getResume().enqueue(new Callback<ModelResume>() {
            @Override
            public void onResponse(Call<ModelResume> call, Response<ModelResume> response) {
                loadingCardView.setVisibility(View.GONE);
                resumeAdapter.setItems(response.body().getUserProfile().getJobExperienses());

                surname.setText("Гробовщик Артем");
                number.setText(response.body().getUserProfile().getPhone());
                email.setText("grob@mail.ru");
                telegram.setText(response.body().getUserProfile().getTelegram());

                description.setText(response.body().getUserProfile().getAboutMe());
                institute.setText(response.body().getUserProfile().getInstitute().getName());
                group.setText(response.body().getUserProfile().getSpeciality().getName());
            }

            @Override
            public void onFailure(Call<ModelResume> call, Throwable t) {
                loadingCardView.setVisibility(View.GONE);
            }
        });


        return view;
    }

    @Override
    public int getStatusBarColorRes() {
        return android.R.color.white;
    }

    @Override
    public boolean isStatusBarLight() {
        return true;
    }

}
