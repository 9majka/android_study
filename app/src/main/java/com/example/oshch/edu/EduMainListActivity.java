package com.example.oshch.edu;

import android.support.v4.app.Fragment;

public class EduMainListActivity extends IEduActivity {

    @Override
    protected Fragment createFragment() {
        return new EduListFragment();
    }

}
