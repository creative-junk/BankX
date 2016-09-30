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
import com.crysoft.me.bankx.Models.InsuranceModel;
import com.crysoft.me.bankx.adapters.BanksAdapter;
import com.crysoft.me.bankx.adapters.InsuranceAdapter;
import com.crysoft.me.bankx.database.DBAdapter;

import java.util.List;

public class InsuranceActivity extends AppCompatActivity {
    private DBAdapter databaseAdapter;

    private InsuranceAdapter insuranceAdapter;
    private List<InsuranceModel> insuranceList;

    private GridView gridView;
    private LinearLayout emptyInsuranceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView = (GridView) findViewById(R.id.insuranceList);
        emptyInsuranceList = (LinearLayout) findViewById(R.id.emptyInsuranceList);
        databaseAdapter = DBAdapter.getInstance(this);

        insuranceList = databaseAdapter.getInsuranceAgencies();
        if (insuranceList.size() > 0) {
            insuranceAdapter = new InsuranceAdapter(getLayoutInflater(), insuranceList, this);
            gridView.setAdapter(insuranceAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(InsuranceActivity.this, AgencyDetailsActivity.class);
                    InsuranceModel insuranceDetails = insuranceList.get(position);
                    intent.putExtra("insuranceDetails", insuranceDetails);
                    startActivity(intent);
                }
            });
        } else {
            gridView.setVisibility(View.GONE);
            emptyInsuranceList.setVisibility(View.VISIBLE);
        }
    }


}
