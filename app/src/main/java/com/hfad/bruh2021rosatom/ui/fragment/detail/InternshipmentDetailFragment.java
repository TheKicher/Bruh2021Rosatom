package com.hfad.bruh2021rosatom.ui.fragment.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelInternshipResponseRequest;
import com.hfad.bruh2021rosatom.model.ModelInternshipment;
import com.hfad.bruh2021rosatom.ui.activity.MainActivity;
import com.hfad.bruh2021rosatom.ui.app.App;
import com.hfad.bruh2021rosatom.ui.fragment.base.BaseFragment;


public class InternshipmentDetailFragment extends BaseFragment {

    private static ModelInternshipment model;

    private Toolbar toolbar;
    private TextView city;
    private TextView name;
    private TextView company;
    private TextView description;
    private RecyclerView recyclerView;
    private TextView surname;
    private TextView number;
    private TextView email;
    private TextView telegram;
    private TextView date;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_position, container, false);

        recyclerView = view.findViewById(R.id.skills);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList<String> skills = new ArrayList<>();
        for (ModelInternshipment.RequiredSkill requiredSkill : model.getRequiredSkills()) {
            skills.add(requiredSkill.getName());
        }
        recyclerView.setAdapter(new SkillsAdapter(skills));

        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(view1 -> {
            getParentFragmentManager().popBackStack();
        });

        city = view.findViewById(R.id.city);
        name = view.findViewById(R.id.name);
        company = view.findViewById(R.id.company);
        description = view.findViewById(R.id.description);
        surname = view.findViewById(R.id.surname);
        number = view.findViewById(R.id.number);
        email = view.findViewById(R.id.email);
        telegram = view.findViewById(R.id.telegram);
        date = view.findViewById(R.id.date);

        city.setText(model.getOrganization().getCity());
        name.setText(model.getName());
        company.setText(model.getOrganization().getName());
        description.setText(model.getDescription());
        surname.setText(model.getOrganization().getAgentName());
        number.setText(model.getOrganization().getPhone());
        email.setText(model.getOrganization().getAgentEmail());
        telegram.setText(model.getOrganization().getTelegram());

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(view12 -> {
            ModelInternshipResponseRequest request = new ModelInternshipResponseRequest();
            request.setUser("api/users/1");
            request.setInternship("api/interships/" + model.getId());

            App.api.createInternshipResponse(request);
            view12.setVisibility(View.GONE);
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

    public static InternshipmentDetailFragment newInstance(ModelInternshipment model) {
        InternshipmentDetailFragment.model = model;
        return new InternshipmentDetailFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).setBottomNavigationViewVisibility(false);
    }

}
