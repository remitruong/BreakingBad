package com.example.fortnite.model;

import java.io.Serializable;

public class UpcomingItem implements Serializable {
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
