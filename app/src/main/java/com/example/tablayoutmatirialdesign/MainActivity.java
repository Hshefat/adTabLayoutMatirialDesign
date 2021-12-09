package com.example.tablayoutmatirialdesign;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ViewParent;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private Fragment_explore fragment_explore;
    private Fragment_flights fragment_flights;
    private Fragment_travel fragment_travel;
    private Fragment_zoo fragment_zoo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/


       viewPager = findViewById(R.id.viewpager);
       tabLayout = findViewById(R.id.tablayout);

       fragment_explore = new Fragment_explore();
       fragment_flights = new Fragment_flights();
       fragment_travel = new Fragment_travel();
       fragment_zoo = new Fragment_zoo();

       tabLayout.setupWithViewPager(viewPager);

       ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
       viewPagerAdapter.addFragment(fragment_explore, "Explore");
       viewPagerAdapter.addFragment(fragment_flights, "Flights");
       viewPagerAdapter.addFragment(fragment_travel, "Travel");
       viewPagerAdapter.addFragment(fragment_zoo, "Zoo");
       viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_explore_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_flight_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_card_travel_24);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_baseline_card_travel_24);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentTitle.add(title);

        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }

    }
}