package com.kencorp.androidanimationexample;

import android.os.Parcel;
import android.os.Parcelable;


public class Equipment implements Parcelable {

    public String Id;
    public String Isbn;
    public String name;
    public String status;//pret , fonctionnelle, en panne
//    public TypeEquipment typeName;
    public String Category;
    public Integer ImageEquipment;
    public String dateDeMiseEnService;
    public String positionCourante; // en service ou au magasin
    public String dateDeFabrique;
    public String modele;
    public String manufacturer;


    public Equipment() {
    }
    public Equipment(String isbn, String name, String status, String category,
                     Integer imageEquipment, String Id) {
        Isbn = isbn;
        this.name = name;
        this.status = status;
        Category = category;
        ImageEquipment = imageEquipment;
        this.Id = Id;
    }

    public Equipment(String isbn, String name, String status, String category, Integer imageEquipment) {
        Isbn = isbn;
        this.name = name;
        this.status = status;
        Category = category;
        ImageEquipment = imageEquipment;
    }

    protected Equipment(Parcel in) {
        Isbn = in.readString();
        name = in.readString();
        status = in.readString();
        Category = in.readString();
        if (in.readByte() == 0) {
            ImageEquipment = null;
        } else {
            ImageEquipment = in.readInt();
        }
        Id = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Isbn);
        dest.writeString(name);
        dest.writeString(status);
        dest.writeString(Category);
        if (ImageEquipment == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ImageEquipment);
        }
        dest.writeString(Id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Equipment> CREATOR = new Creator<Equipment>() {
        @Override
        public Equipment createFromParcel(Parcel in) {
            return new Equipment(in);
        }

        @Override
        public Equipment[] newArray(int size) {
            return new Equipment[size];
        }
    };

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Integer getImageEquipment() {
        return ImageEquipment;
    }

    public void setImageEquipment(Integer imageEquipment) {
        ImageEquipment = imageEquipment;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
