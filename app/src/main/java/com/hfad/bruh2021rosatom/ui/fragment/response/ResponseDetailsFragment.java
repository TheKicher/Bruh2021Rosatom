package com.hfad.bruh2021rosatom.ui.fragment.response;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelResponseJob;
import com.hfad.bruh2021rosatom.ui.activity.MainActivity;
import com.hfad.bruh2021rosatom.ui.fragment.base.BaseFragment;


public class ResponseDetailsFragment extends BaseFragment {

    private static ModelResponseJob.JobResponse model;

    private TextView city;
    private TextView position;
    private TextView price;
    private TextView experience;
    private TextView attendance;

    private EditText response;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_response_details, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(view1 -> {
            getParentFragmentManager().popBackStack();
        });

        response = view.findViewById(R.id.response);
        city = view.findViewById(R.id.city);
        position = view.findViewById(R.id.name);
        price = view.findViewById(R.id.salary);
        experience = view.findViewById(R.id.experience);
        attendance = view.findViewById(R.id.attendance);

        response.setText(model.getLetter());

        city.setText(model.getJob().getOrganization().getCity());
        position.setText(model.getJob().getPositionName());
        experience.setText(model.getJob().getJobExperience());
        attendance.setText(model.getJob().getJobAttendanceType());

        if (model.getJob().getMinPayment() == 0 && model.getJob().getMaxPayment() == 0) {
            price.setVisibility(View.GONE);
        } else if (model.getJob().getMaxPayment() == 0) {
            price.setText("от " + model.getJob().getMinPayment() + " ₽");
        } else if (model.getJob().getMinPayment() == 0) {
            price.setText("до " + model.getJob().getMaxPayment() + " ₽");
        } else {
            price.setText(model.getJob().getMinPayment() + " - " + model.getJob().getMaxPayment() + " ₽");
        }

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

    public static ResponseDetailsFragment newInstance(ModelResponseJob.JobResponse model) {
        ResponseDetailsFragment.model = model;
        return new ResponseDetailsFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).setBottomNavigationViewVisibility(false);
    }
}
