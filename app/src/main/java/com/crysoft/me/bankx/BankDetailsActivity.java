package com.crysoft.me.bankx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.crysoft.me.bankx.Models.BankModel;

public class BankDetailsActivity extends AppCompatActivity {
    private ViewFlipper mViewFlipper;
    private TextView bankType;
    private TextView bankFounded;
    private TextView bankProducts;
    private TextView bankWebsite;
    private TextView bankDescription;
    private TextView bankName;
    private TextView bankStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        bankType = (TextView) findViewById(R.id.bankType);
        bankFounded = (TextView) findViewById(R.id.bankFounded);
        bankProducts = (TextView) findViewById(R.id.bankProducts);
        bankWebsite = (TextView) findViewById(R.id.bankWebsite);
        bankDescription = (TextView) findViewById(R.id.bankDescription);
        bankName = (TextView) findViewById(R.id.bankName);
        bankStatus = (TextView) findViewById(R.id.bankStatus);


        mViewFlipper.setAutoStart(true);
        mViewFlipper.startFlipping();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "TODO: Message to Bank action goes here", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent bankIntent = getIntent();
        final BankModel bankDetails = (BankModel) bankIntent.getExtras().getParcelable("bankDetails");
        setTitle(bankDetails.getBankName());

        bankType.setText(bankDetails.getBankType());
        bankFounded.setText(bankDetails.getBankEstablished());
        bankProducts.setText(bankDetails.getBankProducts());
        bankWebsite.setText(bankDetails.getBankWebsite());
        bankDescription.setText(Html.fromHtml(bankDetails.getBankDescription()));
        bankName.setText(bankDetails.getBankName());
        bankStatus.setText(bankDetails.getBankStatus());


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

}
