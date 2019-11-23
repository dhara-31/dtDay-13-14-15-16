package adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.retroprofitmydemo.R;
import com.example.retroprofitmydemo.retrofit.model.SlpitRestaurantModel;

import java.util.List;

public class SplitAdapter extends RecyclerView.Adapter<SplitAdapter.ViewHolder> {

    List<SlpitRestaurantModel.Datum> arrayList;
    private Context context;

    public SplitAdapter(List<SlpitRestaurantModel.Datum> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SplitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spli_res_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final SlpitRestaurantModel.Datum datum = arrayList.get(i);
        holder.text_restName.setText(datum.getRestaurantName());
        holder.text_restAdd.setText(datum.getAddress());
        holder.text_startTime.setText(datum.getPickupStartTime());
        holder.text_endTime.setText(datum.getPickupEndTime());


        String currentimage = datum.getRestaurantImage();
//        Log.e(TAG, "onBindViewHolder:====> "+currentimage);
        ImageView imageView = holder.split;

        Glide.with(context).load(currentimage).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(imageView);
    }


        @Override
        public int getItemCount () {
            return arrayList.size();
        }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_restName, text_restAdd,text_startTime,text_endTime;
        ImageView split;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_restName = itemView.findViewById(R.id.Rest_name);
            text_restAdd = itemView.findViewById(R.id.Rest_address);
            split= (ImageView) itemView.findViewById(R.id.split_image);
            text_startTime=itemView.findViewById(R.id.Pickup_start_time);
            text_endTime=itemView.findViewById(R.id.Pickup_end_time);
        }
    }
}



