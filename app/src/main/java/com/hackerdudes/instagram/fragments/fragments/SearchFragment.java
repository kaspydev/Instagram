package com.hackerdudes.instagram.fragments.fragments;


import android.os.Bundle;
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
import com.hackerdudes.instagram.models.Post;

import java.util.ArrayList;

import hackerdudes.com.instagram.adapters.FeedListAdapter;
import hackerdudes.com.instagram.adapters.SearchListAdapter;
import hackerdudes.com.instagram.utils.GridSpacingItemDecoration;

public class SearchFragment extends Fragment {

    RecyclerView recyclerView;

    public SearchFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);


        ArrayList<Post> posts = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            posts.add(new Post());
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position == 0 ? 3 : 1);
            }
        });

        SearchListAdapter adapter = new SearchListAdapter(getActivity(), posts, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).displayFragment(5);
            }
        });

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, 3, 1));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        return rootView;
//        return inflater.inflate(R.layout.fragment_search, container, false);
    }


}
