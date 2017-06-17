package com.example.jake.thatoneappchallenge.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jake on 5/27/2017.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder{

    public ImageView soldImage;
    public ImageView itemImage;
    public TextView priceText;
    public TextView itemNameText;

    public RecyclerViewHolders(View itemView) {
        super(itemView);

    }
}
