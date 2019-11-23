package adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.retroprofitmydemo.R;

import java.util.ArrayList;
import java.util.List;


import model.OdrderDetail;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    List<OdrderDetail> list = new ArrayList<>();

    public CustomAdapter(Context context, List<OdrderDetail> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.litview_item, parent, false);
        }

        TextView id = (TextView) convertView.findViewById(R.id.edId);
        TextView qty = (TextView) convertView.findViewById(R.id.edQty);
        TextView price = (TextView) convertView.findViewById(R.id.edPrice);
        TextView toatal = (TextView) convertView.findViewById(R.id.edTotal);
        id.setText(list.get(position).getFoodId());
        qty.setText(list.get(position).getQuantity());
        price.setText(list.get(position).getPrice());
        toatal.setText(list.get(position).getTotal());
        return convertView;
    }

}


