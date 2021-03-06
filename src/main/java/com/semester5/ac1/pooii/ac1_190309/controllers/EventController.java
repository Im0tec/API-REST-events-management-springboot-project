/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */

package com.semester5.ac1.pooii.ac1_190309.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO.EventDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO.EventRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO.EventUpdateDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.TicketsDTO.TicketDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.TicketsDTO.TicketRegisterDTO;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
        @RequestParam(value = "description", defaultValue = "") String description,
        @RequestParam(value = "startDate", defaultValue = "") String date
    ){

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page <EventDTO> list = service.getEvents(pageRequest, name, description, date);

        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id){
        
        EventDTO dto = service.getEventById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EventDTO> register(@Valid @RequestBody EventRegisterDTO registerDTO){
        
        EventDTO dto = service.register(registerDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        
        return ResponseEntity.created(uri).body(dto);
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

    /*-----------------------------------------------------------------------------------------------------------------*/
    /* Event -> Place POST and DELETE below */

    @PostMapping("{eventID}/places/{placeID}")
    public ResponseEntity<Void> eventPlaceConnection(@PathVariable Long eventID, @PathVariable Long placeID){
        
        service.eventPlaceConnection(eventID, placeID);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{eventID}/places/{placeID}")
    public ResponseEntity<Void> eventPlaceDelete(@PathVariable Long eventID, @PathVariable Long placeID){

        service.eventPlaceDelete(eventID, placeID);

        return ResponseEntity.noContent().build();
    }

    /*-----------------------------------------------------------------------------------------------------------------*/
    /* Ticket GET, POST and DELETE below */

    @GetMapping("{eventID}/tickets")
    public ResponseEntity<TicketDTO> getTicketsFromEvent(@PathVariable Long eventID){
        
        TicketDTO dto = service.getTicketsFromEvent(eventID);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("{eventID}/tickets")
    public ResponseEntity<Void> buyingTicket(@PathVariable Long eventID, @Valid @RequestBody TicketRegisterDTO ticketDTO){

        service.buyingTicket(eventID, ticketDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{eventID}/tickets/{ticketID}")
    public ResponseEntity<Void> refoundTicket(@PathVariable Long eventID, @PathVariable Long ticketID){

        service.refoundTicket(eventID, ticketID);

        return ResponseEntity.noContent().build();
    }
}
