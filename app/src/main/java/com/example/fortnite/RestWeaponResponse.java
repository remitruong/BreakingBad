package com.example.fortnite;

import java.util.List;

public class RestWeaponResponse {

    private Integer count;
    private List<Weapon> items;

    public List<Weapon> getResults(){
        return items;
    }
}
