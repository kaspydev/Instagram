package com.hackerdudes.instagram.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AuthSectionsAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragments = new ArrayList<>();
    List<String> mFragmentLabels = new ArrayList<>();

    public AuthSectionsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void addFragment(Fragment fragment, String label) {
        mFragments.add(fragment);
        mFragmentLabels.add(label);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentLabels.get(position);
    }
}
