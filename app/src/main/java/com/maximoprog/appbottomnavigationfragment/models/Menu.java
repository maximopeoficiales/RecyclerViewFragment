package com.maximoprog.appbottomnavigationfragment.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu  implements Parcelable {
    private int id;
    private String title;
    private String price;
    private String description;
    private int image;

    public Menu(int id, String title, String price, String description, int image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    protected Menu(Parcel in) {
        id = in.readInt();
        title = in.readString();
        price = in.readString();
        description = in.readString();
        image = in.readInt();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(price);
        dest.writeString(description);
        dest.writeInt(image);
    }
}
