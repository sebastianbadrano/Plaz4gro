package com.example.plaz4gro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter2 extends BaseAdapter {

    private ArrayList<Product> singleRow;
    private LayoutInflater thisInflater;

    public ProductAdapter2(Context context, ArrayList<Product> aRow){
        this.singleRow = aRow;
        thisInflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return singleRow.size();
    }

    @Override
    public Object getItem(int position) {
        return singleRow.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=thisInflater.inflate(R.layout.producto_lista2,parent,false);

            TextView txtNameProduct = (TextView) convertView.findViewById(R.id.productName);
            TextView txtFarmerProduct = (TextView) convertView.findViewById(R.id.productFarmer);
            //TextView txtQuantityProduct = (TextView) convertView.findViewById(R.id.productQuantity);
            Product currentItemProduct = (Product) getItem(position);
            txtNameProduct.setText(currentItemProduct.getName());
            txtFarmerProduct.setText(currentItemProduct.getFarmer());
            //txtQuantityProduct.setText(currentItemProduct.getQuantity());
        }
        return convertView;
    }
}
