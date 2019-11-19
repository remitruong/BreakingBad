package com.example.breakingbad.model;

import java.io.Serializable;
import java.util.List;

public class BreakingBadCharacter implements Serializable {
    private String name;
    private String birthday;
    private List<String> occupation;
    private String img;
    private String status;
    private String nickname;
    private String portrayed;

    public List<String> getOccupation() {
        return occupation;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getImg() {
        return img;
    }

    public String getNickname() {
        return nickname;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getPortrayed() {
        return portrayed;
    }
}

