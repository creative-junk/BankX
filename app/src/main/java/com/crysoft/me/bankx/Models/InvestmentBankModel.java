package com.crysoft.me.bankx.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maxx on 9/29/2016.
 */

public class InvestmentBankModel implements Parcelable {

    private String investmentBankName;
    private String investmentBankImage;
    private String investmentBankAddress;
    private String investmentBankSwiftCode;
    private String investmentBankStockCode;
    private String investmentBankDescription;
    private String investmentBankEstablished;
    private String investmentBankContacts;
    private String investmentBankType;
    private String investmentBankWebsite;
    private String investmentBankObjectId;
    private String investmentBankStatus;

    public String getInvestmentBankObjectId() {
        return investmentBankObjectId;
    }

    public void setInvestmentBankObjectId(String investmentBankObjectId) {
        this.investmentBankObjectId = investmentBankObjectId;
    }


    public InvestmentBankModel(Parcel in) {

        String[] array = new String[12];
        in.readStringArray(array);

        investmentBankName = array[0];
        investmentBankImage = array[1];
        investmentBankAddress = array[2];
        investmentBankSwiftCode = array[3];
        investmentBankStockCode = array[4];
        investmentBankDescription = array[5];
        investmentBankEstablished = array[6];
        investmentBankContacts = array[7];
        investmentBankType = array[8];
        investmentBankWebsite = array[9];
        investmentBankObjectId = array[10];
        investmentBankStatus = array[11];
    }

    public InvestmentBankModel() {

    }

    public static final Parcelable.Creator<InvestmentBankModel> CREATOR = new Parcelable.Creator<InvestmentBankModel>() {
        @Override
        public InvestmentBankModel createFromParcel(Parcel in) {
            return new InvestmentBankModel(in);
        }

        @Override
        public InvestmentBankModel[] newArray(int size) {
            return new InvestmentBankModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getInvestmentBankName() {
        return investmentBankName;
    }

    public void setInvestmentBankName(String investmentBankName) {
        this.investmentBankName = investmentBankName;
    }

    public String getInvestmentBankImage() {
        return investmentBankImage;
    }

    public void setInvestmentBankImage(String investmentBankImage) {
        this.investmentBankImage = investmentBankImage;
    }

    public String getInvestmentBankAddress() {
        return investmentBankAddress;
    }

    public void setInvestmentBankAddress(String investmentBankAddress) {
        this.investmentBankAddress = investmentBankAddress;
    }

    public String getInvestmentBankSwiftCode() {
        return investmentBankSwiftCode;
    }

    public void setInvestmentBankSwiftCode(String investmentBankSwiftCode) {
        this.investmentBankSwiftCode = investmentBankSwiftCode;
    }

    public String getInvestmentBankStockCode() {
        return investmentBankStockCode;
    }

    public void setInvestmentBankStockCode(String investmentBankStockCode) {
        this.investmentBankStockCode = investmentBankStockCode;
    }

    public String getInvestmentBankDescription() {
        return investmentBankDescription;
    }

    public void setInvestmentBankDescription(String investmentBankDescription) {
        this.investmentBankDescription = investmentBankDescription;
    }

    public String getInvestmentBankStatus() {
        return investmentBankStatus;
    }

    public void setInvestmentBankStatus(String investmentBankStatus) {
        this.investmentBankStatus = investmentBankStatus;
    }

    public String getInvestmentBankEstablished() {

        return investmentBankEstablished;
    }

    public void setInvestmentBankEstablished(String investmentBankEstablished) {
        this.investmentBankEstablished = investmentBankEstablished;
    }

    public String getInvestmentBankContacts() {
        return investmentBankContacts;
    }

    public void setInvestmentBankContacts(String investmentBankContacts) {
        this.investmentBankContacts = investmentBankContacts;
    }

    public String getInvestmentBankType() {
        return investmentBankType;
    }

    public void setInvestmentBankType(String investmentBankType) {
        this.investmentBankType = investmentBankType;
    }

    public String getInvestmentBankWebsite() {
        return investmentBankWebsite;
    }

    public void setInvestmentBankWebsite(String investmentBankWebsite) {
        this.investmentBankWebsite = investmentBankWebsite;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this.investmentBankName,
                this.investmentBankImage,
                this.investmentBankAddress,
                this.investmentBankSwiftCode,
                this.investmentBankStockCode,
                this.investmentBankDescription,
                this.investmentBankEstablished,
                this.investmentBankContacts,
                this.investmentBankType,
                this.investmentBankWebsite,
                this.investmentBankObjectId,
                this.investmentBankStatus});
    }
}
