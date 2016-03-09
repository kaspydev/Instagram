package hackerdudes.com.instagram.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackerdudes.instagram.MainActivity;
import com.hackerdudes.instagram.R;

import hackerdudes.com.instagram.adapters.ProfileListAdapter;
import hackerdudes.com.instagram.utils.GridSpacingItemDecoration;


public class ProfileFragment extends Fragment implements TabLayout.OnTabSelectedListener,
        View.OnClickListener {

    RecyclerView recyclerView;
    ProfileListAdapter adapter;
    LinearLayoutManager layoutManager;
    GridLayoutManager gridLayoutManager;

    public ProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);


        adapter = new ProfileListAdapter(getContext(), this, this);

        gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position > 1 ? 1 : 3);
            }
        });


        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(gridLayoutManager.getSpanCount(), 3, 2));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.getIcon().setColorFilter(Color.argb(100, 52, 139, 217), PorterDuff.Mode.SRC_ATOP);
        if (tab.getPosition() == 0) {
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(adapter);
            ProfileListAdapter.ViewHolder viewHolder = (ProfileListAdapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(1);
        } else if (tab.getPosition() == 1) {
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.getIcon().setColorFilter(Color.argb(100, 160, 164, 167), PorterDuff.Mode.SRC_ATOP);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onClick(View v) {
        String tag = v.getTag(R.id.tagProfile).toString();
        switch (tag) {
            case "posts":
                recyclerView.smoothScrollBy(0, recyclerView.getChildAt(1).getTop());
                break;
            case "followers":
                ((MainActivity) getActivity()).displayFragment(6);
                break;
            case "followings":
                ((MainActivity) getActivity()).displayFragment(7);
                break;
        }
    }
}
