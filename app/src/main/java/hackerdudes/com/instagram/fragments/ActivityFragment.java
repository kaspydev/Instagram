package hackerdudes.com.instagram.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackerdudes.instagram.R;

import hackerdudes.com.instagram.adapters.MainSectionsAdapter;


public class ActivityFragment extends Fragment {

    public ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_activity, container, false);

        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);


        MainSectionsAdapter adapter = new MainSectionsAdapter(getChildFragmentManager());
        adapter.addFragment(new NotificationsFragment());
        adapter.addFragment(new NotificationsFragment());
        viewPager.setAdapter(adapter);

        TabLayout tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        tabs.getTabAt(0).setText("FOLLOWING");
        tabs.getTabAt(1).setText("YOU");

        return rootView;
    }


}
