package com.semester5.ac1.pooii.ac1_190309.controllers;

import java.util.List;

import javax.validation.Valid;

import com.semester5.ac1.pooii.ac1_190309.dto.EventDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.EventRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvents(){

        List <EventDTO> list = service.getEvents();

        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id){
        
        EventDTO dto = service.getEventById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EventDTO> register(@Valid @RequestBody EventRegisterDTO registerDTO){

        return ResponseEntity.ok(service.register(registerDTO));
    }
}
