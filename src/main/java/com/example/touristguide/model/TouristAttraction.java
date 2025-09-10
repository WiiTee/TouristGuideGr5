package com.example.touristguide.model;

import java.util.ArrayList;

public class TouristAttraction {
    private int id;
    private String name;
    private String description;
    private String city;
    private ArrayList<Tags> selectedTags = new ArrayList<>();

    public TouristAttraction(String name, String description, String city, int id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
    }

    public TouristAttraction(String name, String description, String city, int id, ArrayList<Tags> tagList) {
        this.id = id;
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

    public void setTagList(ArrayList<Tags> tagList) {
        this.selectedTags = tagList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
