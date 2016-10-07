package com.crysoft.me.bankx;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.crysoft.me.bankx.helpers.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar mToolBar;
    private ViewFlipper mViewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);


        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_drawer);
        Menu drawerItemsMenu = navigationView.getMenu();
        MenuItem signInMenu = drawerItemsMenu.findItem(R.id.signIn);


        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        mViewFlipper.setAutoStart(true);
        mViewFlipper.startFlipping();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
    public void findBanks(View view){
        Intent intent = new Intent(this,BanksActivity.class);
        startActivity(intent);
    }
    public void findInsuranceAgencies(View view){
        Intent intent = new Intent(this,InsuranceActivity.class);
        startActivity(intent);
    }
    public void findMicroFinance(View view){
        Intent intent = new Intent(this,MicroFinanceActivity.class);
        startActivity(intent);
    }
    public void findInvestmentBanks(View view){
        Intent intent = new Intent(this,InvestmentBankActivity.class);
        startActivity(intent);
    }
    public void findInternationalBanks(View view){
        Intent intent = new Intent(this,InternationalBanksActivity.class);
        startActivity(intent);
    }
    public void findListedCompanies(View view){
        Intent intent = new Intent(this,CapitalMarketsActivity.class);
        startActivity(intent);
    }
}
