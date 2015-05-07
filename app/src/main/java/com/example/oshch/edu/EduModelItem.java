package com.example.oshch.edu;

import java.util.Date;
import java.util.UUID;

public class EduModelItem {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public EduModelItem() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public Date getDate() {
        return mDate;
    }
    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
