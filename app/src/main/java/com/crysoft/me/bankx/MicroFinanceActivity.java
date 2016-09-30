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

import com.crysoft.me.bankx.Models.InternationalBankModel;
import com.crysoft.me.bankx.Models.MicroFinanceModel;
import com.crysoft.me.bankx.adapters.InternationalBankAdapter;
import com.crysoft.me.bankx.adapters.MicroFinanceAdapter;
import com.crysoft.me.bankx.database.DBAdapter;

import java.util.List;

public class MicroFinanceActivity extends AppCompatActivity {
    private DBAdapter databaseAdapter;

    private MicroFinanceAdapter microFinanceAdapter;
    private List<MicroFinanceModel> microFinanceList;

    private GridView gridView;
    private LinearLayout emptyMicroFinanceList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_finance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView= (GridView) findViewById(R.id.banksList);
        emptyMicroFinanceList = (LinearLayout) findViewById(R.id.emptyBankList);
        databaseAdapter = DBAdapter.getInstance(this);

        microFinanceList = databaseAdapter.getMicroFinance();
        if (microFinanceList.size() > 0){
            microFinanceAdapter = new MicroFinanceAdapter(getLayoutInflater(),microFinanceList,this);
            gridView.setAdapter(microFinanceAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MicroFinanceActivity.this,BankDetailsActivity.class);
                    MicroFinanceModel bankDetails = microFinanceList.get(position);
                    intent.putExtra("microFinanceDetails",bankDetails);
                    startActivity(intent);
                }
            });
        }else{
            gridView.setVisibility(View.GONE);
            emptyMicroFinanceList.setVisibility(View.VISIBLE);
        }
    }


}
