package com.crysoft.me.bankx.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maxx on 9/29/2016.
 */

public class MicroFinanceModel implements Parcelable{

    private String microFinanceName;
    private String microFinanceImage;
    private String microFinanceAddress;
    private String microFinanceSwiftCode;
    private String microFinanceStockCode;
    private String microFinanceDescription;
    private String microFinanceEstablished;
    private String microFinanceContacts;
    private String microFinanceType;
    private String microFinanceWebsite;
    private String microFinanceObjectId;
    private String microFinanceSummary;

    public String getMicroFinanceStatus() {
        return microFinanceStatus;
    }

    public void setMicroFinanceStatus(String microFinanceStatus) {
        this.microFinanceStatus = microFinanceStatus;
    }

    private String microFinanceStatus;

    public String getMicroFinanceObjectId() {
        return microFinanceObjectId;
    }

    public void setMicroFinanceObjectId(String microFinanceObjectId) {
        this.microFinanceObjectId = microFinanceObjectId;
    }


    public String getMicroFinanceName() {
        return microFinanceName;
    }

    public void setMicroFinanceName(String microFinanceName) {
        this.microFinanceName = microFinanceName;
    }

    public String getMicroFinanceImage() {
        return microFinanceImage;
    }

    public void setMicroFinanceImage(String microFinanceImage) {
        this.microFinanceImage = microFinanceImage;
    }

    public String getMicroFinanceAddress() {
        return microFinanceAddress;
    }

    public void setMicroFinanceAddress(String microFinanceAddress) {
        this.microFinanceAddress = microFinanceAddress;
    }

    public String getMicroFinanceSwiftCode() {
        return microFinanceSwiftCode;
    }

    public String getMicroFinanceSummary() {
        return microFinanceSummary;
    }

    public void setMicroFinanceSummary(String microFinanceSummary) {
        this.microFinanceSummary = microFinanceSummary;
    }

    public void setMicroFinanceSwiftCode(String microFinanceSwiftCode) {

        this.microFinanceSwiftCode = microFinanceSwiftCode;
    }

    public String getMicroFinanceStockCode() {
        return microFinanceStockCode;
    }

    public void setMicroFinanceStockCode(String microFinanceStockCode) {
        this.microFinanceStockCode = microFinanceStockCode;
    }

    public String getMicroFinanceDescription() {
        return microFinanceDescription;
    }

    public void setMicroFinanceDescription(String microFinanceDescription) {
        this.microFinanceDescription = microFinanceDescription;
    }

    public String getMicroFinanceEstablished() {
        return microFinanceEstablished;
    }

    public void setMicroFinanceEstablished(String microFinanceEstablished) {
        this.microFinanceEstablished = microFinanceEstablished;
    }

    public String getMicroFinanceContacts() {
        return microFinanceContacts;
    }

    public void setMicroFinanceContacts(String microFinanceContacts) {
        this.microFinanceContacts = microFinanceContacts;
    }

    public String getMicroFinanceType() {
        return microFinanceType;
    }

    public void setMicroFinanceType(String microFinanceType) {
        this.microFinanceType = microFinanceType;
    }

    public String getMicroFinanceWebsite() {
        return microFinanceWebsite;
    }

    public void setMicroFinanceWebsite(String microFinanceWebsite) {
        this.microFinanceWebsite = microFinanceWebsite;
    }


    public MicroFinanceModel(Parcel in) {

        String[] array = new String[13];
        in.readStringArray(array);

        microFinanceName = array[0];
        microFinanceImage = array[1];
        microFinanceAddress = array[2];
        microFinanceSwiftCode = array[3];
        microFinanceStockCode = array[4];
        microFinanceDescription = array[5];
        microFinanceEstablished = array[6];
        microFinanceContacts = array[7];
        microFinanceType = array[8];
        microFinanceWebsite = array[9];
        microFinanceObjectId = array[10];
        microFinanceStatus = array[11];
        microFinanceSummary = array[12];
    }

    public MicroFinanceModel() {

    }

    public static final Parcelable.Creator<MicroFinanceModel> CREATOR = new Parcelable.Creator<MicroFinanceModel>() {
        @Override
        public MicroFinanceModel createFromParcel(Parcel in) {
            return new MicroFinanceModel(in);
        }

        @Override
        public MicroFinanceModel[] newArray(int size) {
            return new MicroFinanceModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this.microFinanceName,
                this.microFinanceImage,
                this.microFinanceAddress,
                this.microFinanceSwiftCode,
                this.microFinanceStockCode,
                this.microFinanceDescription,
                this.microFinanceEstablished,
                this.microFinanceContacts,
                this.microFinanceType,
                this.microFinanceWebsite,
                this.microFinanceObjectId,
                this.microFinanceStatus,
                this.microFinanceSummary});
    }
}
