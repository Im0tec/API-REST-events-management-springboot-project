/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */

package com.semester5.ac1.pooii.ac1_190309.controllers;

import javax.validation.Valid;

import com.semester5.ac1.pooii.ac1_190309.dto.EventDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.EventRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.EventUpdateDTO;
import com.semester5.ac1.pooii.ac1_190309.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(

        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
        @RequestParam(value = "name", defaultValue = "") String name,
        @RequestParam(value = "place", defaultValue = "") String place,
        @RequestParam(value = "description", defaultValue = "") String description,
        @RequestParam(value = "startDate", defaultValue = "") String date
    ){

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page <EventDTO> list = service.getEvents(pageRequest, name, place, description, date);

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

    @PutMapping("{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @Valid @RequestBody EventUpdateDTO updateDto){

        EventDTO dto = service.update(id, updateDto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
