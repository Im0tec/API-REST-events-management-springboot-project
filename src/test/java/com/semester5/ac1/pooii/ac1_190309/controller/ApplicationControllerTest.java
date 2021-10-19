package com.semester5.ac1.pooii.ac1_190309.controller;

import com.semester5.ac1.pooii.ac1_190309.controllers.EventController;
import com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO.EventDTO;
import com.semester5.ac1.pooii.ac1_190309.entities.Place;
import com.semester5.ac1.pooii.ac1_190309.services.EventService;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class ApplicationControllerTest {
    
    @Autowired
    private EventController eventController;

    @MockBean
    private EventService eventService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.eventController);
    }

    // Should Return Success When Search Events By GET Request.
   /*  @Test
    public void shouldReturnSuccess_WhenSearchEvents() {
        
        when(this.eventService.getEvents(PageRequest.of(0, 1), "", "", ""))
        
        given().accept(ContentType.JSON).
        when().get("/events").
        then().statusCode(HttpStatus.OK.value());
    } */

    // Should Return Success When Search Event With It's ID By GET Request.
    @Test
    public void shouldReturnSuccess_WhenSearchEventById() {
        
        List<Place> places = new ArrayList<>();

        when(this.eventService.getEventById(1L)).
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
        ));

        given().accept(ContentType.JSON).
        when().get("/events/{id}", 1L).
        then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void teste() {

        given().accept(ContentType.JSON).
        when().delete("/events/{id}", 1L).
        then().statusCode(HttpStatus.NO_CONTENT.value());
    }
}
