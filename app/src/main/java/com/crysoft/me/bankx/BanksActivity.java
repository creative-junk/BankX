package com.crysoft.me.bankx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.crysoft.me.bankx.Models.BankModel;
import com.crysoft.me.bankx.adapters.BanksAdapter;
import com.crysoft.me.bankx.database.DBAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class BanksActivity extends AppCompatActivity {

    private DBAdapter databaseAdapter;

    private BanksAdapter banksAdapter;
    private List<BankModel> banksList;

    private GridView gridView;
    SearchView bankSearch;
    private LinearLayout emptyBankList;
    private ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        mViewFlipper.setAutoStart(true);
        mViewFlipper.startFlipping();

        gridView= (GridView) findViewById(R.id.banksList);
        emptyBankList = (LinearLayout) findViewById(R.id.emptyBankList);
        bankSearch =(SearchView) findViewById(R.id.svBankSearch);
        bankSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                banksAdapter.getFilter().filter(s.toString());
                return false;
            }
        });


        databaseAdapter = DBAdapter.getInstance(this);

        banksList = databaseAdapter.getBanks();
        if (banksList.size() > 0){
            banksAdapter = new BanksAdapter(getLayoutInflater(),banksList,this);
            gridView.setAdapter(banksAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(BanksActivity.this,BankDetailsActivity.class);
                    BankModel bankDetails = banksList.get(position);
                    intent.putExtra("bankDetails",bankDetails);
                    startActivity(intent);
                }
            });


        }else{
            gridView.setVisibility(View.GONE);
            bankSearch.setVisibility(View.GONE);
            emptyBankList.setVisibility(View.VISIBLE);


        }
        updateBanks();
    }

    private void updateBanks(){

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Bank");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> bankObjectList, ParseException e) {
                if (e==null){

                    ArrayList<BankModel> banksList= new ArrayList<BankModel>();
                    for (int i=0;i<bankObjectList.size();i++){
                        ParseObject bank = bankObjectList.get(i);
                        BankModel bankDetails = new BankModel();
                        bankDetails.setBankObjectId(bank.getObjectId());
                        bankDetails.setBankName(bank.getString("bank_name"));
                        bankDetails.setBankImage(bank.getParseFile("bank_logo").getUrl());
                        bankDetails.setBankAddress(bank.getString("bank_address"));
                        bankDetails.setBankSwiftCode(bank.getString("bank_swift_code"));
                        bankDetails.setBankStockCode(bank.getString("bank_stock_code"));
                        bankDetails.setBankDescription(bank.getString("bank_description"));
                        bankDetails.setBankEstablished(bank.getString("bank_established"));
                        bankDetails.setBankContacts(bank.getString("bank_contacts"));
                        bankDetails.setBankType(bank.getString("bank_type"));
                        bankDetails.setBankWebsite(bank.getString("bank_website"));
                        bankDetails.setBankStatus(bank.getString("bank_status"));
                        bankDetails.setBankSummary(bank.getString("bank_summary"));
                        bankDetails.setBankProducts(bank.getString("bank_products"));
                        banksList.add(bankDetails);
                    }
                    databaseAdapter.updateAllBanks(banksList);
                }else{
                    e.printStackTrace();
                    Log.i("Error","We are " + e.getMessage());
                }
            }
        });
    }

}
