package com.example.demo_retrofit;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import com.example.demo_retrofit.Model.rest_resource;
import com.example.food.Food_detail;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class restaurant_adapter extends RecyclerView.Adapter<restaurant_adapter.ViewHolder>

        {
            List<rest_resource.Datum> arrayList;

            private Context context;

            public restaurant_adapter(List<rest_resource.Datum> arrayList, Context context) {
                this.arrayList = arrayList;
                this.context = context;
            }

            @NonNull
            @Override
            public restaurant_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restarant_item,viewGroup,false);
                Log.e("Tag==", "onCreateViewHolder:====> "+view );
                ViewHolder viewHolder=new ViewHolder(view);

                return viewHolder;
            }

            @Override
            public void onBindViewHolder(@NonNull final restaurant_adapter.ViewHolder viewHolder, final int i) {

                final rest_resource.Datum datum=arrayList.get(i);
                Log.e(TAG, "onBindViewHolder::::==> "+arrayList.get(i));
                viewHolder.textname.setText(datum.getRestaurantName());
                Log.e(TAG, "onBindViewHolder:========>> "+datum.getRestaurantName() );
                viewHolder.textaddres.setText(datum.getRestaurantAddress());
                viewHolder.text_starttime.setText(convert(datum.getStartTime()));
                viewHolder.text_end_time.setText(convert(datum.getEndTime()));

                /* Glide.with(context).load(datum.getRestaurantImage()).into(viewHolder.imageView); */

                String currentimage=datum.getRestaurantImage();
                Log.e(TAG, "onBindViewHolder:====> "+currentimage);
                ImageView imageView=viewHolder.imageView;
                final ProgressBar progressBar=viewHolder.progressBar;

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

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent=new Intent(context, Food_detail.class);
                        intent.putExtra("data", (Serializable) arrayList.get(i).getFoodDetail());
                        Log.e("TAG", "onClick::::>>"+intent);
                        context.startActivity(intent);
                    }
                });

            }

            @Override
            public int getItemCount() {

                return arrayList.size();
            }

            public class ViewHolder extends RecyclerView.ViewHolder {

                TextView textname,textaddres,text_starttime,text_end_time;
                ImageView imageView;
                ProgressBar progressBar;

                public ViewHolder(@NonNull View itemView) {

                    super(itemView);

                        textname=itemView.findViewById(R.id.text_restname);
                        textaddres=itemView.findViewById(R.id.text_address);
                        text_starttime=itemView.findViewById(R.id.text_start_time);
                        text_end_time=itemView.findViewById(R.id.text_end_time);
                        imageView=itemView.findViewById(R.id.imageview);
                        progressBar=itemView.findViewById(R.id.progressbar);
                }
            }

            public static String convert(String Time) {
                SimpleDateFormat f1 = new SimpleDateFormat("H:mm"); //11:00 pm
                Date d = null;
                try {
                    d = f1.parse(Time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat f2 = new SimpleDateFormat("K:mm");
                String x = f2.format(d); // "23:00"

                return x;
            }
        }

         /* public String convert(String Time) {

                SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
                Date dateObj = null;
                try {
                    dateObj = sdf.parse(Time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                return new SimpleDateFormat("K:mm").format(dateObj);
            }*/