package com.example.breakingbad.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.breakingbad.Injection;
import com.example.breakingbad.R;
import com.example.breakingbad.controller.MainController;
import com.example.breakingbad.model.BreakingBadCharacter;

import java.util.List;

public class FavoritesFragment extends Fragment {

    private MainController controller;
    private RecyclerView recyclerView;
    private List<BreakingBadCharacter> seasonList;
    private FloatingActionButton fab, fab1, fab2, fab3, fab4, fab5;
    private LinearLayout fabLayout1, fabLayout2, fabLayout3, fabLayout4, fabLayout5;
    private View fabBGLayout;
    private boolean isFABOpen = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        recyclerView = view.findViewById(R.id.favorites_recycler_view);
        controller = new MainController(this, Injection.getInstance(), this.getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE));
        final List<BreakingBadCharacter> breakingBadCharacters = controller.getDataFromCache();
        seasonList = controller.getListBySeason(breakingBadCharacters, "1");
        this.showList(seasonList);

        fabLayout1 = view.findViewById(R.id.fabLayout1);
        fabLayout2 = view.findViewById(R.id.fabLayout2);
        fabLayout3 = view.findViewById(R.id.fabLayout3);
        fabLayout4 =  view.findViewById(R.id.fabLayout4);
        fabLayout5 =  view.findViewById(R.id.fabLayout5);
        fab = view.findViewById(R.id.fab);
        fab1 = view.findViewById(R.id.fab1);
        fab2 = view.findViewById(R.id.fab2);
        fab3 = view.findViewById(R.id.fab3);
        fab4 = view.findViewById(R.id.fab4);
        fab5 = view.findViewById(R.id.fab5);
        fabBGLayout = view.findViewById(R.id.fabBGLayout);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFABOpen) {
                    showFABMenu();
                } else {
                    closeFABMenu();
                }
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seasonList = controller.getListBySeason(breakingBadCharacters, "1");
                showList(seasonList);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seasonList = controller.getListBySeason(breakingBadCharacters, "2");
                showList(seasonList);
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seasonList = controller.getListBySeason(breakingBadCharacters, "3");
                showList(seasonList);
            }
        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seasonList = controller.getListBySeason(breakingBadCharacters, "4");
                showList(seasonList);
            }
        });

        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seasonList = controller.getListBySeason(breakingBadCharacters, "5");
                showList(seasonList);
            }
        });

        fabBGLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFABMenu();
            }
        });

        return view;
    }

    private void showFABMenu() {
        isFABOpen = true;
        fabLayout1.setVisibility(View.VISIBLE);
        fabLayout2.setVisibility(View.VISIBLE);
        fabLayout3.setVisibility(View.VISIBLE);
        fabLayout4.setVisibility(View.VISIBLE);
        fabLayout5.setVisibility(View.VISIBLE);
        fabBGLayout.setVisibility(View.VISIBLE);
        fab.animate().rotationBy(180);
        fabLayout1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabLayout2.animate().translationY(-getResources().getDimension(R.dimen.standard_100));
        fabLayout3.animate().translationY(-getResources().getDimension(R.dimen.standard_145));
        fabLayout4.animate().translationY(-getResources().getDimension(R.dimen.standard_190));
        fabLayout5.animate().translationY(-getResources().getDimension(R.dimen.standard_235));
    }

    private void closeFABMenu() {
        isFABOpen = false;
        fabBGLayout.setVisibility(View.GONE);
        fab.animate().rotation(0);
        fabLayout1.animate().translationY(0);
        fabLayout2.animate().translationY(0);
        fabLayout3.animate().translationY(0);
        fabLayout4.animate().translationY(0);
        fabLayout5.animate().translationY(0);
        fabLayout5.animate().translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (!isFABOpen) {
                    fabLayout1.setVisibility(View.GONE);
                    fabLayout2.setVisibility(View.GONE);
                    fabLayout3.setVisibility(View.GONE);
                    fabLayout4.setVisibility(View.GONE);
                    fabLayout5.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private void showList(List<BreakingBadCharacter> breakingBadCharacterList) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(new MyAdapter(breakingBadCharacterList));
    }
}
