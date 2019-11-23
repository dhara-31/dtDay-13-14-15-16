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

import java.util.List;

public class showfooddata_adapter extends RecyclerView.Adapter<showfooddata_adapter.ViewHolder>
{
    private List<Food_resource.Order> list;
    private Context context;

    public showfooddata_adapter(List<Food_resource.Order> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public showfooddata_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.irem_food,viewGroup,false);
        ViewHolder myHolder=new ViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull showfooddata_adapter.ViewHolder viewHolder, int i) {


        viewHolder.txt_foodqty.setText(list.get(i).getQuantity()+"");
        Log.e("TAG", "onBindViewHolder: "+list.get(i).getQuantity() );

        viewHolder.txt_foodid.setText(""+list.get(i).getFoodId());
        viewHolder.txt_price.setText(""+list.get(i).getOriginalPrice());
        viewHolder.txt_total.setText(""+list.get(i).getTotalPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView txt_foodid,txt_foodqty,txt_price,txt_total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_foodid=itemView.findViewById(R.id.textView1);
            txt_foodqty=itemView.findViewById(R.id.textView3);
            txt_price=itemView.findViewById(R.id.textView2);
            txt_total=itemView.findViewById(R.id.textView4);

        }
    }
}