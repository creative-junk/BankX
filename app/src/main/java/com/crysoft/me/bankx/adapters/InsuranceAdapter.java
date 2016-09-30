package com.crysoft.me.bankx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crysoft.me.bankx.Models.InsuranceModel;
import com.crysoft.me.bankx.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Maxx on 7/29/2016.
 */
public class InsuranceAdapter extends BaseAdapter {
    private List<InsuranceModel> insurancesList;
    private LayoutInflater layoutInflater;
    private Context myContext;

    public InsuranceAdapter(LayoutInflater layoutInflater, List<InsuranceModel> categoryList, Context context) {
        this.layoutInflater = layoutInflater;
        this.insurancesList = categoryList;
        this.myContext = context;
    }
    @Override
    public int getCount() {
        return insurancesList.size();
    }

    @Override
    public Object getItem(int position) {
        return insurancesList.get(position);
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
            convertView = layoutInflater.inflate(R.layout.insurance_items,null);
            viewHolder.insuranceLogo = (ImageView) convertView.findViewById(R.id.insuranceLogo);
            viewHolder.insuranceName = (TextView) convertView.findViewById(R.id.insuranceTitle);
            viewHolder.insuranceSummary = (TextView) convertView.findViewById(R.id.insuranceSummary);
            //viewHolder.productDescription = (TextView) convertView.findViewById(R.id.tvItemDescription);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        InsuranceModel insuranceDetails = insurancesList.get(position);

        viewHolder.insuranceName.setText(insuranceDetails.getInsuranceName());
        viewHolder.insuranceSummary.setText(insuranceDetails.getInsuranceSummary());
//        viewHolder.productDescription.setText(productDetails.getDescription());

        if (insuranceDetails.getInsuranceImage()!=null){
            Picasso.with(myContext).load(insuranceDetails.getInsuranceImage()).into(viewHolder.insuranceLogo);
        }else{

        }
        return convertView;
    }
    public class ViewHolder {
        ImageView insuranceLogo;
        TextView insuranceName;
        TextView insuranceSummary;
    }




}
