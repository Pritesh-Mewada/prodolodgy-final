package com.prodology.hackathon.prodology;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by pritesh on 12/3/17.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOne();

            case 1:
                return new FragmentTwo();

        }

        return null;


    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Game of Thrones";
            case 1:
                return "Game of Elections";


        }

        return "";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
