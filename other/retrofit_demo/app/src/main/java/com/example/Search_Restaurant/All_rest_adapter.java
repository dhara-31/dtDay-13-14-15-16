package com.example.Search_Restaurant;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.demo_retrofit.Model.All_Rest_Resource;
import com.example.demo_retrofit.R;

import java.util.List;

public class All_rest_adapter extends RecyclerView.Adapter<All_rest_adapter.ViewHolder>
{
        List<All_Rest_Resource.Datum> arrayList;
        private Context context;

    public All_rest_adapter(List<All_Rest_Resource.Datum> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public All_rest_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_rest_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull All_rest_adapter.ViewHolder viewHolder, int i) {

        final All_Rest_Resource.Datum datum=arrayList.get(i);
        viewHolder.text_restName.setText(datum.getRestaurantName());
        viewHolder.text_restAdd.setText(datum.getAddress());
        viewHolder.text_startTime.setText(datum.getPickupStartTime());
        viewHolder.text_endTime.setText(datum.getPickupEndTime());
        String currentimage=datum.getRestaurantImage();

        ImageView imageView=viewHolder.rest_image;
        final ProgressBar progressBar=viewHolder.Rest_progress;

        Glide.with(context).load(currentimage).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource)
            {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource)
            {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(imageView);

    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_restName,text_restAdd,text_startTime,text_endTime;
        ImageView rest_image;
        ProgressBar Rest_progress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text_restName=itemView.findViewById(R.id.Rest_name);
            text_restAdd=itemView.findViewById(R.id.Rest_address);
            text_startTime=itemView.findViewById(R.id.Pickup_start_time);
            text_endTime=itemView.findViewById(R.id.Pickup_end_time);
            rest_image=itemView.findViewById(R.id.Rest_image);
            Rest_progress=itemView.findViewById(R.id.Rest_progress);

        }
    }
}