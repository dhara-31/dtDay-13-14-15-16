package com.example.food;

import android.content.Context;
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
import com.example.demo_retrofit.R;
import com.example.demo_retrofit.Model.rest_resource;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class food_adapter extends RecyclerView.Adapter<food_adapter.ViewHolder>
{
    List<rest_resource.FoodDetail> foodlist;
    Context context;

    public food_adapter(List<rest_resource.FoodDetail> arrayList, Context context) {
        this.foodlist = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public food_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view= layoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull food_adapter.ViewHolder viewHolder, int i) {


        Log.e(TAG, "onBindViewHolder:======>>> "+foodlist.get(i).getFoodName());
        viewHolder.food_name.setText(foodlist.get(i).getFoodName());
        viewHolder.food_des.setText(foodlist.get(i).getDescription());
        viewHolder.food_price.setText(""+foodlist.get(i).getOriginalPrice());

        String setimage=foodlist.get(i).getFoodImage();
        ImageView imageView=viewHolder.food_img;
        final ProgressBar progressBar=viewHolder.progressBar;

        Glide.with(context).load(setimage).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(imageView);
    }
    @Override
    public int getItemCount() {
        return foodlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView food_name,food_des,food_price;
    ImageView food_img;
    ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            food_name=itemView.findViewById(R.id.food_name);
            food_des=itemView.findViewById(R.id.food_des);
            food_price=itemView.findViewById(R.id.food_price);
            food_img=itemView.findViewById(R.id.food_img);
            progressBar=itemView.findViewById(R.id.progressBar);
        }
    }
}