package com.example.touristguide.model;

public class TouristAttraction {
    private int id;
    private String name;
    private String description;

    public TouristAttraction(String name, String description, int id) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public TouristAttraction(){}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
