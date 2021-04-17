package com.hfad.bruh2021rosatom.ui.fragment.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.ui.activity.MainActivity;
import com.hfad.bruh2021rosatom.ui.fragment.base.BaseFragment;
import com.hfad.bruh2021rosatom.ui.fragment.main.MainFragment;

public class LoginFragment extends BaseFragment {

    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authorization, container, false);

        mainActivity = ((MainActivity) getActivity());

        view.findViewById(R.id.button).setOnClickListener(view1 -> mainActivity.setFragment(new MainFragment(), false));

        return view;
    }

    @Override
    public int getStatusBarColorRes() {
        return R.color.background_grey;
    }

    @Override
    public boolean isStatusBarLight() {
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        mainActivity.setBottomNavigationViewVisibility(false);
    }
}
