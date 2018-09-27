package com.example.leidong.fresher.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Lei Dong on 2018/9/27.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentList;

    public MyFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        if(fragmentList.size() > 0) {
            return fragmentList.get(i);
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
