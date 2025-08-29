package com.example.touristguide.controller;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.AttractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/attractions")
public class AttractionController {
    private final AttractionService service;

    public AttractionController(AttractionService service) {
        this.service = service;
    }

    //mappings

    //GET
    @GetMapping
    public ResponseEntity<ArrayList<TouristAttraction>> getAttractions() {
        return new ResponseEntity<>(this.service.getAttractions(), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<TouristAttraction> getAttractionByName(@RequestParam String name) {
        TouristAttraction attraction = this.service.getAttractionByName(name);
        return new ResponseEntity<>(attraction, (attraction == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    //POST
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction (@RequestBody TouristAttraction attraction) {
        if (attraction.getName() == null)  {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>((attraction.getName() == null) ? this.service.addAttraction(attraction) : null, HttpStatus.CREATED);
    }

    @PostMapping("/update/name/{name}")
    public ResponseEntity<TouristAttraction> editAttractionName(@PathVariable String name, @RequestBody TouristAttraction withNewName) {
        TouristAttraction updatedAttraction = this.service.editAttractionName(name, withNewName.getName());
        return new ResponseEntity<>(updatedAttraction, (updatedAttraction == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @PostMapping("/update/description/{name}")
    public ResponseEntity<TouristAttraction> editAttractionDescription(@PathVariable String name, @RequestBody TouristAttraction withNewDescription) {
        TouristAttraction updatedAttraction = this.service.editAttractionDescription(name, withNewDescription.getDescription());
        return new ResponseEntity<>(updatedAttraction, (updatedAttraction == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        TouristAttraction attractionToDelete = this.service.deleteAttraction(name);
        return new ResponseEntity<>(attractionToDelete, (attractionToDelete == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }
}
