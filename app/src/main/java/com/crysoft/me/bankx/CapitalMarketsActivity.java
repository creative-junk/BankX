package com.crysoft.me.bankx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.crysoft.me.bankx.Models.CapitalMarketsModel;
import com.crysoft.me.bankx.adapters.CompanyAdapter;
import com.crysoft.me.bankx.database.DBAdapter;

import java.util.List;

public class CapitalMarketsActivity extends AppCompatActivity {
    private DBAdapter databaseAdapter;

    private CompanyAdapter companiesAdapter;
    private List<CapitalMarketsModel> companiesList;

    private GridView gridView;
    private LinearLayout emptyCompaniesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_markets);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView= (GridView) findViewById(R.id.companiesList);
        emptyCompaniesList = (LinearLayout) findViewById(R.id.emptyCompaniesList);
        databaseAdapter = DBAdapter.getInstance(this);

       companiesList = databaseAdapter.getCapitalMarkets();
        if (companiesList.size() > 0){
            companiesAdapter = new CompanyAdapter(getLayoutInflater(),companiesList,this);
            gridView.setAdapter(companiesAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(CapitalMarketsActivity.this,CompanyDetailsActivity.class);
                    CapitalMarketsModel companyDetails = companiesList.get(position);
                    intent.putExtra("companyDetails",companyDetails);
                    startActivity(intent);
                }
            });
        }else{
            gridView.setVisibility(View.GONE);
            emptyCompaniesList.setVisibility(View.VISIBLE);
        }

    }

}
