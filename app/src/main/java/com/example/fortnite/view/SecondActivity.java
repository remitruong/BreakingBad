package com.example.fortnite.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fortnite.R;
import com.example.fortnite.model.UpcomingItem;
import com.squareup.picasso.Picasso;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        UpcomingItem upcomingItem = (UpcomingItem) getIntent().getSerializableExtra("Item");
        TextView textView = findViewById(R.id.item_name);
        ImageView imgView = findViewById(R.id.item_icon);
        Picasso.get()
                .load(upcomingItem.getImage())  //Url of the image to load.
                .into(imgView);
        textView.setText(upcomingItem.getName());
    }
}
