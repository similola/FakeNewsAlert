package com.fakenewsalert.utils;

public enum Constants {
    TWITTER_CONSUMER_KEY(""),
    TWITTER_CONSUMER_SECRET(""),
    ACCESS_TOKEN(""),
    ACCESS_SECRET("");

    private String constant;

    Constants(String constant) {
        this.constant=constant;
    }

    public String getValue(){
        return this.constant;
    }
}
