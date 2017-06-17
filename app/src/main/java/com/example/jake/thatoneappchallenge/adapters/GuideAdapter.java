package com.example.jake.thatoneappchallenge.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jake.thatoneappchallenge.R;
import com.example.jake.thatoneappchallenge.entities.Guide;
import com.example.jake.thatoneappchallenge.viewholders.RecyclerViewHolders;

import java.util.List;

/**
 * Created by Jake on 5/27/2017.
 */

public class GuideAdapter extends RecyclerView.Adapter<RecyclerViewHolders>{

    List<Guide> itemList;
    Context context;

    public GuideAdapter(Context context, List<Guide> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    //Gets the item based on current position, and gets all of the data ready for display
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        Guide item = itemList.get(position);
        /*StringBuilder price = new StringBuilder(MercariConstants.DOLLAR);
        //Displays sold if the status is sold out
        if(item.status.equals(MercariConstants.SOLD_OUT)) {
            holder.soldImage.setVisibility(View.VISIBLE);
        }
        Glide.with(context).load(item.photo).into(holder.itemImage);
        price.append(itemList.get(position).price);
        holder.priceText.setText(price.toString());
        holder.itemNameText.setText(itemList.get(position).name);*/
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
