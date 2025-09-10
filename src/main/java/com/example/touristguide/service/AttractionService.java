package com.example.touristguide.service;

import com.example.touristguide.model.Tags;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.repository.AttractionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AttractionService {
    private final AttractionRepository repository;

    public AttractionService(AttractionRepository repository) {
        this.repository =repository;
    }

    public ArrayList<TouristAttraction> getAttractions(){
        return this.repository.getAttractions();
    }

    public TouristAttraction getAttractionByName(String name){
        return this.repository.getAttractionByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        return this.repository.addAttraction(attraction);
    }

    public TouristAttraction editAttractionDescription(TouristAttraction attraction){
        String name = attraction.getName();
        String newDescription = attraction.getDescription();
        ArrayList<Tags> newTags = attraction.getSelectedTags();
        String newCity = attraction.getCity();
        int id = attraction.getId();

        return this.repository.editAttractionDescription(name, newDescription, newCity, newTags);
    }

    public TouristAttraction deleteAttraction(String name){
        return this.repository.deleteAttraction(name);
    }
}
