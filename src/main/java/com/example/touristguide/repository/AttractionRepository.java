package com.example.touristguide.repository;

import com.example.touristguide.model.Tags;
import com.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class AttractionRepository {

    private final ArrayList<TouristAttraction> attractions = new ArrayList<>();


    public AttractionRepository(){
        populateRepository();
    }

    private void populateRepository() {
        attractions.add(new TouristAttraction("Tivoli", "københavns største forlystelsespark", "København", new ArrayList<>(Arrays.asList(Tags.CHILDFRIENDLY, Tags.CONCERT, Tags.RESTAURANT, Tags.ENTERTAINMENT))));
        attractions.add(new TouristAttraction("Den lille Havfrue", "Danmarks mindste havfrue", "København", new ArrayList<>(Arrays.asList(Tags.ART, Tags.FREE))));
        attractions.add(new TouristAttraction("Råbjerg mile", "Danmarks største slette (der flytter sig)", "Skagen", new ArrayList<>(Arrays.asList(Tags.FREE, Tags.CHILDFRIENDLY, Tags.NATURE))));
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

    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    public void editAttraction(String attractionName, String newDescription, String newCity, ArrayList<Tags> newTagList) {
        TouristAttraction attractionToEdit = getAttractionByName(attractionName);
        if (attractionToEdit != null) {
            attractionToEdit.setDescription(newDescription);
            attractionToEdit.setCity(newCity);
            attractionToEdit.setSelectedTags(newTagList);
        }
    }

    public void deleteAttraction(String attractionName) {
        TouristAttraction attractionToDelete = getAttractionByName(attractionName);
        attractions.remove(attractionToDelete);
    }

}


