package com.crysoft.me.bankx.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maxx on 9/29/2016.
 */

public class BankModel implements Parcelable {

    private String bankName;
    private String bankImage;
    private String bankAddress;
    private String bankSwiftCode;
    private String bankStockCode;
    private String bankDescription;
    private String bankEstablished;
    private String bankContacts;
    private String bankType;
    private String bankWebsite;
    private String bankObjectId;
    private String bankStatus;
    private String bankSummary;
    private String bankProducts;

    public String getBankProducts() {
        return bankProducts;
    }

    public void setBankProducts(String bankProducts) {
        this.bankProducts = bankProducts;
    }

    public String getBankStatus() {
        return bankStatus;
    }

    public void setBankStatus(String bankStatus) {
        this.bankStatus = bankStatus;
    }

    public String getBankObjectId() {
        return bankObjectId;
    }

    public void setBankObjectId(String bankObjectId) {
        this.bankObjectId = bankObjectId;
    }

    public String getBankWebsite() {
        return bankWebsite;
    }

    public void setBankWebsite(String bankWebsite) {
        this.bankWebsite = bankWebsite;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankImage() {
        return bankImage;
    }

    public void setBankImage(String bankImage) {
        this.bankImage = bankImage;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankSwiftCode() {
        return bankSwiftCode;
    }

    public void setBankSwiftCode(String bankSwiftCode) {
        this.bankSwiftCode = bankSwiftCode;
    }

    public String getBankStockCode() {
        return bankStockCode;
    }

    public void setBankStockCode(String bankStockCode) {
        this.bankStockCode = bankStockCode;
    }

    public String getBankDescription() {
        return bankDescription;
    }

    public void setBankDescription(String bankDescription) {
        this.bankDescription = bankDescription;
    }

    public String getBankEstablished() {
        return bankEstablished;
    }

    public void setBankEstablished(String bankEstablished) {
        this.bankEstablished = bankEstablished;
    }

    public String getBankContacts() {
        return bankContacts;
    }

    public void setBankContacts(String bankContacts) {
        this.bankContacts = bankContacts;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }


    public String getBankSummary() {
        return bankSummary;
    }

    public void setBankSummary(String bankSummary) {
        this.bankSummary = bankSummary;
    }

    public BankModel(Parcel in) {

        String[] array = new String[14];
        in.readStringArray(array);

        bankName = array[0];
        bankImage = array[1];
        bankAddress = array[2];
        bankSwiftCode = array[3];
        bankStockCode = array[4];
        bankDescription = array[5];
        bankEstablished = array[6];
        bankContacts = array[7];
        bankType = array[8];
        bankWebsite = array[9];
        bankObjectId = array[10];
        bankStatus = array[11];
        bankSummary = array[12];
        bankProducts = array[13];
    }

    public BankModel() {

    }

    public static final Creator<BankModel> CREATOR = new Creator<BankModel>() {
        @Override
        public BankModel createFromParcel(Parcel in) {
            return new BankModel(in);
        }

        @Override
        public BankModel[] newArray(int size) {
            return new BankModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this.bankName,
                this.bankImage,
                this.bankAddress,
                this.bankSwiftCode,
                this.bankStockCode,
                this.bankDescription,
                this.bankEstablished,
                this.bankContacts,
                this.bankType,
                this.bankWebsite,
                this.bankObjectId,
                this.bankStatus,
                this.bankSummary,
                this.bankProducts
        });
    }
}
