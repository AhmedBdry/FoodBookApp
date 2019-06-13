package com.example.foodbookapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:FragmentBook fragmentBook = new FragmentBook();
            return fragmentBook;
            case 1:FragmentFood fragmentFood = new FragmentFood();
            return fragmentFood;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
