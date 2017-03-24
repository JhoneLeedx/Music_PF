package com.jhonlee.musicpf.view.rank;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/23.
 */

public class RankPageAdapter extends FragmentPagerAdapter {

    private String[] titles;
    private List<Fragment> mList;

    public RankPageAdapter(FragmentManager fm, String[] titles, List<Fragment> mList) {
        super(fm);
        this.titles = titles;
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position % titles.length];
    }
}
