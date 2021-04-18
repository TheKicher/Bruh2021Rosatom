package com.hfad.bruh2021rosatom.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.hfad.bruh2021rosatom.R;
import com.hfad.bruh2021rosatom.ui.fragment.login.LoginFragment;
import com.hfad.bruh2021rosatom.ui.fragment.main.MainFragment;
import com.hfad.bruh2021rosatom.ui.fragment.more.MoreFragment;
import com.hfad.bruh2021rosatom.ui.fragment.response.ResponsesFragment;
import com.hfad.bruh2021rosatom.ui.fragment.resume.ResumeFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_more:
                    fragment = new MoreFragment();
                    break;
                case R.id.navigation_reply:
                    fragment = new ResponsesFragment();
                    break;
                case R.id.navigation_profile:
                   fragment = new ResumeFragment();
                   break;
                default:
                    fragment = new MainFragment();
            }

            setFragment(fragment, true);

            return true;
        });

        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, new LoginFragment()).commit();
    }


    public void setFragment(Fragment fragment, boolean isAddToBackStack) {
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment);
        if (isAddToBackStack)
            fr.addToBackStack(null);
        fr.commit();
    }

    public void setBottomNavigationViewVisibility(boolean isVisible) {
        if (isVisible) {
            bottomNavigationView.setVisibility(View.VISIBLE);
        } else {
            bottomNavigationView.setVisibility(View.GONE);
        }
    }
}