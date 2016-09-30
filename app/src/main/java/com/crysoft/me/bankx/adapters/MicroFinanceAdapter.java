package com.crysoft.me.bankx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crysoft.me.bankx.Models.MicroFinanceModel;
import com.crysoft.me.bankx.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Maxx on 7/29/2016.
 */
public class MicroFinanceAdapter extends BaseAdapter {
    private List<MicroFinanceModel> microFinancesList;
    private LayoutInflater layoutInflater;
    private Context myContext;

    public MicroFinanceAdapter(LayoutInflater layoutInflater, List<MicroFinanceModel> categoryList, Context context) {
        this.layoutInflater = layoutInflater;
        this.microFinancesList = categoryList;
        this.myContext = context;
    }
    @Override
    public int getCount() {
        return microFinancesList.size();
    }

    @Override
    public Object getItem(int position) {
        return microFinancesList.get(position);
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
            convertView = layoutInflater.inflate(R.layout.micro_finance_items,null);
            viewHolder.microFinanceLogo = (ImageView) convertView.findViewById(R.id.microFinanceLogo);
            viewHolder.microFinanceName = (TextView) convertView.findViewById(R.id.microFinanceTitle);
            viewHolder.microFinanceSummary = (TextView) convertView.findViewById(R.id.microFinanceSummary);
            //viewHolder.productDescription = (TextView) convertView.findViewById(R.id.tvItemDescription);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MicroFinanceModel microFinanceDetails = microFinancesList.get(position);

        viewHolder.microFinanceName.setText(microFinanceDetails.getMicroFinanceName());
        viewHolder.microFinanceSummary.setText(microFinanceDetails.getMicroFinanceSummary());
//        viewHolder.productDescription.setText(productDetails.getDescription());

        if (microFinanceDetails.getMicroFinanceImage()!=null){
            Picasso.with(myContext).load(microFinanceDetails.getMicroFinanceImage()).into(viewHolder.microFinanceLogo);
        }else{

        }
        return convertView;
    }
    public class ViewHolder {
        ImageView microFinanceLogo;
        TextView microFinanceName;
        TextView microFinanceSummary;
    }




}
