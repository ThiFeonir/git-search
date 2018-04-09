package com.example.thiago.gitsearch.Domain;

public class CardItem {
    private String mImageResource;
    private String mText1;
    private String mText2;
    private String mText3;

    public String getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }

    public String getText3(){
        return mText3;}

    public void setText2(String mText2) {
        this.mText2 = mText2;
    }

    public CardItem(String mImageResource, String mText1, String mText2, String mText3) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mText2 = mText2;
        this.mText3 = mText3;

    }
}
