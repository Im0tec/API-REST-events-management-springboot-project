package com.semester5.ac1.pooii.ac1_190309.controller;

import com.semester5.ac1.pooii.ac1_190309.controllers.EventController;
import com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO.EventDTO;
import com.semester5.ac1.pooii.ac1_190309.entities.Place;
import com.semester5.ac1.pooii.ac1_190309.services.EventService;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EventController.class)
public class ApplicationControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private EventService eventService;
    
    @Autowired
    private EventController eventController;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.eventController);
    } 

    /*
    ======================================
    ========== EVENT CONTROLLER ==========
    ==========     TESTS        ==========
    ======================================
    */

    // Should return success when search events by GET request.
    @Test
    public void shouldReturnSuccess_WhenSearchEvents() {
        given().
        mockMvc(mockMvc).
        when().get("/events").
        then().statusCode(HttpStatus.OK.value());
    }

    // Should return success when search event with it's ID by GET request.
    @Test
    public void shouldReturnSuccess_WhenSearchEventById() {
        
        //🛑 Under construction 🛑

        /*when(eventService.getEventById(1L)).
        thenReturn(new EventDTO(
            1L, 
            "Comic Con",
            "Comic event",
            "02/04/2000",
            "06/04/2000",
            LocalTime.of(10, 30, 0),
            LocalTime.of(22, 0, 0),
            "comicevent@comicon.com",
            0L,
            3000L,
            105.99,
            null,
            places
        ));*/
        given().
        mockMvc(mockMvc).
        accept(ContentType.JSON).
        when().get("/events/{id}", 1L).
        then().statusCode(HttpStatus.OK.value());
    }

    /*
    =============================
    ========== GENERAL ==========
    ==========  TESTS  ==========
    =============================
    */

    // Should return Not Found (404) when there is a wrong path in the link.
    @Test
    public void ShouldReturnNotFound_WhenUseWrongPath() {
        given().
        mockMvc(mockMvc).
        when().get("/anypath").
        then().statusCode(HttpStatus.NOT_FOUND.value());
    }
}
