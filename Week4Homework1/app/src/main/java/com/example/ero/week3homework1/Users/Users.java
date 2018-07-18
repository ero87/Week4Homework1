package com.example.ero.week3homework1.Users;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ero.week3homework1.Adapters.TabAdapter;
import com.example.ero.week3homework1.Fragment.MailFragment;
import com.example.ero.week3homework1.Fragment.PhoneFragment;
import com.example.ero.week3homework1.Fragment.UserFragment;
import com.example.ero.week3homework1.R;

public class Users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tab);

        final TabAdapter tabAdapter =new  TabAdapter(getSupportFragmentManager());
        tabAdapter.addFrament(new UserFragment(), "Users");
        tabAdapter.addFrament(new PhoneFragment(), "Phones");
        tabAdapter.addFrament(new MailFragment(), "e-mail");

        viewPager.setAdapter(tabAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_account);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_call);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_email);
    }
}
