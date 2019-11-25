package com.example.breakingbad.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.breakingbad.Injection;
import com.example.breakingbad.R;
import com.example.breakingbad.controller.MainController;
import com.example.breakingbad.model.BreakingBadCharacter;

import java.util.List;

public class HomeFragment extends Fragment {
    private MainController controller;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);

        recyclerView = view.findViewById(R.id.my_recycler_view);
        controller = new MainController(this, Injection.getInstance(), this.getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE));

        controller.start();

        List<BreakingBadCharacter> breakingBadCharacters = controller.getDataFromCache();
        this.showList(breakingBadCharacters);
        return view;
    }



    private void showList(List<BreakingBadCharacter> breakingBadCharacterList) {
        //Initialisation de la variable recyclerView
        //Optimisation des performances
        recyclerView.setHasFixedSize(true);
        // Layout Manager = Manage l'affichage. Ici en liste Verticale
        //Initialisation de la variable layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());

        recyclerView.setLayoutManager(layoutManager);

        //Initialisation de la variable mAdapter
        MyAdapter mAdapter = new MyAdapter(breakingBadCharacterList);
        recyclerView.setAdapter(mAdapter);
    }

}
