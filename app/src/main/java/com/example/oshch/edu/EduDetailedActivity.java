package com.example.oshch.edu;

import android.support.v4.app.Fragment;
import java.util.UUID;

public class EduDetailedActivity extends IEduActivity {

    @Override
    protected Fragment createFragment() {
        UUID itemId = (UUID)getIntent().getSerializableExtra(EduDetailedFragment.EXTRA_ITEM_ID);
        return EduDetailedFragment.getInstance(itemId);
    }
}