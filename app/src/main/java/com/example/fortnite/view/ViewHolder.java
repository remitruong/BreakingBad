package com.example.fortnite.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fortnite.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView txtFirstLine;
    public TextView txtFooter;
    public ImageView image;
    public View layout;

    public ViewHolder(View view) {
        super(view);
        layout = view;
        txtFirstLine = (TextView) view.findViewById(R.id.firstLine);
        txtFooter = (TextView) view.findViewById(R.id.secondLine);
        image = (ImageView) view.findViewById(R.id.icon);
    }
}