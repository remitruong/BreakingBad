package com.example.breakingbad.controller;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import com.example.breakingbad.BreakingBadRestApi;
import com.example.breakingbad.model.BreakingBadCharacter;
import com.example.breakingbad.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainController implements Callback<List<BreakingBadCharacter>>{

    private MainActivity view;
    private BreakingBadRestApi breakingBadRestApi;
    private SharedPreferences sharedPreferences;

    public MainController(Fragment fragment, BreakingBadRestApi breakingBadRestApi, SharedPreferences sharedPreferences) {
        this.breakingBadRestApi = breakingBadRestApi;
        this.sharedPreferences = sharedPreferences;
    }

    public void start() {
        Call<List<BreakingBadCharacter>> call = breakingBadRestApi.getBreakingBadCharacterList();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<BreakingBadCharacter>> call, Response<List<BreakingBadCharacter>> response) {
        if(response.isSuccessful()) {
            List<BreakingBadCharacter> breakingBadCharacterList = response.body();
            storeData(breakingBadCharacterList);
            //Log.d("retour API", new GsonBuilder().setPrettyPrinting().create().toJson(response));
            //view.showList(breakingBadCharacterList);
            //Log.d("LISTE DES CHAMPIONS : ", breakingBadCharacterList.toString());
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<BreakingBadCharacter>> call, Throwable t) {
//Log.d("API ERROR", "onFailure");
        List<BreakingBadCharacter> breakingBadCharacterList = getDataFromCache();
        //view.showList(breakingBadCharacterList);
        //t.printStackTrace();
    }

    private void storeData(List<BreakingBadCharacter> breakingBadCharacterList) {
        Gson gson = new Gson();
        String listBreakingBadCharacter = gson.toJson(breakingBadCharacterList);
        sharedPreferences
                .edit()
                .putString("cle_string", listBreakingBadCharacter)
                .apply();
    }

    public List<BreakingBadCharacter>  getDataFromCache() {
        List<BreakingBadCharacter> breakingBadCharacterList;
        String listBreakingBadCharacterString = sharedPreferences.getString("cle_string", "");
        if(listBreakingBadCharacterString != null && !TextUtils.isEmpty(listBreakingBadCharacterString)){
            Type listType = new TypeToken<List<BreakingBadCharacter>>(){}.getType();
            breakingBadCharacterList = new Gson().fromJson(listBreakingBadCharacterString, listType);
            return breakingBadCharacterList;
        }
        return new ArrayList<>();
    }

    public List<BreakingBadCharacter> getDeathsList(List<BreakingBadCharacter> bbList){
        List<BreakingBadCharacter> deathsList = new ArrayList<>();
        for (BreakingBadCharacter bbCharacter: bbList) {
            System.out.println("***********" + bbCharacter.getName() + "====>" + bbCharacter.getStatus() +"***********");
            if (bbCharacter != null && bbCharacter.getStatus().equals("Deceased")) {
                deathsList.add(bbCharacter);
            }
        }
        return deathsList;
    }


}
