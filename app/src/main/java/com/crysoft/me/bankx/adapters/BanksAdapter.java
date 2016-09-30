package com.crysoft.me.bankx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crysoft.me.bankx.Models.BankModel;
import com.crysoft.me.bankx.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Maxx on 7/29/2016.
 */
public class BanksAdapter extends BaseAdapter  {
    private List<BankModel> banksList;
    private LayoutInflater layoutInflater;
    private Context myContext;

    public BanksAdapter(LayoutInflater layoutInflater, List<BankModel> categoryList, Context context) {
        this.layoutInflater = layoutInflater;
        this.banksList = categoryList;
        this.myContext = context;
    }
    @Override
    public int getCount() {
        return banksList.size();
    }

    @Override
    public Object getItem(int position) {
        return banksList.get(position);
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
            viewHolder.bankLogo = (ImageView) convertView.findViewById(R.id.bankLogo);
            viewHolder.bankName = (TextView) convertView.findViewById(R.id.bankTitle);
            viewHolder.bankSummary = (TextView) convertView.findViewById(R.id.bankSummary);
            //viewHolder.productDescription = (TextView) convertView.findViewById(R.id.tvItemDescription);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BankModel bankDetails = banksList.get(position);

        viewHolder.bankName.setText(bankDetails.getBankName());
//        viewHolder.bankSummary.setText(bankDetails.getBankSummary());
//        viewHolder.productDescription.setText(productDetails.getDescription());

     /*   if (bankDetails.getBankImage()!=null){
            Picasso.with(myContext).load(bankDetails.getBankImage()).into(viewHolder.bankLogo);
        }else{

        }
        */
        return convertView;
    }
    public class ViewHolder {
        ImageView bankLogo;
        TextView bankName;
        TextView bankSummary;
    }




}
