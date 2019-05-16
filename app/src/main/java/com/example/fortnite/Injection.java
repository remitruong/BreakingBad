package com.example.fortnite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {

    static final String BASE_URL = "https://fortnite-public-api.theapinetwork.com/";
    private static FortniteRestApi fortniteRestApi;

    //Singleton
    public static FortniteRestApi getInstance(){
        if(fortniteRestApi == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            fortniteRestApi = retrofit.create(FortniteRestApi.class);
        }
        return fortniteRestApi;
    }

}
