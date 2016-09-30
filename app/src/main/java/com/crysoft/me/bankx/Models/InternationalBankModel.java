package com.crysoft.me.bankx.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maxx on 9/29/2016.
 */

public class InternationalBankModel implements Parcelable{

    private String internationalBankName;
    private String internationalBankImage;
    private String internationalBankAddress;
    private String internationalBankSwiftCode;
    private String internationalBankStockCode;
    private String internationalBankDescription;
    private String internationalBankEstablished;
    private String internationalBankContacts;
    private String internationalBankType;

    public String getInternationalBankSummary() {
        return internationalBankSummary;
    }

    public void setInternationalBankSummary(String internationalBankSummary) {
        this.internationalBankSummary = internationalBankSummary;
    }

    private String internationalBankWebsite;
    private String internationalBankObjectId;
    private String internationalBankStatus;
    private String internationalBankSummary;

    public String getInternationalBankStatus() {
        return internationalBankStatus;
    }

    public void setInternationalBankStatus(String internationalBankStatus) {
        this.internationalBankStatus = internationalBankStatus;
    }

    public String getInternationalBankObjectId() {

        return internationalBankObjectId;
    }

    public void setInternationalBankObjectId(String internationalBankObjectId) {
        this.internationalBankObjectId = internationalBankObjectId;
    }


    public InternationalBankModel(Parcel in) {

        String[] array = new String[13];
        in.readStringArray(array);

        internationalBankName = array[0];
        internationalBankImage = array[1];
        internationalBankAddress = array[2];
        internationalBankSwiftCode = array[3];
        internationalBankStockCode = array[4];
        internationalBankDescription = array[5];
        internationalBankEstablished = array[6];
        internationalBankContacts = array[7];
        internationalBankType = array[8];
        internationalBankWebsite = array[9];
        internationalBankObjectId = array[10];
        internationalBankStatus = array[11];
        internationalBankSummary = array[12];
    }

    public InternationalBankModel() {

    }

    public static final Parcelable.Creator<InternationalBankModel> CREATOR = new Parcelable.Creator<InternationalBankModel>() {
        @Override
        public InternationalBankModel createFromParcel(Parcel in) {
            return new InternationalBankModel(in);
        }

        @Override
        public InternationalBankModel[] newArray(int size) {
            return new InternationalBankModel[size];
        }
    };

    public String getInternationalBankName() {
        return internationalBankName;
    }

    public void setInternationalBankName(String internationalBankName) {
        this.internationalBankName = internationalBankName;
    }

    public String getInternationalBankImage() {
        return internationalBankImage;
    }

    public void setInternationalBankImage(String internationalBankImage) {
        this.internationalBankImage = internationalBankImage;
    }

    public String getInternationalBankAddress() {
        return internationalBankAddress;
    }

    public void setInternationalBankAddress(String internationalBankAddress) {
        this.internationalBankAddress = internationalBankAddress;
    }

    public String getInternationalBankSwiftCode() {
        return internationalBankSwiftCode;
    }

    public void setInternationalBankSwiftCode(String internationalBankSwiftCode) {
        this.internationalBankSwiftCode = internationalBankSwiftCode;
    }

    public String getInternationalBankStockCode() {
        return internationalBankStockCode;
    }

    public void setInternationalBankStockCode(String internationalBankStockCode) {
        this.internationalBankStockCode = internationalBankStockCode;
    }

    public String getInternationalBankDescription() {
        return internationalBankDescription;
    }

    public void setInternationalBankDescription(String internationalBankDescription) {
        this.internationalBankDescription = internationalBankDescription;
    }

    public String getInternationalBankEstablished() {
        return internationalBankEstablished;
    }

    public void setInternationalBankEstablished(String internationalBankEstablished) {
        this.internationalBankEstablished = internationalBankEstablished;
    }

    public String getInternationalBankContacts() {
        return internationalBankContacts;
    }

    public void setInternationalBankContacts(String internationalBankContacts) {
        this.internationalBankContacts = internationalBankContacts;
    }

    public String getInternationalBankType() {
        return internationalBankType;
    }

    public void setInternationalBankType(String internationalBankType) {
        this.internationalBankType = internationalBankType;
    }

    public String getInternationalBankWebsite() {
        return internationalBankWebsite;
    }

    public void setInternationalBankWebsite(String internationalBankWebsite) {
        this.internationalBankWebsite = internationalBankWebsite;
    }

    @Override

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this.internationalBankName,
                this.internationalBankImage,
                this.internationalBankAddress,
                this.internationalBankSwiftCode,
                this.internationalBankStockCode,
                this.internationalBankDescription,
                this.internationalBankEstablished,
                this.internationalBankContacts,
                this.internationalBankType,
                this.internationalBankWebsite,
                this.internationalBankObjectId,
                this.internationalBankStatus,
                this.internationalBankSummary});
    }
}
