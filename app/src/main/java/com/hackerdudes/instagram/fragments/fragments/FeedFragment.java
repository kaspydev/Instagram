package com.hackerdudes.instagram.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackerdudes.instagram.R;
import com.hackerdudes.instagram.models.Post;

import java.util.ArrayList;

import hackerdudes.com.instagram.adapters.FeedListAdapter;

public class FeedFragment extends Fragment {

    RecyclerView recyclerView;

    public FeedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);


        ArrayList<Post> posts = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            posts.add(new Post());
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        FeedListAdapter adapter = new FeedListAdapter(posts);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return rootView;
    }


}
