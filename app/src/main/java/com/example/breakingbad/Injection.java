package com.example.breakingbad;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {

    static final String BASE_URL = "https://www.breakingbadapi.com/api/";
    private static BreakingBadRestApi breakingBadRestApi;
    //Singleton
    public static BreakingBadRestApi getInstance(){
        if(breakingBadRestApi == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            breakingBadRestApi = retrofit.create(BreakingBadRestApi.class);
        }
        return breakingBadRestApi;
    }
}
