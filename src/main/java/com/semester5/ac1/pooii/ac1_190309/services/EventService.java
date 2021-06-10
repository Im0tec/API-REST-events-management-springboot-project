/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO.EventDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO.EventRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO.EventUpdateDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.TicketsDTO.TicketRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.entities.Attend;
import com.semester5.ac1.pooii.ac1_190309.entities.Event;
import com.semester5.ac1.pooii.ac1_190309.entities.Place;
import com.semester5.ac1.pooii.ac1_190309.entities.Ticket;
import com.semester5.ac1.pooii.ac1_190309.entities.type.TicketType;
import com.semester5.ac1.pooii.ac1_190309.repositories.AdminRepository;
import com.semester5.ac1.pooii.ac1_190309.repositories.AttendRepository;
import com.semester5.ac1.pooii.ac1_190309.repositories.EventRepository;
import com.semester5.ac1.pooii.ac1_190309.repositories.PlaceRepository;
import com.semester5.ac1.pooii.ac1_190309.repositories.TicketRepository;

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

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private AttendRepository attendRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String description, String date){

        //If date is empty, it means date was not searched
        if(date.isEmpty()){
            Page <Event> list = repository.findEventPageable(pageRequest, name, description);
            return list.map( e -> new EventDTO(e) );
        }
        else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            try{
                Page<Event> list = repository.findEventPageable_Date(pageRequest, name, description, LocalDate.parse(date,formatter));
                return list.map( e -> new EventDTO(e) );
            }
            catch(DateTimeParseException e){
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "  ''That's what i'm trying to tell you, kid. It ain't there. It's been totally blown away''       Invalid! Insert the date correctly (dd/MM/yyyy)");
            }
        }
    }

    public EventDTO getEventById(Long id){
        
        Optional<Event> op = repository.findById(id);
        Event event = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        
        return new EventDTO(event);
    }

    public EventDTO register(EventRegisterDTO dto){

        try{

            //Check if the admin ID inserted on event register exists or belongs to an Admin
            if(adminRepository.findById(dto.getAdmin().getId()).isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The id inserted in ''adminID'' does not exist or does not belong to an administrator");
            }
            
            Event entity = new Event(dto);
            registerCheckControl(entity.getStart_date(), entity.getEnd_date(), entity.getStart_time(), entity.getEnd_time(), entity, repository.findAll());
            entity = repository.save(entity);
    
            return new EventDTO(entity);
        }
        catch(DateTimeParseException e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "  ''That's what i'm trying to tell you, kid. It ain't there. It's been totally blown away''       Invalid! Insert the date correctly (dd/MM/yyyy)");
        }
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

    /*-----------------------------------------------------------------------------------------------------------------*/
    /* Event -> Place POST and DELETE below */

    public void eventPlaceConnection(Long eventID, Long placeID) {

        eventPlaceConnectionChecks(eventID, placeID);

        //Event
        Optional<Event> ev = repository.findById(eventID);
        Event event = ev.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        
        //Place
        Optional<Place> pl = placeRepository.findById(placeID);
        Place place = pl.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));
        
        event.addPlaces(place);
        place.addEvents(event);
        
        repository.save(event);
        placeRepository.save(place);
    }
    
    public void eventPlaceDelete(Long eventID, Long placeID) {

        //Event
        Optional<Event> ev = repository.findById(eventID);
        Event event = ev.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        
        //Place
        Optional<Place> pl = placeRepository.findById(placeID);
        Place place = pl.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));
        
        event.removePlaces(place);
        place.removeEvents(event);
        
        repository.save(event);
        placeRepository.save(place);
    }
    
    /*-----------------------------------------------------------------------------------------------------------------*/
    /* Event -> Ticket GET, POST and DELETE below */

    public void buyingTicket(Long eventID, @Valid TicketRegisterDTO ticketDTO) {
        
        //Event
        Optional<Event> ev = repository.findById(eventID);
        Event event = ev.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        
        //Attend
        Optional<Attend> at = attendRepository.findById(ticketDTO.getAttend().getId());
        Attend attend = at.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The attend ID inserted does not exists or does not belong to an attend"));

        buyingTicketsControl(event, attend, ticketDTO);

        Ticket ticket = new Ticket(ticketDTO, event.getPriceTicket(), event);
                
        ticketRepository.save(ticket);
    }

    /*-----------------------------------------------------------------------------------------------------------------*/
    /* Necessary validations below */

    public void registerCheckControl(LocalDate init_date, LocalDate end_date, LocalTime init_time, LocalTime end_time, Event event, List<Event> events){

        /* -------------- EVENT REGISTER VALIDATIONS BELOW -------------- */

        //Check if event's end date is superior than start date.
        if(end_date.compareTo(init_date) < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("  ''Time is relative, okay? It can stretch and it can squeeze, but… it can’t run backwards. Just can’t.''       Invalid! The end date must be superior than start date..."));
        }

        //Check if an event has its schedules correctly inserted (Start time superior than end time).
        if(init_time.compareTo(end_time) > 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("  ''Time is relative, okay? It can stretch and it can squeeze, but… it can’t run backwards. Just can’t.''       Invalid! The end time must be superior than start time..."));
        }

        //Check if start date is superior than system date.
        if(init_date.compareTo(LocalDate.now()) < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("  ''Wait a minute, Doc. Are you telling me you built a time machine....out of DeLorean?''       Invalid! The start date must be superior than system date..."));
        }

        //Check if end date is superior than system date.
        if(end_date.compareTo(LocalDate.now()) < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("  ''Wait a minute, Doc. Are you telling me you built a time machine....out of DeLorean?''       Invalid! The end date must be superior than system date..."));
        }

        /*
        *
        * It's commented because theoretically you can register many events with the same start and end date
        * but at the connection between place and event it must be taken into consideration, cause many events can start and end
        * in the same time but not in the same place.
        *
        * This check is being done (with some changes) in the method below (eventPlaceConnectionChecks).
        *
        * ----------------------------------------------------------------------------------------------
        *
        * Check if an event has been already registred.
        *
        *   for(Event aux: events){
        *
        *    if(aux != event){
        *
        *           if(!(init_date.compareTo(aux.getStart_date()) < 0 && end_date.compareTo(aux.getEnd_date()) < 0) && !(end_date.compareTo(aux.getEnd_date()) > 0 && init_date.compareTo(aux.getEnd_date()) > 0)){
        *               throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("  ''Same matter can not occupy same space...''       Invalid! There is already an event registred on this date..."));
        *           }
        *       
        *       }
            }
        */

    }
    
    public void eventPlaceConnectionChecks(Long eventID, Long placeID) {

        /* -------------- CONNECTION(EVENT AND PLACE) VALIDATIONS BELOW -------------- */

        //Get all the events of the place inserted
        List<Event> eventsOfPlace = placeRepository.findById(placeID).get().getEvents();

        //Get all the places of the event inserted
        List<Place> placesOfEvents = repository.findById(eventID).get().getPlaces();

        //Check if exist an event with the id inserted.
        if(repository.findById(eventID).isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("  ''That's what i'm trying to tell you, kid. It ain't there. It's been totally blown away''       Invalid! The event ID inserted doesn't even exists."));
        }
        
        //Check if exist a place with the id inserted.
        if(placeRepository.findById(placeID).isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("  ''That's what i'm trying to tell you, kid. It ain't there. It's been totally blown away''       Invalid! The place ID inserted doesn't even exists."));
        }

        //Check if the event has already located in the place inserted (avoiding duplicate data).
        for(Event event: eventsOfPlace){

            for(Place place: placesOfEvents){

                if(event.getId() == place.getId()){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("  ''Same matter can not occupy same space...''       Invalid! This event has already located in this place"));
                }
            }
        }


        Optional<Event> event = repository.findById(eventID);

        //Check if there is an event with the same start and end date in the place inserted.
        for(Event aux: eventsOfPlace){
            if(!(event.get().getStart_date().compareTo(aux.getStart_date()) < 0 && event.get().getEnd_date().compareTo(aux.getEnd_date()) < 0) && !(event.get().getEnd_date().compareTo(aux.getEnd_date()) > 0 && event.get().getStart_date().compareTo(aux.getEnd_date()) > 0)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("  ''Same matter can not occupy same space...''       Invalid! There is already an event registred on this date in this place..."));
            }
        }
    }

    public void buyingTicketsControl(Event event, Attend attend, TicketRegisterDTO ticketDTO){
        
        /* -------------- TICKETS VALIDATIONS BELOW -------------- */ 

        //Some checks for FREE tickets
        if(ticketDTO.getType() == TicketType.FREE){
            
            if(event.getAmountFreeTickets() > 0){
                
                //Check if there is any FREE ticket available to be sold.
                int cont = 0;
                for(Ticket aux: event.getTickets()){

                    if(aux.getType() == TicketType.FREE) cont++;
                }
                if(cont == event.getAmountFreeTickets()){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid! Free tickets has been sold out..."));
                }
            }
            else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid! This event does not have free tickets."));
            }
        }
        
        //Some checks for PAID tickets
        if(ticketDTO.getType() == TicketType.PAYED){
            
            if(event.getAmountPayedTickets() > 0){
                
                //Check if there is any PAID ticket available to be sold.
                int cont = 0;
                for(Ticket aux: event.getTickets()){

                    if(aux.getType() == TicketType.PAYED) cont++;
                }

                if(cont == event.getAmountPayedTickets()){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid! Paid tickets has been sold out..."));
                }

                //Check if attend's balance is negative, cause if it does, the attend will not be allowed to buy a ticket.
                if(attend.canBuyTicket(event.getPriceTicket()) == false){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid! This attend does not have enough balance to complete this purchase."));
                }
            }
            else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid! This event does not have paid tickets."));
            }
        }
    }

}

