package com.hackerdudes.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.hackerdudes.instagram.fragments.fragments.FeedFragment;
import com.hackerdudes.instagram.fragments.fragments.SearchFragment;

import hackerdudes.com.instagram.fragments.ActivityFragment;
import hackerdudes.com.instagram.fragments.FindPeopleFragment;
import hackerdudes.com.instagram.fragments.FollowersFragment;
import hackerdudes.com.instagram.fragments.ProfileFragment;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    TabLayout tabLayout;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.search_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.camera_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.notifications_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile_icon));

        tabLayout.setOnTabSelectedListener(this);

        tabLayout.getTabAt(0).select();

        displayFragment(tabLayout.getSelectedTabPosition());
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Log.i("position", Integer.toString(tab.getPosition()));

        displayFragment(tab.getPosition());
    }

    public void displayFragment(int index) {
        switch (index) {
            case 0:
                fragment = new FeedFragment();
                break;
            case 1:
                fragment = new SearchFragment();
                break;
            case 2:
                Intent intent = new Intent(this, TakePictureActivity.class);
                startActivity(intent);
                break;
            case 3:
                fragment = new ActivityFragment();
                break;
            case 4:
                fragment = new ProfileFragment();
                break;
            case 5:
                fragment = new FindPeopleFragment();
                break;
            case 6:
                fragment = new FollowersFragment();
                break;
            case 7:
                fragment = new FollowersFragment();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameContainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
