/*
 * NOME: Eduardo Campos Gonçalves - 190309
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.semester5.ac1.pooii.ac1_190309.dto.EventDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.EventRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.EventUpdateDTO;
import com.semester5.ac1.pooii.ac1_190309.entities.Event;
import com.semester5.ac1.pooii.ac1_190309.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EventService {
    
    @Autowired
    private EventRepository repository;

    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String place, String description){

        Page <Event> list = repository.findEventPageable(pageRequest, name, place, description);

        return list.map( e -> new EventDTO(e) );
    }

    public EventDTO getEventById(Long id){
        
        Optional<Event> op = repository.findById(id);
        Event event = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        
        return new EventDTO(event);
    }

    public EventDTO register(EventRegisterDTO dto){

        Event entity = new Event(dto);

        registerCheckControl(entity.getStart_date(), entity.getEnd_date(), entity.getStart_time(), entity.getEnd_time(), entity, repository.findAll());
        entity = repository.save(entity);

        return new EventDTO(entity);
    }

    public EventDTO update(Long id, EventUpdateDTO dto){

        try{

            Event entity = repository.getOne(id);

            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setEmail(dto.getEmail());

            entity = repository.save(entity);

            return new EventDTO(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }

        
    }

    public void delete(Long id){

        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
        
    }

    public void registerCheckControl(LocalDate init_date, LocalDate end_date, LocalTime init_time, LocalTime end_time, Event event, List<Event> events){

        //Check if an event has been already registred.
        for(Event aux: events){

            if(aux != event){

                if(!(init_date.compareTo(aux.getStart_date()) < 0 && end_date.compareTo(aux.getEnd_date()) < 0) && !(end_date.compareTo(aux.getEnd_date()) > 0 && init_date.compareTo(aux.getEnd_date()) > 0)){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid! There is already an event registred on this date..."));
                }
                
            }
        }

        //Check if event's start date is superior than end date.
        if(end_date.compareTo(init_date) < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid! The end date must be superior than the start date..."));
        }

        //Check if an event has its schedules correctly inserted (End time superior than start time).
        if(init_time.compareTo(end_time) > 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid! The end time must be superior than the start time..."));
        }

    }

}
