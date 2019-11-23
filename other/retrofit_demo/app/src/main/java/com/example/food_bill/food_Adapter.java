package com.example.food_bill;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo_retrofit.R;

import java.util.ArrayList;

public class food_Adapter extends RecyclerView.Adapter<food_Adapter.ViewHolder>
{
        private ArrayList<food_data> arrayList;
        private Context context;

    public food_Adapter(ArrayList arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public food_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.irem_food,viewGroup,false);
        ViewHolder myHolder=new ViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull food_Adapter.ViewHolder viewHolder, int i) {

        final food_data data=arrayList.get(i);
        Log.e("TAG", "onBindViewHolder::::::::== "+data );
        viewHolder.textid.setText(data.getId());
        Log.e("TAG", "onBindViewHolder:===>>> "+viewHolder.textid );
        viewHolder.textprice.setText(data.getPrice());
        viewHolder.textqt.setText(data.getQty());
        viewHolder.texttotal.setText(data.getTotal());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textid,textprice,textqt,texttotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textid=itemView.findViewById(R.id.textView1);
            textprice=itemView.findViewById(R.id.textView2);
            textqt=itemView.findViewById(R.id.textView3);
            texttotal=itemView.findViewById(R.id.textView4);
        }
    }
}