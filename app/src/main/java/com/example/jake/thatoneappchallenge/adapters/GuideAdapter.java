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

    List<Guide> guideList;
    Context context;
    public GuideAdapter(Context context, List<Guide> pGuideList) {
        this.guideList = pGuideList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    //Gets the item based on current position, and gets all of the data ready for display
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        Guide guide = guideList.get(position);
        StringBuilder location = new StringBuilder("Location: ");
        location.append(guide.getVenue().getCity()).append(", ").append(guide.getVenue().getState());
        StringBuilder endDate = new StringBuilder("End Date: ");
        endDate.append(guide.getEndDate());
        Glide.with(context).load(guide.getIconUrl()).into(holder.itemImage);
        holder.nameText.setText(guide.getName());
        holder.locationText.setText(location.toString());
        holder.endDateText.setText(endDate.toString());
    }

    @Override
    public int getItemCount() {
        return guideList.size();
    }
}
