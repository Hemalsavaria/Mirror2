package com.e.mirror.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.e.mirror.Fragments.Descritpion;
import com.e.mirror.Fragments.Employee;
import com.e.mirror.Fragments.Reviews;


public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    private String[] tabTitles = new String[]{"Details", "Reviews","Employees"};

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Descritpion descritpion = new Descritpion();
                return descritpion;

            case 1:
                Reviews reviews = new Reviews();
                return reviews;

            case 2:
                Employee employee = new Employee();
                return employee;

            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
