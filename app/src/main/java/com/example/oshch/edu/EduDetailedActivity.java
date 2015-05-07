package com.example.oshch.edu;

import android.support.v4.app.Fragment;


public class EduDetailedActivity extends IEduActivity {

    @Override
    protected Fragment createFragment() {

        return new EduDetailedFragment();
    }
}