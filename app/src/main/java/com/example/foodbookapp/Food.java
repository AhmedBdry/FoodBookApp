package com.example.foodbookapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private int imageResId;
    private String title ;
    private String price ;

    public Food(int imageResId, String title, String price) {
        this.imageResId = imageResId;
        this.title = title;
        this.price = price;
    }

    protected Food(Parcel in) {
        imageResId = in.readInt();
        title = in.readString();
        price = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResId);
        dest.writeString(title);
        dest.writeString(price);
    }
}
