package com.example.fortnite;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FortniteRestApi {
    @GET("prod09/upcoming/get")
    Call<RestWeaponResponse> getFortniteList();
}
