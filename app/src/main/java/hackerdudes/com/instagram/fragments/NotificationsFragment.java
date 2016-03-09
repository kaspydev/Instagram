package hackerdudes.com.instagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackerdudes.instagram.R;
import com.hackerdudes.instagram.models.Notification;

import java.util.ArrayList;

import hackerdudes.com.instagram.adapters.NotificationsListAdapter;


public class NotificationsFragment extends Fragment {


    public NotificationsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);


        ArrayList<Notification> arrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            arrayList.add(new Notification());
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        NotificationsListAdapter feedListAdapter = new NotificationsListAdapter(arrayList);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(feedListAdapter);
        return rootView;
    }


}
