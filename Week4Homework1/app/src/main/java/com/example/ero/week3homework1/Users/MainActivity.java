package com.example.ero.week3homework1.Users;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.ero.week3homework1.R;
import com.example.ero.week3homework1.UserDataProvider;
import com.example.ero.week3homework1.Adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = findViewById(R.id.viewPager);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(this, UserDataProvider.getListGirl());
        viewPager.setAdapter(adapter);

        final TabLayout tabLayout = findViewById(R.id.tab_Layout);
        tabLayout.setupWithViewPager(viewPager, true);
    }
}
