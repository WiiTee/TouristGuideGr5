package com.example.touristguide.service;

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

    public TouristAttraction getAttractionByNameWithTags(String name){
        return this.repository.getAttractionByNameWithTags(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        return this.repository.addAttraction(attraction);
    }

    public TouristAttraction editAttractionDescription(String name, String newDescription){
        return this.repository.editAttractionDescription(name, newDescription);
    }

    public TouristAttraction deleteAttraction(String name){
        return this.repository.deleteAttraction(name);
    }
}
