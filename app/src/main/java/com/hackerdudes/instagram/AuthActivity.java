package com.hackerdudes.instagram;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hackerdudes.instagram.adapters.AuthSectionsAdapter;
import com.hackerdudes.instagram.fragments.fragments.LoginFragment;
import com.hackerdudes.instagram.fragments.fragments.SignUpFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        AuthSectionsAdapter adapter = new AuthSectionsAdapter(getSupportFragmentManager());
        adapter.addFragment(new SignUpFragment(), "Sign Up");
        adapter.addFragment(new LoginFragment(), "Login");
        viewPager.setAdapter(adapter);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(1).select();
    }
}
