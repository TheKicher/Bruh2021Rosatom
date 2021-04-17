package com.hfad.bruh2021rosatom.ui.fragment.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.ui.activity.MainActivity;
import com.hfad.bruh2021rosatom.ui.fragment.base.BaseFragment;


public class MainFragment extends BaseFragment {

    private List<FragmentPage> fragmentPages;

    private MainActivity mainActivity;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private EditText search;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<FragmentPage> list = new ArrayList<>();

        // list.add(new FragmentPage("Работа", new JobFragment(), FragmentPage.TYPE_JOB));
        list.add(new FragmentPage("Стажировка", new InternshipFragment(), FragmentPage.TYPE_INTERNSHIP));

        fragmentPages = list;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mainActivity = (MainActivity) getActivity();

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        search = view.findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ((SearchableFragment) fragmentPages.get(viewPager.getCurrentItem()).getFragment()).setQuery(editable.toString());
            }
        });

        viewPager.setAdapter(new PageAdapter(fragmentPages, getChildFragmentManager()));

        viewPager.setPageMargin((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16F, getResources().getDisplayMetrics()));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                search.setText("", TextView.BufferType.EDITABLE);
                for (FragmentPage fragmentPage : fragmentPages) {
                    ((SearchableFragment) fragmentPage.getFragment()).setQuery("");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                FragmentPage fragmentPage = fragmentPages.get(tab.getPosition());
                fragmentPage.scrollTop();
            }
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mainActivity.setBottomNavigationViewVisibility(true);
    }

    @Override
    public int getStatusBarColorRes() {
        return R.color.background_grey;
    }

    @Override
    public boolean isStatusBarLight() {
        return true;
    }

    public static class PageAdapter extends FragmentPagerAdapter {

        private final List<FragmentPage> fragmentPages;

        public PageAdapter(List<FragmentPage> fragmentPages, FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fragmentPages = fragmentPages;
        }

        private Fragment currentFragment = null;

        @Override
        public int getCount() {
            return fragmentPages.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentPages.get(position).getTitle();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentPages.get(position).getFragment();
        }

        @Override
        public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            super.setPrimaryItem(container, position, object);
            FragmentPage fragmentPage = fragmentPages.get(position);
            currentFragment = (Fragment) object;
            if (currentFragment == fragmentPage.fragment) {
                return;
            }
            fragmentPage.fragment = currentFragment;
        }

    }

    public static class FragmentPage {


        public final static int TYPE_JOB = 0;
        public final static int TYPE_INTERNSHIP = 1;

        private String title;
        private Fragment fragment;
        private int type;

        public FragmentPage(String title, Fragment fragment, int type) {
            this.title = title;
            this.fragment = fragment;
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public void setFragment(Fragment fragment) {
            this.fragment = fragment;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void scrollTop() {
            ((ScrollableFragment) fragment).scrollTop();
        }


    }


}
