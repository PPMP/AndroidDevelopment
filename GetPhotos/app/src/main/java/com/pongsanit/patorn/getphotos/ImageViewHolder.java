package com.pongsanit.patorn.getphotos;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Patorn on 8/1/16.
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbnail;
    protected TextView title;
    protected TextView link;

    public ImageViewHolder(View itemView) {
        super(itemView);
        this.thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        this.title = (TextView) itemView.findViewById(R.id.titleOfImage);
        this.link = (TextView) itemView.findViewById(R.id.link);
    }

}

//A RecyclerView - flexible view for providing a limited window into a large data set.
//Adapter: A subclass of RecyclerView.Adapter responsible for providing views that represent items in a data set
//A ViewHolder describes an item view and metadata about its place within the RecyclerView.
