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

public class DeathsFragment extends Fragment {
    private MainController controller;
    private RecyclerView recyclerView;
    private List<BreakingBadCharacter> deathsList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deaths, container, false);

        recyclerView = view.findViewById(R.id.deaths_recycler_view);
        controller = new MainController(this, Injection.getInstance(), this.getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE));
        List<BreakingBadCharacter> breakingBadCharacters = controller.getDataFromCache();
        deathsList = controller.getDeathsList(breakingBadCharacters);
        this.showList(deathsList);
        return view;
    }


    private void showList(List<BreakingBadCharacter> breakingBadCharacterList) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(new MyAdapter(breakingBadCharacterList));
    }
}
