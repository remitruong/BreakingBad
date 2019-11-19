package com.example.breakingbad.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.breakingbad.R;
import com.example.breakingbad.model.BreakingBadCharacter;
import com.squareup.picasso.Picasso;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        BreakingBadCharacter breakingBadCharacter = (BreakingBadCharacter) getIntent().getSerializableExtra("BreakingBadCharacter");
        TextView characterTextView = findViewById(R.id.character_name);
        TextView nicknameTextView = findViewById(R.id.nickname_text);
        TextView birthdayTextView = findViewById(R.id.birthday_text);
        TextView statusTextView = findViewById(R.id.status_text);
        TextView portrayedTextView = findViewById(R.id.portrayed_text);
        TextView occupationTextView = findViewById(R.id.occupation_text);
        ImageView imgView = findViewById(R.id.character_img);
        Picasso.get()
                .load(breakingBadCharacter.getImg())  //Url of the image to load.
                .into(imgView);
        characterTextView.setText(breakingBadCharacter.getName());
        nicknameTextView.append(breakingBadCharacter.getNickname());
        birthdayTextView.append(breakingBadCharacter.getBirthday());
        statusTextView.append(breakingBadCharacter.getStatus());
        portrayedTextView.append(breakingBadCharacter.getPortrayed());
        int taille = breakingBadCharacter.getOccupation().size();
        String occupation= "";
        for (int i = taille; i < 0; i++) {
         occupation+= breakingBadCharacter.getOccupation().get(i);
        }
        occupationTextView.append(occupation);
    }
}
