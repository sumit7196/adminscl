package com.schooltyari.admin;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterProduct extends Filter{

    private AdapterProductSeller adapter;
    private ArrayList<ModelProduct> filterList;


    public FilterProduct(AdapterProductSeller adapter, ArrayList<ModelProduct> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected Filter.FilterResults performFiltering(CharSequence constraint) {
        Filter.FilterResults results = new Filter.FilterResults();
        //validate data for search query
        if (constraint != null && constraint.length()>0){
            //search filed not empty, searching something ,perform search

            //change to uppercase,to make sentence insensitive
            constraint = constraint.toString().toUpperCase();
            //store our filled list
            ArrayList<ModelProduct> filteredModels = new ArrayList<>();
            for (int i=0; i<filterList.size(); i++){
                //check search by title and category
                if (filterList.get(i).getProductTitle().toUpperCase().contains(constraint) ||
                        filterList.get(i).getProductCategory().toUpperCase().contains(constraint) ){
                    //add filtered data to list
                    filteredModels.add(filterList.get(i));

                }
            }
            results.count = filteredModels.size();
            results.values = filteredModels;
        }
        else {
            //search filed  empty,not searching ,return original/all/complete list

            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        adapter.productList = (ArrayList<ModelProduct>) results.values;
        //refresh adapter
        adapter.notifyDataSetChanged();

    }
}
