package com.rvag.todolistfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.rvag.todolistfragments.adapters.ViewPagerAdapter;
import com.rvag.todolistfragments.fragments.CustomListFragment;
import com.rvag.todolistfragments.fragments.ListFragment;
import com.rvag.todolistfragments.fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPager.setAdapter(
                    new ViewPagerAdapter(
                            getSupportFragmentManager(), buildListFragments()));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.listfragment);
        tabLayout.getTabAt(1).setIcon(R.drawable.customlistfragment);
        tabLayout.getTabAt(2).setIcon(R.drawable.recyclerlistfragment);
    }

    private ArrayList<Fragment> buildListFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListFragment());
        fragments.add(new CustomListFragment());
        fragments.add(new RecyclerViewFragment());

        return  fragments;
    }
}
