package com.crysoft.me.bankx.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maxx on 9/29/2016.
 */

public class ForexBureauModel implements Parcelable {

    private String forexBureauName;
    private String forexBureauImage;
    private String forexBureauAddress;
    private String forexBureauSwiftCode;
    private String forexBureauStockCode;
    private String forexBureauDescription;
    private String forexBureauEstablished;
    private String forexBureauObjectId;
    private String forexBureauContacts;
    private String forexBureauType;
    private String forexBureauWebsite;
    private String forexBureauStatus;
    private String forexBureauSummary;

    public String getForexBureauStatus() {
        return forexBureauStatus;
    }

    public void setForexBureauStatus(String forexBureauStatus) {
        this.forexBureauStatus = forexBureauStatus;
    }


    public String getForexBureauObjectId() {
        return forexBureauObjectId;
    }

    public void setForexBureauObjectId(String forexBureauObjectId) {
        this.forexBureauObjectId = forexBureauObjectId;
    }


    public ForexBureauModel(Parcel in) {

        String[] array = new String[13];
        in.readStringArray(array);

        forexBureauName = array[0];
        forexBureauImage = array[1];
        forexBureauAddress = array[2];
        forexBureauSwiftCode = array[3];
        forexBureauStockCode = array[4];
        forexBureauDescription = array[5];
        forexBureauEstablished = array[6];
        forexBureauContacts = array[7];
        forexBureauType = array[8];
        forexBureauWebsite = array[9];
        forexBureauObjectId = array[10];
        forexBureauStatus = array[11];
        forexBureauSummary = array[12];
    }

    public ForexBureauModel() {

    }

    public static final Parcelable.Creator<ForexBureauModel> CREATOR = new Parcelable.Creator<ForexBureauModel>() {
        @Override
        public ForexBureauModel createFromParcel(Parcel in) {
            return new ForexBureauModel(in);
        }

        @Override
        public ForexBureauModel[] newArray(int size) {
            return new ForexBureauModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getForexBureauName() {
        return forexBureauName;
    }

    public void setForexBureauName(String forexBureauName) {
        this.forexBureauName = forexBureauName;
    }

    public String getForexBureauImage() {
        return forexBureauImage;
    }

    public void setForexBureauImage(String forexBureauImage) {
        this.forexBureauImage = forexBureauImage;
    }

    public String getForexBureauAddress() {
        return forexBureauAddress;
    }

    public void setForexBureauAddress(String forexBureauAddress) {
        this.forexBureauAddress = forexBureauAddress;
    }

    public String getForexBureauSwiftCode() {
        return forexBureauSwiftCode;
    }

    public void setForexBureauSwiftCode(String forexBureauSwiftCode) {
        this.forexBureauSwiftCode = forexBureauSwiftCode;
    }

    public String getForexBureauStockCode() {
        return forexBureauStockCode;
    }

    public String getForexBureauSummary() {
        return forexBureauSummary;
    }

    public void setForexBureauSummary(String forexBureauSummary) {
        this.forexBureauSummary = forexBureauSummary;
    }

    public void setForexBureauStockCode(String forexBureauStockCode) {
        this.forexBureauStockCode = forexBureauStockCode;
    }

    public String getForexBureauDescription() {
        return forexBureauDescription;
    }

    public void setForexBureauDescription(String forexBureauDescription) {
        this.forexBureauDescription = forexBureauDescription;
    }

    public String getForexBureauEstablished() {
        return forexBureauEstablished;
    }

    public void setForexBureauEstablished(String forexBureauEstablished) {
        this.forexBureauEstablished = forexBureauEstablished;
    }

    public String getForexBureauContacts() {
        return forexBureauContacts;
    }

    public void setForexBureauContacts(String forexBureauContacts) {
        this.forexBureauContacts = forexBureauContacts;
    }

    public String getForexBureauType() {
        return forexBureauType;
    }

    public void setForexBureauType(String forexBureauType) {
        this.forexBureauType = forexBureauType;
    }

    public String getForexBureauWebsite() {
        return forexBureauWebsite;
    }

    public void setForexBureauWebsite(String forexBureauWebsite) {
        this.forexBureauWebsite = forexBureauWebsite;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeStringArray(new String[]{
                this.forexBureauName,
                this.forexBureauImage,
                this.forexBureauAddress,
                this.forexBureauSwiftCode,
                this.forexBureauStockCode,
                this.forexBureauDescription,
                this.forexBureauEstablished,
                this.forexBureauContacts,
                this.forexBureauType,
                this.forexBureauWebsite,
                this.forexBureauObjectId,
                this.forexBureauStatus,
                this.forexBureauSummary});
    }
}
