package com.semester5.ac1.pooii.ac1_190309.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.semester5.ac1.pooii.ac1_190309.dto.EventDTO;
import com.semester5.ac1.pooii.ac1_190309.entities.Event;
import com.semester5.ac1.pooii.ac1_190309.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EventService {
    
    @Autowired
    private EventRepository repository;

    public List<EventDTO> getEvents(){

        List <Event> list = repository.findAll();
        List <EventDTO> listDTO = new ArrayList<>();

        for(Event e: list){
            
            EventDTO dto = new EventDTO(e.getName(), e.getDescription(), e.getPlace(), e.getStart_date(),
            e.getEnd_date(), e.getStart_time(), e.getEnd_time(), e.getEmail());
            listDTO.add(dto);

        }

        return listDTO;
    }

    public EventDTO getEventById(Long id){
        
        Optional<Event> op = repository.findById(id);
        Event event = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        
        return new EventDTO(event);
    }
}
