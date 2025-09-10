package com.example.touristguide.model;

public enum Tags {
    RESTAURANT("Restaurant"),
    FREE("Gratis"),
    CHILDFRIENDLY("Børnevenlig"),
    ART("Kunst"),
    MUSEUM("Museum"),
    NATURE("Natur"),
    ENTERTAINMENT("Underholdning"),
    CONCERT("Koncert");

    private final String name;

    Tags (String str){
        this.name = str;
    }

    public String getName() {
        return name;
    }
}
