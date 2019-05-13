package com.example.fortnite.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.fortnite.Injection;
import com.example.fortnite.R;
import com.example.fortnite.control.MainController;
import com.example.fortnite.model.Weapon;

import java.util.List;

public class MainActivity extends Activity {
    //Déclaration des variables
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainController controller = new MainController(this, Injection.getRestApiInstance());
        controller.start();
    }

    public void showList(List<Weapon> weaponList) {
        //Initialisation de la variable recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //Optimisation des performances Merci la documentation.
        recyclerView.setHasFixedSize(true);
        // Layout Manager = Manage l'affichage. Ici en liste Verticale
        //Initialisation de la variable layoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        //Initialisation de la variable mAdapter
        mAdapter = new MyAdapter(weaponList);
        recyclerView.setAdapter(mAdapter);
    }
}
