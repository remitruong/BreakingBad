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
        TextView itemTextView = findViewById(R.id.item_name);
        TextView rarityTextView = findViewById(R.id.rarity_text);
        TextView avgStarsTextView = findViewById(R.id.avgStars_text);
        TextView totalPointsTextView = findViewById(R.id.totalPoints_text);
        TextView numberVotesTextView = findViewById(R.id.numberVotes_text);
        ImageView imgView = findViewById(R.id.item_icon);
        Picasso.get()
                .load(upcomingItem.getImage())  //Url of the image to load.
                .into(imgView);
        itemTextView.setText(upcomingItem.getName());
        rarityTextView.append(upcomingItem.getItem().getRarity());
        avgStarsTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon, 0, 0, 0);
        avgStarsTextView.append(upcomingItem.getRatings().getAvgStars());
        totalPointsTextView.append(upcomingItem.getRatings().getTotalPoints());
        numberVotesTextView.append(upcomingItem.getRatings().getNumberVotes());
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
