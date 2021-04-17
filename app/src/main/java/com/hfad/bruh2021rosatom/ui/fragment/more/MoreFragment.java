package com.hfad.bruh2021rosatom.ui.fragment.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.ui.fragment.base.BaseFragment;

public class MoreFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);

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
