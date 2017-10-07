package loboda.elementary.app.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Lobster on 07.10.17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Fragment mFragments[];
    private String mTitles[];

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    public void setFragments(Fragment... fragments) {
        mFragments = fragments;
    }

    public void setTitles(String titles[]) {
        mTitles = titles;
    }
}
