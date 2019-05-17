package com.example.fortnite.model;

import java.util.List;

public class RestWeaponResponse {

    private Integer count;
    private List<UpcomingItem> items;

    public List<UpcomingItem> getResults(){
        return items;
    }
}
