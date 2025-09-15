package com.example.touristguide.controller;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.AttractionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(AttractionController.class)
class AttractionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AttractionService attractionService;

    @Test
    void shouldShowAttractionList() throws Exception {
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("showAllAttractions"));
    }

    @Test
    void shouldShowAttraction() throws Exception {

        TouristAttraction attraction = new TouristAttraction();
        attraction.setName("Tivoli");

        when(attractionService.getAttractionByName("tivoli")).thenReturn(attraction);

        mockMvc.perform(get("/attractions/tivoli"))
                .andExpect(status().isOk())
                .andExpect(view().name("showAttraction"));
    }
}