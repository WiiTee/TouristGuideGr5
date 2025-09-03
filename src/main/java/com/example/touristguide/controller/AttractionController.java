package com.example.touristguide.controller;

import com.example.touristguide.model.Tags;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.AttractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

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
    public String getAttractions(Model model) {
        List<TouristAttraction> touristAttractions = service.getAttractions();
        model.addAttribute("attractionsList", touristAttractions);
        return "attractionsList";
    }

    @GetMapping("/{name}")
    public String getAttractionsByName(@PathVariable String name, Model model){

        TouristAttraction attraction = service.getAttractionByName(name);
        model.addAttribute("byName", attraction);

        return "attractionsList";
    }

    @GetMapping("/{name}/tags")
    public String getAttractionsByNameWithTags(@PathVariable String name, Model model){

        TouristAttraction attraction = service.getAttractionByNameWithTags(name);
        model.addAttribute("attraction", attraction);

        return "showTags";
    }

    //POST
    @GetMapping("/add")
    public String addAttraction (Model model) {
        TouristAttraction attractionToAdd = new TouristAttraction();
        model.addAttribute("attraction", attractionToAdd);
        return "newAttractionForm";
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
