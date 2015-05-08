package com.example.oshch.edu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by oshch on 5/8/15.
 */
public class EduDetailedPagerActivity extends FragmentActivity{
    private ViewPager mViewPager;
    private ArrayList<EduModelItem> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        mItems = EduModel.get(this).getModelItems();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public int getCount() {
                return mItems.size();
            }
            @Override
            public Fragment getItem(int pos) {
                EduModelItem item = mItems.get(pos);
                Log.d("What pos", Integer.toString(pos));
                Log.d("What id", item.getId().toString());
                return EduDetailedFragment.getInstance(item.getId());
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) {
            }

            public void onPageSelected(int pos) {
                EduModelItem item = mItems.get(pos);
                if (item.getTitle() != null) {
                    setTitle(item.getTitle());
                }
            }
        });

        UUID itemId = (UUID)getIntent().getSerializableExtra(EduDetailedFragment.EXTRA_ITEM_ID);
        for (int i = 0; i < mItems.size(); i++) {
            if (mItems.get(i).getId().equals(itemId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
