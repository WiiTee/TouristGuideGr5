package com.example.touristguide.repository;

import com.example.touristguide.model.Tags;
import com.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AttractionRepository {

    private int nextId = 0;

    private final ArrayList<TouristAttraction> attractions = new ArrayList<>();


    public AttractionRepository(){
        populateRepository();
    }

    private void populateRepository() {
        attractions.add(new TouristAttraction("Tivoli", "københavns største forlystelsespark", "København", new ArrayList<Tags>()));
        attractions.add(new TouristAttraction("Den lille Havfrue", "Danmarks mindste havfrue", "København", new ArrayList<Tags>()));
        attractions.add(new TouristAttraction("Råbjerg mile", "Danmarks største slette (der flytter sig)", "Skagen", new ArrayList<Tags>()));
    }

    public ArrayList<TouristAttraction> getAttractions() {
        return attractions;
    }

    public TouristAttraction getAttractionByName(String name) {

        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().toLowerCase().equals(name.toLowerCase())) return attraction;
        }

        return null;
    }

    public TouristAttraction getAttractionByNameWithTags(String name) {

        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) return attraction;
        }

        return null;
    }

    private int getNextId() {
        return nextId++;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        attraction.setId(nextId);
        attractions.add(attraction);
        return attraction;
    }

    public TouristAttraction editAttraction(String attractionName, String newDescription, String newCity, ArrayList<Tags> newTagList) {
        TouristAttraction attractionToEdit = getAttractionByName(attractionName);
        if (attractionToEdit != null) {
            attractionToEdit.setDescription(newDescription);
            attractionToEdit.setCity(newCity);
            attractionToEdit.setSelectedTags(newTagList);
        }
        return attractionToEdit;
    }

    public TouristAttraction deleteAttraction(String attractionName) {
        TouristAttraction attractionToDelete = getAttractionByName(attractionName);
        attractions.remove(attractionToDelete);
        return attractionToDelete;
    }

}


