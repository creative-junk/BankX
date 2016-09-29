package com.crysoft.me.bankx.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maxx on 9/29/2016.
 */

public class InsuranceModel implements Parcelable{

    private String insuranceName;
    private String insuranceImage;
    private String insuranceAddress;
    private String insuranceSwiftCode;
    private String insuranceStockCode;
    private String insuranceDescription;
    private String insuranceEstablished;
    private String insuranceContacts;
    private String insuranceType;
    private String insuranceWebsite;
    private String insuranceObjectId;
    private String insuranceStatus;



    public InsuranceModel(Parcel in) {


        String[] array = new String[12];
        in.readStringArray(array);

        insuranceName = array[0];
        insuranceImage = array[1];
        insuranceAddress = array[2];
        insuranceSwiftCode = array[3];
        insuranceStockCode = array[4];
        insuranceDescription = array[5];
        insuranceEstablished = array[6];
        insuranceContacts = array[7];
        insuranceType = array[8];
        insuranceWebsite = array[9];
        insuranceObjectId = array[10];
        insuranceStatus = array[11];
    }

    public InsuranceModel() {

    }

    public static final Parcelable.Creator<InsuranceModel> CREATOR = new Parcelable.Creator<InsuranceModel>() {
        @Override
        public InsuranceModel createFromParcel(Parcel in) {
            return new InsuranceModel(in);
        }

        @Override
        public InsuranceModel[] newArray(int size) {
            return new InsuranceModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getInsuranceName() {
        return insuranceName;
    }
    public String getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(String insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }
    public String getInsuranceObjectId() {
        return insuranceObjectId;
    }

    public void setInsuranceObjectId(String insuranceObjectId) {
        this.insuranceObjectId = insuranceObjectId;
    }

    public void setInsuranceName(String insuranceName) {

        this.insuranceName = insuranceName;
    }

    public String getInsuranceImage() {
        return insuranceImage;
    }

    public void setInsuranceImage(String insuranceImage) {
        this.insuranceImage = insuranceImage;
    }

    public String getInsuranceAddress() {
        return insuranceAddress;
    }

    public void setInsuranceAddress(String insuranceAddress) {
        this.insuranceAddress = insuranceAddress;
    }

    public String getInsuranceSwiftCode() {
        return insuranceSwiftCode;
    }

    public void setInsuranceSwiftCode(String insuranceSwiftCode) {
        this.insuranceSwiftCode = insuranceSwiftCode;
    }

    public String getInsuranceStockCode() {
        return insuranceStockCode;
    }

    public void setInsuranceStockCode(String insuranceStockCode) {
        this.insuranceStockCode = insuranceStockCode;
    }

    public String getInsuranceDescription() {
        return insuranceDescription;
    }

    public void setInsuranceDescription(String insuranceDescription) {
        this.insuranceDescription = insuranceDescription;
    }

    public String getInsuranceEstablished() {
        return insuranceEstablished;
    }

    public void setInsuranceEstablished(String insuranceEstablished) {
        this.insuranceEstablished = insuranceEstablished;
    }

    public String getInsuranceContacts() {
        return insuranceContacts;
    }

    public void setInsuranceContacts(String insuranceContacts) {
        this.insuranceContacts = insuranceContacts;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceWebsite() {
        return insuranceWebsite;
    }

    public void setInsuranceWebsite(String insuranceWebsite) {
        this.insuranceWebsite = insuranceWebsite;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this.insuranceName,
                this.insuranceImage,
                this.insuranceAddress,
                this.insuranceSwiftCode,
                this.insuranceStockCode,
                this.insuranceDescription,
                this.insuranceEstablished,
                this.insuranceContacts,
                this.insuranceType,
                this.insuranceWebsite,
                this.insuranceObjectId,
                this.insuranceStatus});
    }
}
