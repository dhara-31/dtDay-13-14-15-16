package adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.retroprofitmydemo.R;
import com.example.retroprofitmydemo.retrofit.model.AllRestaurant;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ResurantAdapter extends RecyclerView.Adapter<ResurantAdapter.ViewHolder> {

    ArrayList<AllRestaurant.Datum> arrayList;
    private Context context;


    public ResurantAdapter(ArrayList<AllRestaurant.Datum> arrayList, Context context) {

        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ResurantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurant_all_item, viewGroup, false);
        Log.e("Tag==", "onCreateViewHolder:====> " + view);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResurantAdapter.ViewHolder viewHolder, int i) {

        final AllRestaurant.Datum datum = arrayList.get(i);
        viewHolder.textname.setText(datum.getRestaurantName());
        viewHolder.textaddres.setText(datum.getRestaurantAddress());
        viewHolder.text_starttime.setText(convert(datum.getStartTime()));
        viewHolder.text_end_time.setText(convert(datum.getEndTime()));
        Picasso.with(context).load(datum.getRestaurantImage()).into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textname, textaddres, text_starttime, text_end_time;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            textname = itemView.findViewById(R.id.text_restname);
            textaddres = itemView.findViewById(R.id.text_address);
            text_starttime = itemView.findViewById(R.id.text_start_time);
            text_end_time = itemView.findViewById(R.id.text_end_time);
            imageView=itemView.findViewById(R.id.Rest_image);

        }
    }

    public String convert(String Time) {

        SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
        Date dateObj = null;
        try {
            dateObj = sdf.parse(Time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new SimpleDateFormat("K:mm aa").format(dateObj);

    }
}
