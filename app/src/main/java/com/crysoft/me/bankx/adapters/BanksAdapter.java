package com.crysoft.me.bankx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.crysoft.me.bankx.Models.BankModel;
import com.crysoft.me.bankx.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxx on 7/29/2016.
 */
public class BanksAdapter extends BaseAdapter implements Filterable {
    //private List<BankModel> banksList;
    private List<BankModel> originalList;
    private List<BankModel> filteredList;
    private LayoutInflater layoutInflater;
    private ItemFilter mFilter = new ItemFilter();
    private Context myContext;

    public BanksAdapter(LayoutInflater layoutInflater, List<BankModel> bankList, Context context) {
        this.layoutInflater = layoutInflater;
        this.filteredList = bankList;
        this.originalList = bankList;
        this.myContext = context;
    }
    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.bank_items,null);
            viewHolder.bankLogo = (ImageView) convertView.findViewById(R.id.bankLogo);
            viewHolder.bankName = (TextView) convertView.findViewById(R.id.bankTitle);
            //viewHolder.bankSummary = (TextView) convertView.findViewById(R.id.bankSummary);
            viewHolder.bankStatus = (TextView) convertView.findViewById(R.id.bankStatus);
            //viewHolder.productDescription = (TextView) convertView.findViewById(R.id.tvItemDescription);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BankModel bankDetails = filteredList.get(position);

        viewHolder.bankName.setText(bankDetails.getBankName());
        //String summary = bankDetails.getBankSummary().toString();
        //viewHolder.bankSummary.setText(summary.substring(0,50));
        viewHolder.bankStatus.setText(bankDetails.getBankStatus());
//        viewHolder.productDescription.setText(productDetails.getDescription());

       if (bankDetails.getBankImage()!=null){
            Picasso.with(myContext).load(bankDetails.getBankImage()).into(viewHolder.bankLogo);
        }else{

        }

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    public class ViewHolder {
        ImageView bankLogo;
        TextView bankName;
        TextView bankSummary;
        TextView bankStatus;
    }
    private class ItemFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();

            final List<BankModel> list = originalList;

            int count = list.size();
            final ArrayList<BankModel> nList = new ArrayList<BankModel>(count);
            BankModel filtereableModel;

            for(int i=0; i<count; i++){
                filtereableModel = list.get(i);
                if (filtereableModel.getBankName().toLowerCase().contains(filterString)){
                    nList.add(filtereableModel);
                }
            }
            results.values = nList;
            results.count = nList.size();
            return results;
        }
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (ArrayList<BankModel>)results.values;
            notifyDataSetChanged();
        }
    }




}
