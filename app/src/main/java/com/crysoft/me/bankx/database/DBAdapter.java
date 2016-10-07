package com.crysoft.me.bankx.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.crysoft.me.bankx.Models.BankModel;
import com.crysoft.me.bankx.Models.CapitalMarketsModel;
import com.crysoft.me.bankx.Models.ForexBureauModel;
import com.crysoft.me.bankx.Models.InsuranceModel;
import com.crysoft.me.bankx.Models.InternationalBankModel;
import com.crysoft.me.bankx.Models.InvestmentBankModel;
import com.crysoft.me.bankx.Models.MicroFinanceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxx on 7/19/2016.
 */
public class DBAdapter extends SQLiteOpenHelper {
    //First let's make this class a singleton to avoid memory leaks and some other scary stuff like unnecessary relocations
    private static DBAdapter sInstance;
    private Context context;
    //Let's tag this b*
    private static final String TAG = "DBAdapter";

    //Database Information
    private static final String DATABASE_NAME = "bankx";
    private static final int DATABASE_VERSION = 2;
    //Table Names
    private static final String TABLE_BANKS = "banks";
    private static final String TABLE_INSURANCE = "insurance_agencies";
    private static final String TABLE_MICRO_FINANCE = "micro_finance";
    private static final String TABLE_FOREX_BUREAUS = "forex_bureaus";
    private static final String TABLE_GOVERNMENT_AGENCIES = "government_agencies";
    private static final String TABLE_INVESTMENT_BANKS = "investment_banks";
    private static final String TABLE_INTERNATIONAL_BANKS = "international_banks";
    private static final String TABLE_CAPITAL_MARKETS = "capital_markets";
    private static final String TABLE_LOANS = "loans";
    private static final String TABLE_ACCOUNTS = "accounts";
    private static final String TABLE_SERVICES = "services";

    //BANK table columns
    private static final String KEY_BANK_ID = "_id";
    private static final String KEY_BANK_OBJECT_ID = "bank_id";
    private static final String KEY_BANK_NAME = "bank_name";
    private static final String KEY_BANK_IMAGE = "bank_image";
    private static final String KEY_BANK_ADDRESS = "bank_address";
    private static final String KEY_BANK_SWIFT_CODE = "bank_swift_code";
    private static final String KEY_BANK_STOCK_CODE = "bank_stock_code";
    private static final String KEY_BANK_SUMMARY = "bank_summary";
    private static final String KEY_BANK_DESCRIPTION = "bank_description";
    private static final String KEY_BANK_ESTABLISHED = "bank_established";
    private static final String KEY_BANK_CONTACTS = "bank_contacts";
    private static final String KEY_BANK_TYPE = "bank_type";
    private static final String KEY_BANK_WEBSITE = "bank_website";
    private static final String KEY_BANK_STATUS = "bank_status";
    private static final String KEY_BANK_PRODUCTS = "bank_products";

    //insurance table columns
    private static final String KEY_INSURANCE_ID = "_id";
    private static final String KEY_INSURANCE_OBJECT_ID = "insurance_id";
    private static final String KEY_INSURANCE_NAME = "insurance_name";
    private static final String KEY_INSURANCE_IMAGE = "insurance_image";
    private static final String KEY_INSURANCE_ADDRESS = "insurance_address";
    private static final String KEY_INSURANCE_SWIFT_CODE = "insurance_swift_code";
    private static final String KEY_INSURANCE_STOCK_CODE = "insurance_stock_code";
    private static final String KEY_INSURANCE_SUMMARY = "insurance_summary";
    private static final String KEY_INSURANCE_DESCRIPTION = "insurance_description";
    private static final String KEY_INSURANCE_ESTABLISHED = "insurance_established";
    private static final String KEY_INSURANCE_CONTACTS = "insurance_contacts";
    private static final String KEY_INSURANCE_TYPE = "insurance_type";
    private static final String KEY_INSURANCE_WEBSITE = "insurance_website";
    private static final String KEY_INSURANCE_STATUS = "insurance_status";

    //MICRO FINANCE table columns
    private static final String KEY_MICRO_FINANCE_ID = "_id";
    private static final String KEY_MICRO_FINANCE_OBJECT_ID = "micro_finance_id";
    private static final String KEY_MICRO_FINANCE_NAME = "micro_finance_name";
    private static final String KEY_MICRO_FINANCE_IMAGE = "micro_finance_image";
    private static final String KEY_MICRO_FINANCE_ADDRESS = "micro_finance_address";
    private static final String KEY_MICRO_FINANCE_SWIFT_CODE = "micro_finance_swift_code";
    private static final String KEY_MICRO_FINANCE_STOCK_CODE = "micro_finance_stock_code";
    private static final String KEY_MICRO_FINANCE_SUMMARY = "micro_finance_summary";
    private static final String KEY_MICRO_FINANCE_DESCRIPTION = "micro_finance_description";
    private static final String KEY_MICRO_FINANCE_ESTABLISHED = "micro_finance_established";
    private static final String KEY_MICRO_FINANCE_CONTACTS = "micro_finance_contacts";
    private static final String KEY_MICRO_FINANCE_TYPE = "micro_finance_type";
    private static final String KEY_MICRO_FINANCE_WEBSITE = "micro_finance_website";
    private static final String KEY_MICRO_FINANCE_STATUS = "micro_finance_status";

    //FOREX BUREAUS table columns
    private static final String KEY_FOREX_BUREAU_ID = "_id";
    private static final String KEY_FOREX_BUREAU_OBJECT_ID = "forex_bureau_id";
    private static final String KEY_FOREX_BUREAU_NAME = "forex_bureau_name";
    private static final String KEY_FOREX_BUREAU_IMAGE = "forex_bureau_image";
    private static final String KEY_FOREX_BUREAU_ADDRESS = "forex_bureau_address";
    private static final String KEY_FOREX_BUREAU_SWIFT_CODE = "forex_bureau_swift_code";
    private static final String KEY_FOREX_BUREAU_STOCK_CODE = "forex_bureau_stock_code";
    private static final String KEY_FOREX_BUREAU_SUMMARY = "forex_bureau_summary";
    private static final String KEY_FOREX_BUREAU_DESCRIPTION = "forex_bureau_description";
    private static final String KEY_FOREX_BUREAU_ESTABLISHED = "forex_bureau_established";
    private static final String KEY_FOREX_BUREAU_CONTACTS = "forex_bureau_contacts";
    private static final String KEY_FOREX_BUREAU_TYPE = "forex_bureau_type";
    private static final String KEY_FOREX_BUREAU_WEBSITE = "forex_bureau_website";
    private static final String KEY_FOREX_BUREAU_STATUS = "forex_bureau__status";

