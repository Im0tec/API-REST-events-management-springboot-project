package com.semester5.ac1.pooii.ac1_190309.dto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.semester5.ac1.pooii.ac1_190309.entities.Event;

public class EventDTO {

    private String name;
    private String description;
    private String place;
    private String start_date;
    private String end_date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String email;
    
    public EventDTO(){

    }
    
    public EventDTO(String name, String description, String place, String start_date, String end_date,
            LocalTime start_time, LocalTime end_time, String email) {
        this.name = name;
        this.description = description;
        this.place = place;
        this.start_date = start_date;
        this.end_date = end_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.email = email;
    }

    public EventDTO(Event event) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.name = event.getName();
        this.description = event.getDescription();
        this.place = event.getPlace();
        this.start_date = event.getStart_date().format(formatter);
        this.end_date = event.getEnd_date().format(formatter);
        this.start_time = event.getStart_time();
        this.end_time = event.getEnd_time();
        this.email = event.getEmail();
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

}
