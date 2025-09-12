package com.example.touristguide.model;

import java.util.ArrayList;

public class TouristAttraction {
    private String name;
    private String description;
    private String city;
    private ArrayList<Tags> selectedTags = new ArrayList<>();

    public TouristAttraction(String name, String description, String city) {
        this.name = name;
        this.description = description;
        this.city = city;
    }

    public TouristAttraction(String name, String description, String city,ArrayList<Tags> tagList) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.selectedTags = tagList;
    }

    public TouristAttraction(){}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public ArrayList<Tags> getSelectedTags() {
        return selectedTags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSelectedTags(ArrayList<Tags> tagList) {
        this.selectedTags = tagList;
    }
}