    //INVESTMENT BANK table columns
    private static final String KEY_INVESTMENT_BANK_ID = "_id";
    private static final String KEY_INVESTMENT_BANK_OBJECT_ID = "investment_bank_id";
    private static final String KEY_INVESTMENT_BANK_NAME = "investment_bank_name";
    private static final String KEY_INVESTMENT_BANK_IMAGE = "investment_bank_image";
    private static final String KEY_INVESTMENT_BANK_ADDRESS = "investment_bank_address";
    private static final String KEY_INVESTMENT_BANK_SWIFT_CODE = "investment_bank_swift_code";
    private static final String KEY_INVESTMENT_BANK_STOCK_CODE = "investment_bank_stock_code";
    private static final String KEY_INVESTMENT_BANK_SUMMARY = "investment_bank_summary";
    private static final String KEY_INVESTMENT_BANK_DESCRIPTION = "investment_bank_description";
    private static final String KEY_INVESTMENT_BANK_ESTABLISHED = "investment_bank_established";
    private static final String KEY_INVESTMENT_BANK_CONTACTS = "investment_bank_contacts";
    private static final String KEY_INVESTMENT_BANK_TYPE = "investment_bank_type";
    private static final String KEY_INVESTMENT_BANK_WEBSITE = "investment_bank_website";
    private static final String KEY_INVESTMENT_BANK_STATUS = "investment_bank_status";

    //CAPITAL MARKET table columns
    private static final String KEY_COMPANY_ID = "_id";
    private static final String KEY_COMPANY_OBJECT_ID = "company_id";
    private static final String KEY_COMPANY_NAME = "company_name";
    private static final String KEY_COMPANY_IMAGE = "company_image";
    private static final String KEY_COMPANY_ADDRESS = "company_address";
    private static final String KEY_COMPANY_STOCK_CODE = "company_stock_code";
    private static final String KEY_COMPANY_SUMMARY = "company_summary";
    private static final String KEY_COMPANY_DESCRIPTION = "company_description";
    private static final String KEY_COMPANY_ESTABLISHED = "company_established";
    private static final String KEY_COMPANY_CONTACTS = "company_contacts";
    private static final String KEY_COMPANY_WEBSITE = "company_website";
    private static final String KEY_COMPANY_INDUSTRY = "company_industry";
    private static final String KEY_COMPANY_STATUS = "company_status";

    //INTERNATIONAL BANK table columns
    private static final String KEY_INTERNATIONAL_BANK_ID = "_id";
    private static final String KEY_INTERNATIONAL_BANK_OBJECT_ID = "international_bank_id";
    private static final String KEY_INTERNATIONAL_BANK_NAME = "international_bank_name";
    private static final String KEY_INTERNATIONAL_BANK_IMAGE = "international_bank_image";
    private static final String KEY_INTERNATIONAL_BANK_ADDRESS = "international_bank_address";
    private static final String KEY_INTERNATIONAL_BANK_SWIFT_CODE = "international_bank_swift_code";
    private static final String KEY_INTERNATIONAL_BANK_STOCK_CODE = "international_bank_stock_code";
    private static final String KEY_INTERNATIONAL_BANK_SUMMARY = "international_bank_summary";
    private static final String KEY_INTERNATIONAL_BANK_DESCRIPTION = "international_bank_description";
    private static final String KEY_INTERNATIONAL_BANK_ESTABLISHED = "international_bank_established";
    private static final String KEY_INTERNATIONAL_BANK_CONTACTS = "international_bank_contacts";
    private static final String KEY_INTERNATIONAL_BANK_TYPE = "international_bank_type";
    private static final String KEY_INTERNATIONAL_BANK_WEBSITE = "international_bank_website";
    private static final String KEY_INTERNATIONAL_BANK_STATUS = "international_bank_status";
    //Loans table
    private static final String KEY_LOAN_ID ="_id";
    private static final String KEY_LOAN_OBJECT_ID = "loan_id";
    private static final String KEY_LOAN_NAME ="loan_name";
    private static final String KEY_LOAN_DESCRIPTION ="loan_description";
    private static final String KEY_LOAN_TENURE ="loan_tenure";
    private static final String KEY_LOAN_INTEREST = "loan_interest";
    private static final String KEY_LOAN_CONDITIONS = "loan_conditions";
    private static final String KEY_LOAN_BANK_PROVIDER ="loan_bank_name";

    //ACCOUNTS table
    private static final String KEY_ACCOUNT_ID ="_id";
    private static final String KEY_ACCOUNT_OBJECT_ID = "account_id";
    private static final String KEY_ACCOUNT_NAME ="account_name";
    private static final String KEY_ACCOUNT_DESCRIPTION ="account_description";
    private static final String KEY_ACCOUNT_TENURE ="account_tenure";
    private static final String KEY_ACCOUNT_INTEREST = "account_interest";
    private static final String KEY_ACCOUNT_CONDITIONS = "account_conditions";
    private static final String KEY_ACCOUNT_BANK_PROVIDER ="account_bank_name";

    //SERVICES table
    private static final String KEY_SERVICE_ID ="_id";
    private static final String KEY_SERVICE_OBJECT_ID = "service_id";
    private static final String KEY_SERVICE_NAME ="service_name";
    private static final String KEY_SERVICE_DESCRIPTION ="service_description";   
    private static final String KEY_BANK_PROVIDER ="service_bank_name";

    //ARTICLE CATEGORY TABLE
    private static final String KEY_ARTICLE_CATEGORY_ID = "_id";
    private static final String KEY_ARTICLE_CATEGORY_OBJECT_ID = "category_id";
    private static final String KEY_ARTICLE_CATEGORY_NAME = "category_name";
    private static final String KEY_ARTICLE_CATEGORY_IMAGE = "category_image";
    private static final String KEY_ARTICLE_CATEGORY_TAG = "category_tag";
    private static final String KEY_ARTICLE_CATEGORY_TYPE = "category_type";
    private static final String KEY_ARTICLE_CATEGORY_PARENT_ID = "parent_id";

