package com.example.touristguide.controller;

import com.example.touristguide.model.Tags;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.AttractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
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

        return "showAttraction";
    }

    @GetMapping("/add")
    public String addAttraction (Model model) {
        TouristAttraction attractionToAdd = new TouristAttraction();
        model.addAttribute("attraction", attractionToAdd);
        return "newAttractionForm";
    }

    @GetMapping("/{name}/edit")
    public String editAttractionDescription(@PathVariable String name, Model model) {
        TouristAttraction attraction = service.getAttractionByName(name);
        Tags[] tagList = Tags.values();

        if(attraction == null){
            throw new IllegalArgumentException("Attraction does not exist");
        }

        model.addAttribute("attraction", attraction);
        model.addAttribute("tags", tagList);

        return "updateAttractionForm";
    }

    //POST

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction){
        ArrayList<Tags> selectedTags = attraction.getSelectedTags();
        service.addAttraction(attraction);
        return "redirect:/attractions";
    }

    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction attraction){

        service.editAttraction(attraction);


        return "redirect:/attractions";
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        TouristAttraction attractionToDelete = this.service.deleteAttraction(name);

        HttpStatus httpResponseCode = HttpStatus.BAD_REQUEST;
        if (attractionToDelete != null) httpResponseCode = HttpStatus.OK;

        return new ResponseEntity<>(attractionToDelete, httpResponseCode);
    }
}
