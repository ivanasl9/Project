package com.example.project;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.project.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        HomeFragment homeFragment = new HomeFragment();
        LearnMoreFragment learnMoreFragment = new LearnMoreFragment();
        InfoFragment infoFragment = new InfoFragment();


        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();

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