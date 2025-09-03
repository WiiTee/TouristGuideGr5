package com.example.touristguide.repository;

import com.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AttractionRepository {

    private final ArrayList<TouristAttraction> attractions = new ArrayList<>();


    public AttractionRepository(){
        populateRepository();
    }

    private void populateRepository() {
        attractions.add(new TouristAttraction("Tivoli", "københavns største forlystelsespark"));
        attractions.add(new TouristAttraction("Den lille Havfrue", "Danmarks mindste havfrue"));
        attractions.add(new TouristAttraction("Råbjerg mile", "Danmarks største slette (der flytter sig)"));
    }

    public ArrayList<TouristAttraction> getAttractions() {
        return attractions;
    }

    public TouristAttraction getAttractionByName(String name) {

        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) return attraction;
        }

        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
        return attraction;
    }

    public TouristAttraction editAttractionDescription(String attractionName, String newDescription) {
        TouristAttraction attractionToEdit = getAttractionByName(attractionName);
        if (attractionToEdit != null) {
            attractionToEdit.setDescription(newDescription);
        }
        return attractionToEdit;
    }

    public TouristAttraction deleteAttraction(String attractionName) {
        TouristAttraction attractionToDelete = getAttractionByName(attractionName);
        attractions.remove(attractionToDelete);
        return attractionToDelete;
    }

}


