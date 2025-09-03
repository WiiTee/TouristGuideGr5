package com.example.touristguide.controller;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.AttractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

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
    @GetMapping("{name}")
    public String getAttractionsByName(@PathVariable String name, Model model){

        TouristAttraction attraction = service.getAttractionByName(name);
        model.addAttribute("byName", attraction);

        return "attractionsList";
    }

    //POST
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction (@RequestBody TouristAttraction attraction) {
        if (attraction.getName() == null || attraction.getName().isEmpty())  {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.service.addAttraction(attraction), HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public String saveAttraction(){
        return "";
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> editAttractionDescription(@RequestBody TouristAttraction withNewDescription) {
        TouristAttraction updatedAttraction = this.service.editAttractionDescription(withNewDescription.getName(), withNewDescription.getDescription());

        HttpStatus httpResponseCode = HttpStatus.BAD_REQUEST;
        if (updatedAttraction != null) httpResponseCode = HttpStatus.OK;

        return new ResponseEntity<>(updatedAttraction, httpResponseCode);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        TouristAttraction attractionToDelete = this.service.deleteAttraction(name);

        HttpStatus httpResponseCode = HttpStatus.BAD_REQUEST;
        if (attractionToDelete != null) httpResponseCode = HttpStatus.OK;

        return new ResponseEntity<>(attractionToDelete, httpResponseCode);
    }
}
