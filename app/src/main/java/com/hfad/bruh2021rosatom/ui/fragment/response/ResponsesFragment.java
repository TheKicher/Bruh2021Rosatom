package com.hfad.bruh2021rosatom.ui.fragment.response;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.model.ModelResponseJob;
import com.hfad.bruh2021rosatom.ui.activity.MainActivity;
import com.hfad.bruh2021rosatom.ui.fragment.base.BaseFragment;
import com.hfad.bruh2021rosatom.ui.fragment.main.MainFragment;


public class ResponsesFragment extends BaseFragment {

    private ResponsesAdapter adapter;
    private RecyclerView recyclerView;
    private CardView loading;


    private List<MainFragment.FragmentPage> fragmentPages;

    private MainActivity mainActivity;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private List<ModelResponseJob.JobResponse> responseList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<MainFragment.FragmentPage> list = new ArrayList<>();

        list.add(new MainFragment.FragmentPage("Работа", new ResponseJobFragment(), MainFragment.FragmentPage.TYPE_JOB));
        list.add(new MainFragment.FragmentPage("Стажировка", new ResponseIntershipFragment(), MainFragment.FragmentPage.TYPE_INTERNSHIP));

        fragmentPages = list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_responses, container, false);

        mainActivity = ((MainActivity) getActivity());

        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tabLayout);

        viewPager.setAdapter(new MainFragment.PageAdapter(fragmentPages, getChildFragmentManager()));

        viewPager.setPageMargin((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16F, getResources().getDisplayMetrics()));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                MainFragment.FragmentPage fragmentPage = fragmentPages.get(tab.getPosition());
                fragmentPage.scrollTop();
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

    @Override
    public void onStart() {
        super.onStart();
        mainActivity.setBottomNavigationViewVisibility(true);
    }

}