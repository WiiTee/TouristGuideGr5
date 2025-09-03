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
        return new ResponseEntity<>(this.service.getAttractionByName(name), HttpStatus.OK);
    }

    //POST
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction (@RequestBody TouristAttraction attraction) {
        return new ResponseEntity<>(this.service.addAttraction(attraction), HttpStatus.CREATED);
    }

    @PostMapping("/update/name/{name}")
    public ResponseEntity<TouristAttraction> editAttractionName(@PathVariable String name, @RequestParam String newName) {
        return new ResponseEntity<>(this.service.editAttractionName(name, newName), HttpStatus.OK);
    }

    @PostMapping("/update/description/{name}")
    public ResponseEntity<TouristAttraction> editAttractionDescription(@PathVariable String name, @RequestParam String newDescription) {
        return new ResponseEntity<>(this.service.editAttractionDescription(name, newDescription), HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        return new ResponseEntity<>(this.service.deleteAttraction(name), HttpStatus.OK);
    }
}
