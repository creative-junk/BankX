package com.crysoft.me.bankx.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maxx on 9/29/2016.
 */

public class CapitalMarketsModel implements Parcelable {

    private String companyName;
    private String companyImage;
    private String companyAddress;
    private String companySwiftCode;
    private String companyStockCode;
    private String companyDescription;
    private String companyEstablished;
    private String companyContacts;
    private String companyType;
    private String companyWebsite;
    private String companyObjectId;
    private String companyStatus;
    private String companySummary;

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }



    public String getCompanyObjectId() {
        return companyObjectId;
    }

    public void setCompanyObjectId(String companyObjectId) {
        this.companyObjectId = companyObjectId;
    }



    public CapitalMarketsModel(Parcel in) {

        String[] array = new String[13];
        in.readStringArray(array);

        companyName = array[0];
        companyImage = array[1];
        companyAddress = array[2];
        companySwiftCode = array[3];
        companyStockCode = array[4];
        companyDescription = array[5];
        companyEstablished = array[6];
        companyContacts = array[7];
        companyType = array[8];
        companyWebsite = array[9];
        companyObjectId = array[10];
        companyStatus = array[11];
        companySummary = array[12];
    }

    public CapitalMarketsModel() {

    }

    public static final Parcelable.Creator<CapitalMarketsModel> CREATOR = new Parcelable.Creator<CapitalMarketsModel>() {
        @Override
        public CapitalMarketsModel createFromParcel(Parcel in) {
            return new CapitalMarketsModel(in);
        }

        @Override
        public CapitalMarketsModel[] newArray(int size) {
            return new CapitalMarketsModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanySwiftCode() {
        return companySwiftCode;
    }

    public void setCompanySwiftCode(String companySwiftCode) {
        this.companySwiftCode = companySwiftCode;
    }

    public String getCompanyStockCode() {
        return companyStockCode;
    }

    public void setCompanyStockCode(String companyStockCode) {
        this.companyStockCode = companyStockCode;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyEstablished() {
        return companyEstablished;
    }

    public void setCompanyEstablished(String companyEstablished) {
        this.companyEstablished = companyEstablished;
    }

    public String getCompanyContacts() {
        return companyContacts;
    }

    public void setCompanyContacts(String companyContacts) {
        this.companyContacts = companyContacts;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanySummary() {
        return companySummary;
    }

    public void setCompanySummary(String companySummary) {
        this.companySummary = companySummary;
    }

    @Override

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this.companyName,
                this.companyImage,
                this.companyAddress,
                this.companySwiftCode,
                this.companyStockCode,
                this.companyDescription,
                this.companyEstablished,
                this.companyContacts,
                this.companyType,
                this.companyWebsite,
                this.companyObjectId,
                this.companyStatus,
                this.companySummary});
    }
}
