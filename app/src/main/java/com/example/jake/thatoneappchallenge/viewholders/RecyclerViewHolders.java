package com.example.jake.thatoneappchallenge.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jake.thatoneappchallenge.R;

/**
 * Created by Jake on 5/27/2017.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder{

    public ImageView itemImage;
    public TextView nameText;
    public TextView locationText;
    public TextView endDateText;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        this.itemImage = (ImageView)itemView.findViewById(R.id.iv_item);
        this.nameText = (TextView) itemView.findViewById(R.id.tv_name);
        this.locationText = (TextView)itemView.findViewById(R.id.tv_location);
        this.endDateText = (TextView)itemView.findViewById(R.id.tv_end_date);
    }
}
