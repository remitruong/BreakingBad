package com.example.breakingbad;


import com.example.breakingbad.model.BreakingBadCharacter;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BreakingBadRestApi {
    @GET("characters")
    Call<List<BreakingBadCharacter>> getBreakingBadCharacterList();
}