    //ARTICLES TABLE
    private static final String KEY_ARTICLE_ID = "_id";
    private static final String KEY_ARTICLE_OBJECT_ID = "article_id";
    private static final String KEY_ARTICLE_TITLE = "article_title";
    private static final String KEY_ARTICLE_CONTENT = "article_content";
    private static final String KEY_ARTICLE_CATEGORY = "article_category";


    // lets create a method for giving back an instance of this class so there will only ever be one instance at a time. If we have one we just return it,otherwise we create a new one
    public static synchronized DBAdapter getInstance(Context context) {
        //We use the application context so we don't accidentally leak an activities Context. see http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DBAdapter(context.getApplicationContext());
        }
        return sInstance;
    }

    private DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            db.setForeignKeyConstraintsEnabled(true);
        }
    }

    //Initialize the Database AND CREATE our tables if needed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BANKS_TABLE = "CREATE TABLE " + TABLE_BANKS +
                "(" +
                KEY_BANK_ID + " INTEGER PRIMARY KEY," +
                KEY_BANK_OBJECT_ID + " INTEGER," +
                KEY_BANK_NAME + " TEXT," +
                KEY_BANK_IMAGE + " TEXT," +
                KEY_BANK_ADDRESS + " TEXT," +
                KEY_BANK_SWIFT_CODE + " TEXT," +
                KEY_BANK_STOCK_CODE + " TEXT," +
                KEY_BANK_DESCRIPTION + " TEXT," +
                KEY_BANK_ESTABLISHED + " TEXT," +
                KEY_BANK_CONTACTS + " TEXT," +
                KEY_BANK_TYPE + " TEXT," +
                KEY_BANK_STATUS + " TEXT," +
                KEY_BANK_SUMMARY + " TEXT," +
                KEY_BANK_PRODUCTS + " TEXT," +
                KEY_BANK_WEBSITE + " TEXT" +
                ")";
        String CREATE_INSURANCE_TABLE = "CREATE TABLE " + TABLE_INSURANCE +
                "(" +
                KEY_INSURANCE_ID + " INTEGER PRIMARY KEY," +
                KEY_INSURANCE_OBJECT_ID + " INTEGER," +
                KEY_INSURANCE_NAME + " TEXT," +
                KEY_INSURANCE_IMAGE + " TEXT," +
                KEY_INSURANCE_ADDRESS + " TEXT," +
                KEY_INSURANCE_SWIFT_CODE + " TEXT," +
                KEY_INSURANCE_STOCK_CODE + " TEXT," +
                KEY_INSURANCE_DESCRIPTION + " TEXT," +
                KEY_INSURANCE_ESTABLISHED + " TEXT," +
                KEY_INSURANCE_CONTACTS + " TEXT," +
                KEY_INSURANCE_TYPE + " TEXT," +
                KEY_INSURANCE_STATUS + " TEXT," +
                KEY_INSURANCE_SUMMARY + " TEXT," +
                KEY_INSURANCE_WEBSITE + " TEXT" +
                ")";

        String CREATE_MICRO_FINANCE_TABLE = "CREATE TABLE " + TABLE_MICRO_FINANCE +
                "(" +
                KEY_MICRO_FINANCE_ID + " INTEGER PRIMARY KEY," +
                KEY_MICRO_FINANCE_OBJECT_ID + " INTEGER," +
                KEY_MICRO_FINANCE_NAME + " TEXT," +
                KEY_MICRO_FINANCE_IMAGE + " TEXT," +
                KEY_MICRO_FINANCE_ADDRESS + " TEXT," +
                KEY_MICRO_FINANCE_SWIFT_CODE + " TEXT," +
                KEY_MICRO_FINANCE_STOCK_CODE + " TEXT," +
                KEY_MICRO_FINANCE_DESCRIPTION + " TEXT," +
                KEY_MICRO_FINANCE_ESTABLISHED + " TEXT," +
                KEY_MICRO_FINANCE_CONTACTS + " TEXT," +
                KEY_MICRO_FINANCE_TYPE + " TEXT," +
                KEY_MICRO_FINANCE_STATUS + " TEXT," +
                KEY_MICRO_FINANCE_SUMMARY + " TEXT," +
                KEY_MICRO_FINANCE_WEBSITE + " TEXT" +
                ")";

        String CREATE_FOREX_BUREAUS_TABLE = "CREATE TABLE " + TABLE_FOREX_BUREAUS +
                "(" +
                KEY_FOREX_BUREAU_ID + " INTEGER PRIMARY KEY," +
                KEY_FOREX_BUREAU_OBJECT_ID + " INTEGER," +
                KEY_FOREX_BUREAU_NAME + " TEXT," +
                KEY_FOREX_BUREAU_IMAGE + " TEXT," +
                KEY_FOREX_BUREAU_ADDRESS + " TEXT," +
                KEY_FOREX_BUREAU_SWIFT_CODE + " TEXT," +
                KEY_FOREX_BUREAU_STOCK_CODE + " TEXT," +
                KEY_FOREX_BUREAU_DESCRIPTION + " TEXT," +
                KEY_FOREX_BUREAU_ESTABLISHED + " TEXT," +
                KEY_FOREX_BUREAU_CONTACTS + " TEXT," +
                KEY_FOREX_BUREAU_TYPE + " TEXT," +
                KEY_FOREX_BUREAU_STATUS + " TEXT," +
                KEY_FOREX_BUREAU_SUMMARY + " TEXT," +
                KEY_FOREX_BUREAU_WEBSITE + " TEXT" +
                ")";

        String CREATE_INVESTMENT_BANKS_TABLE = "CREATE TABLE " + TABLE_INVESTMENT_BANKS +
                "(" +
                KEY_INVESTMENT_BANK_ID + " INTEGER PRIMARY KEY," +
                KEY_INVESTMENT_BANK_OBJECT_ID + " INTEGER," +
                KEY_INVESTMENT_BANK_NAME + " TEXT," +
                KEY_INVESTMENT_BANK_IMAGE + " TEXT," +
                KEY_INVESTMENT_BANK_ADDRESS + " TEXT," +
                KEY_INVESTMENT_BANK_SWIFT_CODE + " TEXT," +
                KEY_INVESTMENT_BANK_STOCK_CODE + " TEXT," +
                KEY_INVESTMENT_BANK_DESCRIPTION + " TEXT," +
                KEY_INVESTMENT_BANK_ESTABLISHED + " TEXT," +
                KEY_INVESTMENT_BANK_CONTACTS + " TEXT," +
                KEY_INVESTMENT_BANK_TYPE + " TEXT," +
                KEY_INVESTMENT_BANK_STATUS + " TEXT," +
                KEY_INVESTMENT_BANK_SUMMARY + " TEXT," +
                KEY_INVESTMENT_BANK_WEBSITE + " TEXT" +
                ")";
        String CREATE_INTERNATIONAL_BANKS_TABLE = "CREATE TABLE " + TABLE_INTERNATIONAL_BANKS +
                "(" +
                KEY_INTERNATIONAL_BANK_ID + " INTEGER PRIMARY KEY," +
                KEY_INTERNATIONAL_BANK_OBJECT_ID + " INTEGER," +
                KEY_INTERNATIONAL_BANK_NAME + " TEXT," +
                KEY_INTERNATIONAL_BANK_IMAGE + " TEXT," +
                KEY_INTERNATIONAL_BANK_ADDRESS + " TEXT," +
                KEY_INTERNATIONAL_BANK_SWIFT_CODE + " TEXT," +
                KEY_INTERNATIONAL_BANK_STOCK_CODE + " TEXT," +
                KEY_INTERNATIONAL_BANK_DESCRIPTION + " TEXT," +
                KEY_INTERNATIONAL_BANK_ESTABLISHED + " TEXT," +
                KEY_INTERNATIONAL_BANK_CONTACTS + " TEXT," +
                KEY_INTERNATIONAL_BANK_TYPE + " TEXT," +
                KEY_INTERNATIONAL_BANK_STATUS + " TEXT," +
                KEY_INTERNATIONAL_BANK_SUMMARY + " TEXT," +
                KEY_INTERNATIONAL_BANK_WEBSITE + " TEXT" +
                ")";
        String CREATE_CAPITAL_MARKETS_TABLE = "CREATE TABLE " + TABLE_CAPITAL_MARKETS +
                "(" +
                KEY_COMPANY_ID + " INTEGER PRIMARY KEY," +
                KEY_COMPANY_OBJECT_ID + " INTEGER," +
                KEY_COMPANY_NAME + " TEXT," +
                KEY_COMPANY_IMAGE + " TEXT," +
                KEY_COMPANY_ADDRESS + " TEXT," +
                KEY_COMPANY_STOCK_CODE + " TEXT," +
                KEY_COMPANY_DESCRIPTION + " TEXT," +
                KEY_COMPANY_ESTABLISHED + " TEXT," +
                KEY_COMPANY_CONTACTS + " TEXT," +
                KEY_COMPANY_INDUSTRY + " TEXT," +
                KEY_COMPANY_STATUS + " TEXT," +
                KEY_COMPANY_SUMMARY + " TEXT," +
                KEY_COMPANY_WEBSITE + " TEXT" +
                ")";
        db.execSQL(CREATE_BANKS_TABLE);
        db.execSQL(CREATE_INSURANCE_TABLE);
        db.execSQL(CREATE_MICRO_FINANCE_TABLE);
        db.execSQL(CREATE_FOREX_BUREAUS_TABLE);
        db.execSQL(CREATE_INVESTMENT_BANKS_TABLE);
        db.execSQL(CREATE_INTERNATIONAL_BANKS_TABLE);
        db.execSQL(CREATE_CAPITAL_MARKETS_TABLE);

    }

    //If we upgrade, we drop the database for now. Not really sure is this is the best approach but for now let's stick to basic implementations
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_BANKS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_INSURANCE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_MICRO_FINANCE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOREX_BUREAUS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_INVESTMENT_BANKS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_INTERNATIONAL_BANKS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAPITAL_MARKETS);
            onCreate(db);

        }
    }

    //CRUD METHODS
    //Add or update Banks
    public boolean addOrUpdateBanks(BankModel bankDetails) {
        //Use the Cached Connection
        SQLiteDatabase db = getWritableDatabase();
        Boolean transactionSuccessful = false;

        //As usual Wrap it in a transaction
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_BANK_OBJECT_ID, bankDetails.getBankObjectId());
            values.put(KEY_BANK_NAME, bankDetails.getBankName());
            values.put(KEY_BANK_IMAGE, bankDetails.getBankImage());
            values.put(KEY_BANK_ADDRESS, bankDetails.getBankAddress());
            values.put(KEY_BANK_SWIFT_CODE, bankDetails.getBankSwiftCode());
            values.put(KEY_BANK_STOCK_CODE, bankDetails.getBankStockCode());
            values.put(KEY_BANK_DESCRIPTION, bankDetails.getBankDescription());
            values.put(KEY_BANK_ESTABLISHED, bankDetails.getBankEstablished());
            values.put(KEY_BANK_CONTACTS, bankDetails.getBankContacts());
            values.put(KEY_BANK_TYPE, bankDetails.getBankType());
            values.put(KEY_BANK_WEBSITE, bankDetails.getBankWebsite());
            values.put(KEY_BANK_STATUS, bankDetails.getBankStatus());
            values.put(KEY_BANK_SUMMARY, bankDetails.getBankSummary());
            values.put(KEY_BANK_PRODUCTS, bankDetails.getBankProducts());

            //Let's try to update the Saved Product if it exists.
            int rows = db.update(TABLE_BANKS, values, KEY_BANK_OBJECT_ID + "= ?", new String[]{bankDetails.getBankObjectId()});

            //Let's check if the update worked
            if (rows == 1) {
                //Ok, we have updated a Saved bank, we could probably get the Bank updated at this point if we needed to
                db.setTransactionSuccessful();
                transactionSuccessful = true;

            } else {
                //No Such Bank Here, insert it
                db.insertOrThrow(TABLE_BANKS, null, values);
                db.setTransactionSuccessful();
                transactionSuccessful = true;
            }
        } catch (Exception e) {
            Log.d(TAG, "Error trying to Update banks table");
            transactionSuccessful = false;
        } finally {
            db.endTransaction();
        }
        return transactionSuccessful;

    }

    //Add or update Banks
    public boolean addOrUpdateInsurance(InsuranceModel insuranceDetails) {
        //Use the Cached Connection
        SQLiteDatabase db = getWritableDatabase();
        Boolean transactionSuccessful = false;

        //As usual Wrap it in a transaction
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_INSURANCE_OBJECT_ID, insuranceDetails.getInsuranceObjectId());
            values.put(KEY_INSURANCE_NAME, insuranceDetails.getInsuranceName());
            values.put(KEY_INSURANCE_IMAGE, insuranceDetails.getInsuranceImage());
            values.put(KEY_INSURANCE_ADDRESS, insuranceDetails.getInsuranceAddress());
            values.put(KEY_INSURANCE_SWIFT_CODE, insuranceDetails.getInsuranceSwiftCode());
            values.put(KEY_INSURANCE_STOCK_CODE, insuranceDetails.getInsuranceStockCode());
            values.put(KEY_INSURANCE_DESCRIPTION, insuranceDetails.getInsuranceDescription());
            values.put(KEY_INSURANCE_ESTABLISHED, insuranceDetails.getInsuranceEstablished());
            values.put(KEY_INSURANCE_CONTACTS, insuranceDetails.getInsuranceContacts());
            values.put(KEY_INSURANCE_TYPE, insuranceDetails.getInsuranceType());
            values.put(KEY_INSURANCE_WEBSITE, insuranceDetails.getInsuranceWebsite());
            values.put(KEY_INSURANCE_STATUS, insuranceDetails.getInsuranceStatus());
            values.put(KEY_INSURANCE_SUMMARY, insuranceDetails.getInsuranceSummary());
            //Let's try to update the Saved Product if it exists.
            int rows = db.update(TABLE_INSURANCE, values, KEY_INSURANCE_OBJECT_ID + "= ?", new String[]{insuranceDetails.getInsuranceObjectId()});

            //Let's check if the update worked
            if (rows == 1) {
                //Ok, we have updated a Saved Insurance Agency, we could probably get the Insurance updated at this point if we needed to
                db.setTransactionSuccessful();
                transactionSuccessful = true;

            } else {
                //No Such Insurance Here, insert it
                db.insertOrThrow(TABLE_INSURANCE, null, values);
                db.setTransactionSuccessful();
                transactionSuccessful = true;
            }
        } catch (Exception e) {
            Log.d(TAG, "Error trying to Update Insurance table");
            transactionSuccessful = false;
        } finally {
            db.endTransaction();
        }
        return transactionSuccessful;

    }

    //Add or update Banks
    public boolean addOrUpdateMicroFinance(MicroFinanceModel microFinanceDetails) {
        //Use the Cached Connection
        SQLiteDatabase db = getWritableDatabase();
        Boolean transactionSuccessful = false;

        //As usual Wrap it in a transaction
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_MICRO_FINANCE_OBJECT_ID, microFinanceDetails.getMicroFinanceObjectId());
            values.put(KEY_MICRO_FINANCE_NAME, microFinanceDetails.getMicroFinanceName());
            values.put(KEY_MICRO_FINANCE_IMAGE, microFinanceDetails.getMicroFinanceImage());
            values.put(KEY_MICRO_FINANCE_ADDRESS, microFinanceDetails.getMicroFinanceAddress());
            values.put(KEY_MICRO_FINANCE_SWIFT_CODE, microFinanceDetails.getMicroFinanceSwiftCode());
            values.put(KEY_MICRO_FINANCE_STOCK_CODE, microFinanceDetails.getMicroFinanceStockCode());
            values.put(KEY_MICRO_FINANCE_DESCRIPTION, microFinanceDetails.getMicroFinanceDescription());
            values.put(KEY_MICRO_FINANCE_ESTABLISHED, microFinanceDetails.getMicroFinanceEstablished());
            values.put(KEY_MICRO_FINANCE_CONTACTS, microFinanceDetails.getMicroFinanceContacts());
            values.put(KEY_MICRO_FINANCE_TYPE, microFinanceDetails.getMicroFinanceType());
            values.put(KEY_MICRO_FINANCE_WEBSITE, microFinanceDetails.getMicroFinanceWebsite());
            values.put(KEY_MICRO_FINANCE_STATUS, microFinanceDetails.getMicroFinanceStatus());
            values.put(KEY_MICRO_FINANCE_SUMMARY, microFinanceDetails.getMicroFinanceSummary());
            //Let's try to update the Saved Product if it exists.
            int rows = db.update(TABLE_MICRO_FINANCE, values, KEY_MICRO_FINANCE_OBJECT_ID + "= ?", new String[]{microFinanceDetails.getMicroFinanceObjectId()});

            //Let's check if the update worked
            if (rows == 1) {
                //Ok, we have updated a Saved MicroFinance, we could probably get the MicroFinance updated at this point if we needed to
                db.setTransactionSuccessful();
                transactionSuccessful = true;

            } else {
                //No Such MicroFinance Here, insert it
                db.insertOrThrow(TABLE_MICRO_FINANCE, null, values);
                db.setTransactionSuccessful();
                transactionSuccessful = true;
            }
        } catch (Exception e) {
            Log.d(TAG, "Error trying to Update banks table");
            transactionSuccessful = false;
        } finally {
            db.endTransaction();
        }
        return transactionSuccessful;

    }

    //Add or update Forex Bureaus
    public boolean addOrUpdateForexBureau(ForexBureauModel forexBureauDetails) {
        //Use the Cached Connection
        SQLiteDatabase db = getWritableDatabase();
        Boolean transactionSuccessful = false;

        //As usual Wrap it in a transaction
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_FOREX_BUREAU_OBJECT_ID, forexBureauDetails.getForexBureauObjectId());
            values.put(KEY_FOREX_BUREAU_NAME, forexBureauDetails.getForexBureauName());
            values.put(KEY_FOREX_BUREAU_IMAGE, forexBureauDetails.getForexBureauImage());
            values.put(KEY_FOREX_BUREAU_ADDRESS, forexBureauDetails.getForexBureauAddress());
            values.put(KEY_FOREX_BUREAU_SWIFT_CODE, forexBureauDetails.getForexBureauSwiftCode());
            values.put(KEY_FOREX_BUREAU_STOCK_CODE, forexBureauDetails.getForexBureauStockCode());
            values.put(KEY_FOREX_BUREAU_DESCRIPTION, forexBureauDetails.getForexBureauDescription());
            values.put(KEY_FOREX_BUREAU_ESTABLISHED, forexBureauDetails.getForexBureauEstablished());
            values.put(KEY_FOREX_BUREAU_CONTACTS, forexBureauDetails.getForexBureauContacts());
            values.put(KEY_FOREX_BUREAU_TYPE, forexBureauDetails.getForexBureauType());
            values.put(KEY_FOREX_BUREAU_WEBSITE, forexBureauDetails.getForexBureauWebsite());
            values.put(KEY_FOREX_BUREAU_STATUS, forexBureauDetails.getForexBureauStatus());
            values.put(KEY_FOREX_BUREAU_SUMMARY, forexBureauDetails.getForexBureauSummary());
            //Let's try to update the Saved Product if it exists.
            int rows = db.update(TABLE_FOREX_BUREAUS, values, KEY_FOREX_BUREAU_OBJECT_ID + "= ?", new String[]{forexBureauDetails.getForexBureauObjectId()});

            //Let's check if the update worked
            if (rows == 1) {
                //Ok, we have updated a Saved forex Bureau, we could probably get the Forex Bureau updated at this point if we needed to
                db.setTransactionSuccessful();
                transactionSuccessful = true;

            } else {
                //No Such Forex Bureau Here, insert it
                db.insertOrThrow(TABLE_FOREX_BUREAUS, null, values);
                db.setTransactionSuccessful();
                transactionSuccessful = true;
            }
        } catch (Exception e) {
            Log.d(TAG, "Error trying to Update Forex Bureaus table");
            transactionSuccessful = false;
        } finally {
            db.endTransaction();
        }
        return transactionSuccessful;

    }

    //Add or update Investment Banks
    public boolean addOrUpdateInvestmentBanks(InvestmentBankModel investmentBankDetails) {
        //Use the Cached Connection
        SQLiteDatabase db = getWritableDatabase();
        Boolean transactionSuccessful = false;

        //As usual Wrap it in a transaction
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_INVESTMENT_BANK_OBJECT_ID, investmentBankDetails.getInvestmentBankObjectId());
            values.put(KEY_INVESTMENT_BANK_NAME, investmentBankDetails.getInvestmentBankName());
            values.put(KEY_INVESTMENT_BANK_IMAGE, investmentBankDetails.getInvestmentBankImage());
            values.put(KEY_INVESTMENT_BANK_ADDRESS, investmentBankDetails.getInvestmentBankAddress());
            values.put(KEY_INVESTMENT_BANK_SWIFT_CODE, investmentBankDetails.getInvestmentBankSwiftCode());
            values.put(KEY_INVESTMENT_BANK_STOCK_CODE, investmentBankDetails.getInvestmentBankStockCode());
            values.put(KEY_INVESTMENT_BANK_DESCRIPTION, investmentBankDetails.getInvestmentBankDescription());
            values.put(KEY_INVESTMENT_BANK_ESTABLISHED, investmentBankDetails.getInvestmentBankEstablished());
            values.put(KEY_INVESTMENT_BANK_CONTACTS, investmentBankDetails.getInvestmentBankContacts());
            values.put(KEY_INVESTMENT_BANK_TYPE, investmentBankDetails.getInvestmentBankType());
            values.put(KEY_INVESTMENT_BANK_WEBSITE, investmentBankDetails.getInvestmentBankWebsite());
            values.put(KEY_INVESTMENT_BANK_STATUS, investmentBankDetails.getInvestmentBankStatus());
            values.put(KEY_INVESTMENT_BANK_SUMMARY, investmentBankDetails.getInvestmentBankSummary());
            //Let's try to update the Saved Product if it exists.
            int rows = db.update(TABLE_INVESTMENT_BANKS, values, KEY_INVESTMENT_BANK_OBJECT_ID + "= ?", new String[]{investmentBankDetails.getInvestmentBankObjectId()});

            //Let's check if the update worked
            if (rows == 1) {
                //Ok, we have updated a Saved InvestmentBank, we could probably get the InvestmentBank updated at this point if we needed to
                db.setTransactionSuccessful();
                transactionSuccessful = true;

            } else {
                //No Such InvestmentBank Here, insert it
                db.insertOrThrow(TABLE_INVESTMENT_BANKS, null, values);
                db.setTransactionSuccessful();
                transactionSuccessful = true;
            }
        } catch (Exception e) {
            Log.d(TAG, "Error trying to Update banks table");
            transactionSuccessful = false;
        } finally {
            db.endTransaction();
        }
        return transactionSuccessful;

    }

    //Add or update Banks
    public boolean addOrUpdateInternationalBanks(InternationalBankModel internationalBankDetails) {
        //Use the Cached Connection
        SQLiteDatabase db = getWritableDatabase();
        Boolean transactionSuccessful = false;

        //As usual Wrap it in a transaction
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_INTERNATIONAL_BANK_OBJECT_ID, internationalBankDetails.getInternationalBankObjectId());
            values.put(KEY_INTERNATIONAL_BANK_NAME, internationalBankDetails.getInternationalBankName());
            values.put(KEY_INTERNATIONAL_BANK_IMAGE, internationalBankDetails.getInternationalBankImage());
            values.put(KEY_INTERNATIONAL_BANK_ADDRESS, internationalBankDetails.getInternationalBankAddress());
            values.put(KEY_INTERNATIONAL_BANK_SWIFT_CODE, internationalBankDetails.getInternationalBankSwiftCode());
            values.put(KEY_INTERNATIONAL_BANK_STOCK_CODE, internationalBankDetails.getInternationalBankStockCode());
            values.put(KEY_INTERNATIONAL_BANK_DESCRIPTION, internationalBankDetails.getInternationalBankDescription());
            values.put(KEY_INTERNATIONAL_BANK_ESTABLISHED, internationalBankDetails.getInternationalBankEstablished());
            values.put(KEY_INTERNATIONAL_BANK_CONTACTS, internationalBankDetails.getInternationalBankContacts());
            values.put(KEY_INTERNATIONAL_BANK_TYPE, internationalBankDetails.getInternationalBankType());
            values.put(KEY_INTERNATIONAL_BANK_WEBSITE, internationalBankDetails.getInternationalBankWebsite());
            values.put(KEY_INTERNATIONAL_BANK_STATUS, internationalBankDetails.getInternationalBankStatus());
            values.put(KEY_INTERNATIONAL_BANK_SUMMARY, internationalBankDetails.getInternationalBankSummary());
            //Let's try to update the Saved Product if it exists.
            int rows = db.update(TABLE_INTERNATIONAL_BANKS, values, KEY_INTERNATIONAL_BANK_OBJECT_ID + "= ?", new String[]{internationalBankDetails.getInternationalBankObjectId()});

            //Let's check if the update worked
            if (rows == 1) {
                //Ok, we have updated a Saved bank, we could probably get the Bank updated at this point if we needed to
                db.setTransactionSuccessful();
                transactionSuccessful = true;

            } else {
                //No Such Bank Here, insert it
                db.insertOrThrow(TABLE_BANKS, null, values);
                db.setTransactionSuccessful();
                transactionSuccessful = true;
            }
        } catch (Exception e) {
            Log.d(TAG, "Error trying to Update International banks table");
            transactionSuccessful = false;
        } finally {
            db.endTransaction();
        }
        return transactionSuccessful;

    }

    //Add or update Banks
    public boolean addOrUpdateCapitalMarkets(CapitalMarketsModel companyDetails) {
        //Use the Cached Connection
        SQLiteDatabase db = getWritableDatabase();
        Boolean transactionSuccessful = false;

        //As usual Wrap it in a transaction
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_COMPANY_OBJECT_ID, companyDetails.getCompanyObjectId());
            values.put(KEY_COMPANY_NAME, companyDetails.getCompanyName());
            values.put(KEY_COMPANY_IMAGE, companyDetails.getCompanyImage());
            values.put(KEY_COMPANY_ADDRESS, companyDetails.getCompanyAddress());
            values.put(KEY_COMPANY_STOCK_CODE, companyDetails.getCompanyStockCode());
            values.put(KEY_COMPANY_DESCRIPTION, companyDetails.getCompanyDescription());
            values.put(KEY_COMPANY_ESTABLISHED, companyDetails.getCompanyEstablished());
            values.put(KEY_COMPANY_CONTACTS, companyDetails.getCompanyContacts());
            values.put(KEY_COMPANY_INDUSTRY, companyDetails.getCompanyType());
            values.put(KEY_COMPANY_WEBSITE, companyDetails.getCompanyWebsite());
            values.put(KEY_COMPANY_STATUS, companyDetails.getCompanyStatus());
            values.put(KEY_COMPANY_SUMMARY, companyDetails.getCompanySummary());
            //Let's try to update the Saved Product if it exists.
            int rows = db.update(TABLE_BANKS, values, KEY_COMPANY_OBJECT_ID + "= ?", new String[]{companyDetails.getCompanyObjectId()});

            //Let's check if the update worked
            if (rows == 1) {
                //Ok, we have updated a Saved COMPANY, we could probably get the COMPANY updated at this point if we needed to
                db.setTransactionSuccessful();
                transactionSuccessful = true;

            } else {
                //No Such Bank Here, insert it
                db.insertOrThrow(TABLE_CAPITAL_MARKETS, null, values);
                db.setTransactionSuccessful();
                transactionSuccessful = true;
            }
        } catch (Exception e) {
            Log.d(TAG, "Error trying to Update company table");
            transactionSuccessful = false;
        } finally {
            db.endTransaction();
        }
        return transactionSuccessful;

    }


    //Get Banks
    public List<BankModel> getBanks() {
        List<BankModel> banksList = new ArrayList<BankModel>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_BANKS, new String[]{
                KEY_BANK_ID, KEY_BANK_OBJECT_ID, KEY_BANK_NAME, KEY_BANK_IMAGE, KEY_BANK_ADDRESS,KEY_BANK_SWIFT_CODE,KEY_BANK_STOCK_CODE,KEY_BANK_DESCRIPTION,KEY_BANK_ESTABLISHED,KEY_BANK_CONTACTS,KEY_BANK_TYPE,KEY_BANK_WEBSITE,KEY_BANK_STATUS,KEY_BANK_SUMMARY,KEY_BANK_PRODUCTS
        }, null, null, null, null, KEY_BANK_NAME+" ASC");
        try {
            if (cursor.moveToFirst()) {
                do {
                    BankModel bankDetails = new BankModel();
                    bankDetails.setBankObjectId(cursor.getString(1));
                    bankDetails.setBankName(cursor.getString(2));
                    bankDetails.setBankImage(cursor.getString(3));
                    bankDetails.setBankAddress(cursor.getString(4));
                    bankDetails.setBankSwiftCode(cursor.getString(5));
                    bankDetails.setBankStockCode(cursor.getString(6));
                    bankDetails.setBankDescription(cursor.getString(7));
                    bankDetails.setBankEstablished(cursor.getString(8));
                    bankDetails.setBankContacts(cursor.getString(9));
                    bankDetails.setBankType(cursor.getString(10));
                    bankDetails.setBankWebsite(cursor.getString(11));
                    bankDetails.setBankStatus(cursor.getString(12));
                    bankDetails.setBankSummary(cursor.getString(13));
                    bankDetails.setBankProducts(cursor.getString(14));
                    banksList.add(bankDetails);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error Retrieving Banks");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return banksList;

    }

    //Get Insurance Models
    public List<InsuranceModel> getInsuranceAgencies() {
        List<InsuranceModel> insuranceAgencyList = new ArrayList<InsuranceModel>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_INSURANCE, new String[]{
                KEY_INSURANCE_ID, KEY_INSURANCE_OBJECT_ID, KEY_INSURANCE_NAME, KEY_INSURANCE_IMAGE, KEY_INSURANCE_ADDRESS, KEY_INSURANCE_STATUS,KEY_INSURANCE_SUMMARY
        }, null, null, null, null, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    InsuranceModel insuranceDetails = new InsuranceModel();
                    insuranceDetails.setInsuranceObjectId(cursor.getString(1));
                    insuranceDetails.setInsuranceName(cursor.getString(2));
                    insuranceDetails.setInsuranceImage(cursor.getString(3));
                    insuranceDetails.setInsuranceAddress(cursor.getString(4));
                    insuranceDetails.setInsuranceStatus(cursor.getString(5));
                    insuranceDetails.setInsuranceSummary(cursor.getString(6));
                    insuranceAgencyList.add(insuranceDetails);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error Retrieving Insurance Agencies");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return insuranceAgencyList;
    }

    //Get Micro Finance Banks
    public List<MicroFinanceModel> getMicroFinance() {
        List<MicroFinanceModel> microFinanceList = new ArrayList<MicroFinanceModel>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_BANKS, new String[]{
                KEY_MICRO_FINANCE_ID, KEY_MICRO_FINANCE_OBJECT_ID, KEY_MICRO_FINANCE_NAME, KEY_MICRO_FINANCE_IMAGE, KEY_MICRO_FINANCE_ADDRESS, KEY_MICRO_FINANCE_STATUS, KEY_MICRO_FINANCE_SUMMARY
        }, null, null, null, null, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    MicroFinanceModel microFinanceDetails = new MicroFinanceModel();
                    microFinanceDetails.setMicroFinanceObjectId(cursor.getString(1));
                    microFinanceDetails.setMicroFinanceName(cursor.getString(2));
                    microFinanceDetails.setMicroFinanceImage(cursor.getString(3));
                    microFinanceDetails.setMicroFinanceAddress(cursor.getString(4));
                    microFinanceDetails.setMicroFinanceStatus(cursor.getString(5));
                    microFinanceDetails.setMicroFinanceSummary(cursor.getString(6));
                    microFinanceList.add(microFinanceDetails);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error Retrieving Banks");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return microFinanceList;

    }
    //Get Banks
    public List<ForexBureauModel> getForexBureau() {
        List<ForexBureauModel> forexBureausList = new ArrayList<ForexBureauModel>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_FOREX_BUREAUS, new String[]{
                KEY_FOREX_BUREAU_ID, KEY_FOREX_BUREAU_OBJECT_ID, KEY_FOREX_BUREAU_NAME, KEY_FOREX_BUREAU_IMAGE, KEY_FOREX_BUREAU_ADDRESS, KEY_FOREX_BUREAU_STATUS,KEY_FOREX_BUREAU_SUMMARY
        }, null, null, null, null, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    ForexBureauModel forexBureauDetails = new ForexBureauModel();
                    forexBureauDetails.setForexBureauObjectId(cursor.getString(1));
                    forexBureauDetails.setForexBureauName(cursor.getString(2));
                    forexBureauDetails.setForexBureauImage(cursor.getString(3));
                    forexBureauDetails.setForexBureauImage(cursor.getString(4));
                    forexBureauDetails.setForexBureauStatus(cursor.getString(5));
                    forexBureauDetails.setForexBureauSummary(cursor.getString(6));
                    forexBureausList.add(forexBureauDetails);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error Retrieving Forex Bureaus");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return forexBureausList;

    }
    //Get Investment Banks
    public List<InvestmentBankModel> getInvestmentBanks() {
        List<InvestmentBankModel> investmentBanksList = new ArrayList<InvestmentBankModel>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_INVESTMENT_BANKS, new String[]{
                KEY_INVESTMENT_BANK_ID, KEY_INVESTMENT_BANK_OBJECT_ID, KEY_INVESTMENT_BANK_NAME, KEY_INVESTMENT_BANK_IMAGE, KEY_INVESTMENT_BANK_ADDRESS, KEY_INVESTMENT_BANK_STATUS,KEY_INVESTMENT_BANK_SUMMARY
        }, null, null, null, null, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    InvestmentBankModel investmentBankDetails = new InvestmentBankModel();
                    investmentBankDetails.setInvestmentBankObjectId(cursor.getString(1));
                    investmentBankDetails.setInvestmentBankName(cursor.getString(2));
                    investmentBankDetails.setInvestmentBankImage(cursor.getString(3));
                    investmentBankDetails.setInvestmentBankAddress(cursor.getString(4));
                    investmentBankDetails.setInvestmentBankStatus(cursor.getString(5));
                    investmentBankDetails.setInvestmentBankSummary(cursor.getString(6));
                    investmentBanksList.add(investmentBankDetails);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error Retrieving Investment Banks");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return investmentBanksList;

    }

    //Get International Banks
    public List<InternationalBankModel> getInternationalBanks() {
        List<InternationalBankModel> internationalBankList = new ArrayList<InternationalBankModel>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_INTERNATIONAL_BANKS, new String[]{
                KEY_INTERNATIONAL_BANK_ID, KEY_INTERNATIONAL_BANK_OBJECT_ID, KEY_INTERNATIONAL_BANK_NAME, KEY_INTERNATIONAL_BANK_IMAGE, KEY_INTERNATIONAL_BANK_ADDRESS, KEY_INTERNATIONAL_BANK_STATUS,KEY_INTERNATIONAL_BANK_SUMMARY
        }, null, null, null, null, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    InternationalBankModel internationalBankDetails = new InternationalBankModel();
                    internationalBankDetails.setInternationalBankObjectId(cursor.getString(1));
                    internationalBankDetails.setInternationalBankName(cursor.getString(2));
                    internationalBankDetails.setInternationalBankImage(cursor.getString(3));
                    internationalBankDetails.setInternationalBankAddress(cursor.getString(4));
                    internationalBankDetails.setInternationalBankStatus(cursor.getString(5));
                    internationalBankDetails.setInternationalBankSummary(cursor.getString(6));
                    internationalBankList.add(internationalBankDetails);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error Retrieving Investment Banks");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return internationalBankList;

    }
    //Get Banks
    public List<CapitalMarketsModel> getCapitalMarkets() {
        List<CapitalMarketsModel> companyList = new ArrayList<CapitalMarketsModel>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_CAPITAL_MARKETS, new String[]{
                KEY_COMPANY_ID, KEY_COMPANY_OBJECT_ID, KEY_COMPANY_NAME, KEY_COMPANY_IMAGE, KEY_COMPANY_ADDRESS, KEY_COMPANY_STATUS,KEY_COMPANY_SUMMARY
        }, null, null, null, null, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    CapitalMarketsModel companyDetails = new CapitalMarketsModel();
                    companyDetails.setCompanyObjectId(cursor.getString(1));
                    companyDetails.setCompanyName(cursor.getString(2));
                    companyDetails.setCompanyImage(cursor.getString(3));
                    companyDetails.setCompanyAddress(cursor.getString(4));
                    companyDetails.setCompanyStatus(cursor.getString(5));
                    companyDetails.setCompanySummary(cursor.getString(6));
                    companyList.add(companyDetails);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error Retrieving Banks");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return companyList;

    }
    //Banks
    public void updateAllBanks(ArrayList<BankModel> banksList){
        for (int i=0;i< banksList.size();i++){
            BankModel bankDetails=banksList.get(i);
            addOrUpdateBanks(bankDetails);
        }

    }

}

