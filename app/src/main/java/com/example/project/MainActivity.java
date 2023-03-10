package com.example.project;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.project.databinding.ActivityMainBinding;
import com.example.project.fragments.HomeFragment;
import com.example.project.fragments.InfoFragment;
import com.example.project.fragments.LearnMoreFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        HomeFragment homeFragment = HomeFragment.newInstance();

        LearnMoreFragment learnMoreFragment = LearnMoreFragment.newInstance();
        InfoFragment infoFragment = new InfoFragment();

        BadgeDrawable badgeDrawable = binding.bottomNavigation.getOrCreateBadge(R.id.learnMore_icon);
        badgeDrawable.setNumber(8);
        badgeDrawable.setVisible(true);


        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment, "home_fragment").commit();

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.home_icon):
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                        return true;

                    case (R.id.learnMore_icon):
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, learnMoreFragment).commit();
                        return true;

                    case (R.id.info_icon):
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, infoFragment).commit();
                        return true;

                }
                return false;
            }
        });
    }
}