package com.crysoft.me.bankx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.crysoft.me.bankx.Models.CapitalMarketsModel;
import com.crysoft.me.bankx.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Maxx on 7/29/2016.
 */
public class CompanyAdapter extends BaseAdapter {
    private List<CapitalMarketsModel> companyList;
    private LayoutInflater layoutInflater;
    private Context myContext;

    public CompanyAdapter(LayoutInflater layoutInflater, List<CapitalMarketsModel> companyList, Context context) {
        this.layoutInflater = layoutInflater;
        this.companyList = companyList;
        this.myContext = context;
    }
    @Override
    public int getCount() {
        return companyList.size();
    }

    @Override
    public Object getItem(int position) {
        return companyList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.bank_items,null);
            viewHolder.companyLogo = (ImageView) convertView.findViewById(R.id.companyLogo);
            viewHolder.companyName = (TextView) convertView.findViewById(R.id.bankTitle);
            viewHolder.companySummary = (TextView) convertView.findViewById(R.id.companySummary);
            //viewHolder.productDescription = (TextView) convertView.findViewById(R.id.tvItemDescription);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CapitalMarketsModel companyDetails = companyList.get(position);

        viewHolder.companyName.setText(companyDetails.getCompanyName());
        viewHolder.companySummary.setText(companyDetails.getCompanySummary());
//        viewHolder.productDescription.setText(productDetails.getDescription());

        if (companyDetails.getCompanyImage()!=null){
            Picasso.with(myContext).load(companyDetails.getCompanyImage()).into(viewHolder.companyLogo);
        }else{

        }
        return convertView;
    }
    public class ViewHolder {
        ImageView companyLogo;
        TextView companyName;
        TextView companySummary;
    }




}
