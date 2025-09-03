package com.example.touristguide.controller;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.AttractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = this.service.getAttractionByName(name);

        HttpStatus httpResponseCode = HttpStatus.BAD_REQUEST;
        if (attraction != null) httpResponseCode = HttpStatus.OK;

        return new ResponseEntity<>(attraction, httpResponseCode);
    }

    //POST
    @GetMapping("/add")
    public String addAttraction (Model model) {
        TouristAttraction attractionToAdd = new TouristAttraction();
        model.addAttribute("attraction", attractionToAdd);
        return "newAttractionForm";
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
