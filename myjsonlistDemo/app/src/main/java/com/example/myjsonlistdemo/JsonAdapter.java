package com.example.myjsonlistdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.ViewHolder> {

    private Context context;
    private List<JsonModel.ResultData> list;

    private Activity activity;

    public JsonAdapter(Context context, List<JsonModel.ResultData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       holder.textTitle.setText(list.get(position).getLong_name());
       holder.shortname.setText(list.get(position).getShort_name());

        String myTypeString = "";
        for (String str : list.get(position).getTypes()) {
            myTypeString += str + ", ";
        }
        myTypeString = myTypeString.length() > 0 ? myTypeString.substring(0, myTypeString.length() - 2) : myTypeString;

        holder.type.setText(myTypeString);
        holder.lat.setText(list.get(position).getLat());
        holder.lng.setText(list.get(position).getLng());
        Picasso.with(context).load(list.get(position).getIcon()).into(holder.image);
        holder.vac.setText(list.get(position).getVicinity());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, shortname, type, lat, lng,vac;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.t1);
            shortname = itemView.findViewById(R.id.shortName);
            type = itemView.findViewById(R.id.type);
            lat = itemView.findViewById(R.id.type1);
            lng = itemView.findViewById(R.id.type2);
            image = itemView.findViewById(R.id.image);
            vac = itemView.findViewById(R.id.address);

        }
    }

}


