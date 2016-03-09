package hackerdudes.com.instagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackerdudes.instagram.R;
import com.hackerdudes.instagram.models.User;

import java.util.ArrayList;

import hackerdudes.com.instagram.adapters.FollowersListAdapter;


public class FollowersFragment extends Fragment {


    public FollowersFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_followers, container, false);


        ArrayList<User> arrayList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            arrayList.add(new User());
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        FollowersListAdapter feedListAdapter = new FollowersListAdapter(arrayList);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(feedListAdapter);
        return rootView;
    }


}
