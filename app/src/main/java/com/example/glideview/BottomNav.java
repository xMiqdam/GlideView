package com.example.glideview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNav extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        bottomNavigationView = findViewById(R.id.bottomViewNav);
        frameLayout = findViewById(R.id.flFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    loadFragment(new home_fragment(), false);
                } else if (itemId == R.id.promo) {
                    loadFragment(new promo_fragment(), false);
                } else if (itemId == R.id.profile) {
                    loadFragment(new profile_fragment(), false);
                } else {
                    loadFragment(new setting_fraagment(), false);
                }

                return true;
            }
        });

        loadFragment(new home_fragment(), true);

    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.flFragment, fragment);
        } else {
            fragmentTransaction.replace(R.id.flFragment, fragment);
        }

        fragmentTransaction.commit();

    }

}

