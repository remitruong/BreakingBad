package com.example.fortnite.model;

public class Ratings extends UpcomingItem {

    private float avgStars;
    private String avgStarsString = "";
    private int totalPoints;
    private String totalPointsString = "";
    private int numberVotes;
    private String numberVotesString = "";

    public String getAvgStars() {
        return avgStarsString =  Float.toString(avgStars);
    }

    public String getTotalPoints() {
        return totalPointsString = Float.toString(totalPoints);
    }

    public String getNumberVotes() {
        return numberVotesString = Float.toString(numberVotes);
    }
}
