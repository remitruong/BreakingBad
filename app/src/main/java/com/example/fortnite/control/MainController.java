package com.example.fortnite.control;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.example.fortnite.FortniteRestApi;
import com.example.fortnite.model.RestWeaponResponse;
import com.example.fortnite.model.UpcomingItem;
import com.example.fortnite.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    private MainActivity view;
    private FortniteRestApi fortniteRestApi;
    private SharedPreferences sharedPreferences;

    public MainController(MainActivity view, FortniteRestApi fortniteRestApi, SharedPreferences sharedPreferences) {
        this.view = view;
        this.fortniteRestApi = fortniteRestApi;
        this.sharedPreferences =sharedPreferences;
    }

    public void start() {
        Call<RestWeaponResponse> call = fortniteRestApi.getFortniteList();
        call.enqueue(new Callback<RestWeaponResponse>() {
            @Override
            public void onResponse(Call<RestWeaponResponse> call, Response<RestWeaponResponse> response) {
                if(response.isSuccessful()) {
                    RestWeaponResponse restWeaponResponse = response.body();
                    List<UpcomingItem> upcomingItemList = restWeaponResponse.getResults();
                    storeData(upcomingItemList);
                    view.showList(upcomingItemList);
                } else {
                    System.out.println(response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<RestWeaponResponse> call, Throwable t) {
                System.err.println("Erreur lors de l'appel de l'API");
                List<UpcomingItem> upcomingItemList = getDataFromCache();
                view.showList(upcomingItemList);
            }
        });
    }

    private void storeData(List<UpcomingItem> upcomingItems) {
        Gson gson = new Gson();
        String listUpcomingItemsString = gson.toJson(upcomingItems);
        sharedPreferences
                .edit()
                .putString("cle_string", listUpcomingItemsString)
                .apply();
    }

    private List<UpcomingItem> getDataFromCache() {
        String listUpcomingItemsString = sharedPreferences.getString("cle_string", "");
        if(listUpcomingItemsString != null && !TextUtils.isEmpty(listUpcomingItemsString)){
            Type listType = new TypeToken<List<UpcomingItem>>(){}.getType();
            List<UpcomingItem> upcomingItemList = new Gson().fromJson(listUpcomingItemsString, listType);
            return upcomingItemList;
        }
        return new ArrayList<>();
    }
}