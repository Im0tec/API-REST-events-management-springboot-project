/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.semester5.ac1.pooii.ac1_190309.entities.Admin;
import com.semester5.ac1.pooii.ac1_190309.entities.Event;
import com.semester5.ac1.pooii.ac1_190309.entities.Place;

public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String start_date;
    private String end_date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String email;
    private Long amountFreeTickets;
    private Long amountPayedTickets;
    private Double priceTicket;
    private Admin admin;

    private List<Place> places = new ArrayList<>();
    
    public EventDTO(){

    }

    public EventDTO(Long id, String name, String description, String start_date, String end_date, LocalTime start_time,
            LocalTime end_time, String email, Long amountFreeTickets, Long amountPayedTickets, Double priceTicket,
            Admin admin, List<Place> places) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.email = email;
        this.amountFreeTickets = amountFreeTickets;
        this.amountPayedTickets = amountPayedTickets;
        this.priceTicket = priceTicket;
        this.admin = admin;
        this.places = places;
    }

    public EventDTO(Event event) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.start_date = event.getStart_date().format(formatter);
        this.end_date = event.getEnd_date().format(formatter);
        this.start_time = event.getStart_time();
        this.end_time = event.getEnd_time();
        this.email = event.getEmail();
        this.amountFreeTickets = event.getAmountFreeTickets();
        this.amountPayedTickets = event.getAmountPayedTickets();
        this.priceTicket = event.getPriceTicket();
        this.admin = event.getAdmin();
        this.places = event.getPlaces();
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }

    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }

    public Long getAmountPayedTickets() {
        return amountPayedTickets;
    }

    public void setAmountPayedTickets(Long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
