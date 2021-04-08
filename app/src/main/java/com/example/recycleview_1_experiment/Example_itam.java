package com.example.recycleview_1_experiment;

public class Example_itam {
    private int mImageResource;
    private String mText1;
    private String mText2;


    public Example_itam(int mImageResource, String mText1, String mText2) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public void changeText1(String text) {
        mText1 = text;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }
}
