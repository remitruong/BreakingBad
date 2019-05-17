package com.example.fortnite.view;

import android.app.Activity;
import android.os.Bundle;
import com.example.fortnite.Injection;
import com.example.fortnite.R;
import com.example.fortnite.control.MainController;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
