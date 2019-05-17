package com.example.fortnite.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.fortnite.R;
import com.example.fortnite.model.UpcomingItem;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<UpcomingItem> listItem;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<UpcomingItem> myDataset) {
        listItem = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final UpcomingItem currentUpcomingItem = listItem.get(position);
        holder.txtFirstLine.setText(currentUpcomingItem.getName());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("Item", listItem.get(position));
                v.getContext().startActivity(intent);
            }
        });
        holder.txtFooter.setText(currentUpcomingItem.getDescription());
        Picasso.get()
                .load(currentUpcomingItem.getImage())  //Url of the image to load.
                .resize(100, 100)
                .centerCrop()
                .into(holder.image);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listItem.size();
    }


}