package com.crysoft.me.bankx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.crysoft.me.bankx.Models.BankModel;
import com.crysoft.me.bankx.Models.InternationalBankModel;
import com.crysoft.me.bankx.adapters.BanksAdapter;
import com.crysoft.me.bankx.adapters.InternationalBankAdapter;
import com.crysoft.me.bankx.database.DBAdapter;

import java.util.List;

public class InternationalBanksActivity extends AppCompatActivity {
    private DBAdapter databaseAdapter;

    private InternationalBankAdapter banksAdapter;
    private List<InternationalBankModel> banksList;

    private GridView gridView;
    private LinearLayout emptyBankList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international_banks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView= (GridView) findViewById(R.id.banksList);
        emptyBankList = (LinearLayout) findViewById(R.id.emptyBankList);
        databaseAdapter = DBAdapter.getInstance(this);

        banksList = databaseAdapter.getInternationalBanks();
        if (banksList.size() > 0){
            banksAdapter = new InternationalBankAdapter(getLayoutInflater(),banksList,this);
            gridView.setAdapter(banksAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(InternationalBanksActivity.this,BankDetailsActivity.class);
                    InternationalBankModel bankDetails = banksList.get(position);
                    intent.putExtra("bankDetails",bankDetails);
                    startActivity(intent);
                }
            });
        }else{
            gridView.setVisibility(View.GONE);
            emptyBankList.setVisibility(View.VISIBLE);
        }
    }


}
