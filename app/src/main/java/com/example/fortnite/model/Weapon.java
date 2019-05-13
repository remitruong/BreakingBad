package com.example.fortnite.model;

import java.util.List;

public class Weapon {
    private String name;
    private String url;
    private String description;
    private Item item;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Item getItem() {
        return item;
    }

    public String getImage(){
        return item.getImageUrl();
    }

    public String getDescription() {
        return description;
    }
}
