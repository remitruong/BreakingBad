package com.example.fortnite.control;

import com.example.fortnite.FortniteRestApi;
import com.example.fortnite.view.MainActivity;
import com.example.fortnite.model.RestWeaponResponse;
import com.example.fortnite.model.Weapon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainController {

    private MainActivity view;
    private FortniteRestApi fortniteRestApi;

    public MainController(MainActivity view, FortniteRestApi fortniteRestApi) {
        this.view = view;
        this.fortniteRestApi = fortniteRestApi;
    }

    public void start() {
        Call<RestWeaponResponse> call = fortniteRestApi.getFortniteList();
        call.enqueue(new Callback<RestWeaponResponse>() {
            @Override
            public void onResponse(Call<RestWeaponResponse> call, Response<RestWeaponResponse> response) {
                if(response.isSuccessful()) {
                    RestWeaponResponse restWeaponResponse = response.body();
                    List<Weapon> weaponList = restWeaponResponse.getResults();
                    System.out.println(weaponList.toArray());
                    view.showList(weaponList);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RestWeaponResponse> call, Throwable t) {
                System.err.println("Failure API");
            }
        });
    }
}