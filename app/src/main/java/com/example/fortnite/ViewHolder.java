package com.example.fortnite;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView txtFirstLine;
    public TextView txtFooter;
    public View layout;

    public ViewHolder(View v) {
        super(v);
        layout = v;
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
    }
}