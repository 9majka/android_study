package com.example.oshch.edu;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

public class EduModel {
    private static EduModel sModel;
    private Context mAppContext;
    ArrayList<EduModelItem> mModelItemList;

    private EduModel(Context appContext) {
        mAppContext = appContext;
        mModelItemList = new ArrayList<EduModelItem>();

        for (int i = 0; i < 100; i++) {
            EduModelItem c = new EduModelItem();
            c.setTitle("EduModelItem #" + i);
            //c.setSolved(i % 2 == 0); // Для каждого второго объекта
            mModelItemList.add(c);
        }
    }

    public static EduModel get(Context c) {
        if (sModel == null) {
            sModel = new EduModel(c.getApplicationContext());
        }
        return sModel;
    }

    public ArrayList<EduModelItem> getModelItems() {
        return mModelItemList;
    }

    public EduModelItem getModelItem(UUID id) {
        for (EduModelItem c : mModelItemList) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }

}
